# Product

<!-- impeccable:product-schema 1 -->

## Platform

android

## Users

The whole household of one home, sharing a single Xiaomi TV in the living room. Mixed technical comfort: not everyone is a power user. They sit on the couch, roughly 2–3 m from the screen, using only the Xiaomi D-pad remote (no touch, no mouse, no keyboard). Their job: get from "TV on" into a streaming app as fast as possible.

## Product Purpose

A bloatware-free, premium and light replacement home screen (launcher) for a low-RAM Xiaomi Android TV, replacing PatchWall (~140 MB idle, ~190 MB measured while another app plays). It exists to free memory, make the TV feel faster, and look better than the stock home screen. Success means:

- the launcher uses a small fraction of PatchWall's memory, which `scripts/mem.sh` logs before and after the switch;
- any household member can open their app within a couple of remote presses;
- nobody gets lost or stuck.

## Positioning

A doorway, not a destination. Unlike PatchWall or Google TV Home, it shows no content feeds, recommendations or ads, and runs no background services. It is just the household's apps, reachable instantly, on hardware where every MB of RAM matters.

## Operating Context

- Device: Xiaomi MiTV-AXSO2 ("dangalUHD"). Android 9 (API 28), 32-bit ARM only (armeabi-v7a), OpenGL ES 2.0, 2 GB RAM with ~550 MB reserved for video hardware, per-app heap limit of 192 MB.
- Display: 1920×1080 at 320 dpi, which is 960×540 dp to the layout system. Viewed from the couch.
- Input: D-pad, OK, Back and Home on the Xiaomi remote. The remote mic button is not supported, because katniss (Google voice search) will be disabled.
- Starting watching: usually by opening a streaming app, or by switching to the **Jio set-top box on HDMI 3**. That port was verified on 2026-11-03: it is the only HDMI input reporting a connected state with an active stream config; HDMI 1, HDMI 2 and AV report standby.
- Ports: HDMI 1 (ARC), HDMI 2, HDMI 3, AV (composite), Antenna (DTV/ATV tuner), plus SPDIF and AUX audio. HDMI-CEC is off (`hdmi_control_enabled=0`), so device names are not available; HDMI receiver status in sysfs needs root.
- Installed apps (Nov 2026): Netflix, Prime Video, YouTube, YouTube Music, Hotstar, SonyLIV, ZEE5, Airtel Xstream, Crunchyroll, Spotify, VLC, Google TV/Play Movies, Play Store, Play Games, Live TV (com.android.tv), and Xiaomi media/gallery/smartshare/tvmanager apps.

## Capabilities and Constraints

Home screen contents, as confirmed by the user:

- **Who's watching** picker on open: Bikash, Sonia, Hardik, Abhinav, Other. No PIN. The profile drives favourites order and Continue Watching.
- **Continue Watching** row, per profile, with real titles. Sources: Netflix, Prime Video, JioHotstar, SonyLIV, ZEE5, YouTube. Mechanism: a NotificationListenerService (granted via `adb shell cmd notification allow_listener`) reads MediaSession metadata and position and attributes it to the active launcher profile.
  - Verified for Prime Video: it publishes MEDIA_ID `amzn1.dv.gti.*` and position, with no title, duration or artwork. Its public page `primevideo.com/detail/<gti>/` gives the title (`<title>`) and poster (`og:image`); confirmed by the user with "The Grand Tour – Season 1".
  - Verified for JioHotstar (`in.startv.hotstar`): it publishes TITLE (the episode only, e.g. "S3 E11 Santa's Village of the Damned"), DURATION, position, and a MEDIA_URI whose path holds the show and episode IDs. It publishes no artwork anywhere; Google's NowPlaying notification shows only a placeholder. Decided by the user: learn the show name once per show ID from the on-screen player overlay (accessibility service) and cache it, then get the poster and episode still from the TVmaze public API (verified for Two and a Half Men S3E11). Ignore sessions under 60 s, since those are ads. Store only the numeric IDs from MEDIA_URI and never the signed token or user ID.
  - Verified for YouTube (`com.google.android.youtube.tv`): TITLE, ARTIST (the channel), DURATION, position and ART (a thumbnail bitmap) all come straight from the session. It provides no video ID, so the tile reopens the app rather than the exact video. Shorts never appear in Continue Watching (user requirement). The session carries no Shorts flag, so skip any YouTube session with DURATION ≤ 180 s, since Shorts run up to 3 minutes; this also drops regular videos of 3 minutes or less.
  - Removing items: long-press OK on a Continue Watching tile opens a menu with "Remove from Continue watching" and "Cancel". Removal applies only to the current profile's list, the row reflows, and focus moves to the neighbouring tile. The placeholder tile cannot be removed.
  - Netflix, SonyLIV and ZEE5: deferred by the user (2026-11-02). They are not probed; their tiles use the fallback until they are tested. Planned fallbacks, in order: metadata title/art, catalogue lookup by ID, an accessibility service reading the on-screen title, then app logo plus "watched X ago". Never show wrong data.
  - Only sessions recorded after install appear. Third-party apps cannot be read for prior history, the in-app profile cannot be selected from outside, and the system Watch Next table is empty on this TV, with cross-app reads requiring `signature|privileged`.

- **Favourites row:** pinned, reorderable apps; this is the primary surface.
- **All apps grid:** every launchable app.
- **Settings / Wi-Fi / quick toggles:** shortcuts to system settings and network.
- **Screensaver** (replaces the sleep timer; the user does not want auto-sleep): one press from the control bar starts an ambient screen with a large clock and date over classy generated wallpapers: dunes at dusk, moon over water, mountains at blue hour, gold contours, and a soft mesh of light. No posters and no title art (user requirement). Any button returns to home. Also registered as the system DreamService, replacing `com.google.android.backdrop`, so it starts on idle.
  - Minimum power: wallpapers are static and crossfade every 3 minutes, the clock redraws once a minute, and the GPU idles in between. The backlight dims after 1 minute via the DreamService/window brightness override. The panel uses the `aml-bl` backlight; whether Xiaomi honours the override must be verified on the device. Never sleep or standby.
- **Control bar** (top right, icons only; the focused icon opens its label), in order:
  1. **Jio Set-top Box:** one press switches to HDMI 3. Always first (user requirement).
  2. **Inputs:** a panel with every port and its live state.
  3. **Wi-Fi:** the current network, band, link speed and signal, plus links to Android's network screens. Password entry stays in Android's own settings.
  4. **Settings:** tiles that open the TV's own Picture, Sound, Display, Apps, Network and All settings screens. Picture controls cannot be changed directly by a third-party app.
  5. **Screensaver.**
  6. **All apps:** a full-screen grid of every launchable app, excluding PatchWall, Xiaomi TV+, Help and the launcher itself.
  7. **Profile:** opens Who's watching.
- **Clock:** visible on home.
- **Favourites** include YouTube.
- **Not included:** voice or search entry (katniss disabled), content feeds, recommendations.

Technical constraints:

- Kotlin with plain Views and RecyclerView. No Compose, no AppCompat.
- Memory budget: keep PSS minimal (the stub app measures ~14 MB). No heavy animations, blur effects or large images held in memory.
- Registers as HOME and LEANBACK_LAUNCHER.

Open decisions:

- Which apps start in the Favourites row. Never answered; the design demo uses Netflix, Prime Video, YouTube, JioHotstar, SonyLIV and ZEE5.
- Display calibration (picture modes and test patterns, using the MacBook Pro in its BT.709/BT.1886 preset as reference): deferred by the user to the end of the project.
- Whether reordering favourites happens on the TV or through config.

## Brand Commitments

Visual direction, binding from the user: inspired by Apple's Liquid Glass, behaving like real glass that refracts and bends what is behind it. On GLES 2.0 and API 28 there is no live blur (RenderEffect needs API 31+), so the refraction must be prebaked or come from a cheap shader over a mostly static backdrop.

## Product Principles

1. **Speed is the feature.** Every choice is weighed against memory use and how fast launch and focus feel on weak hardware.
2. **Obvious from the couch.** Any household member can read the screen and know where the focus is from across the room.
3. **Never stuck.** Back and Home always lead somewhere sensible, and a broken state can't trap anyone.
4. **Only what the household uses.** No feeds, no promotions, no clutter.

## Accessibility & Inclusion

Mixed-ability household viewing from 2–3 m away: text must be legible at that distance, the focused item must be unmistakable, and nothing can depend on touch or fine motor control.

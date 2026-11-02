# TVOS

A bloatware-free, premium and light home screen for a Xiaomi Android TV.

TVOS replaces Xiaomi's PatchWall launcher on the **Xiaomi MiTV-AXSO2**, a mid-range set with Android 9, 2 GB of RAM and a Mali-450 GPU. On that TV PatchWall uses about 140 MB of memory when idle and about 190 MB while another app plays. TVOS aims to use a small fraction of that, and to look better doing it.

> **Status:** the design is approved and the build pipeline works. The launcher itself is being built; so far the app is a stub plus a few on-device probes.

## Goals

- **Bloatware-free:** no feeds, ads, recommendations or background services. Only the household's apps, one or two presses away.
- **Premium:** "Night glass", a glass design inspired by Apple's Liquid Glass, Apple TV and visionOS, with real refraction, dispersion and Fresnel highlights.
- **Light:** plain Kotlin Views with no Compose or AppCompat. A single GLES 2.0 shader pipeline draws the glass, and the GPU idles whenever nothing moves.

## Features (designed)

- **Who's watching:** one profile per household member. Continue watching and favourites follow the profile.
- **Continue watching with real titles:** read from Android media sessions, with posters looked up where an app doesn't provide them. Verified on the TV:

  | App | What it provides | How the tile gets its title and poster |
  |---|---|---|
  | YouTube | Title, channel, duration, thumbnail | Used directly. Shorts are skipped. |
  | Prime Video | Catalogue ID only | Title and poster from Prime's public page |
  | JioHotstar | Episode title, progress, show ID | Show name read once from the player overlay; poster from TVmaze |

  Long-press OK on a tile to remove it.
- **Favourites:** each app's own TV banner. The top area glows in the app's colour, taken from that banner.
- **Control bar:** an icon-only frosted pill with a gliding glass lens. In order:
  1. **Jio Set-top Box** (one press to HDMI 3)
  2. **Inputs**
  3. **Wi-Fi**
  4. **Settings**
  5. **Screensaver**
  6. **All apps**
  7. **Profile**
- **Screensaver:** a large clock over classy generated wallpapers. It dims the backlight and never sleeps.
- **D-pad first:** each row remembers your position, and Back always leads somewhere sensible.

Product decisions are in [`PRODUCT.md`](PRODUCT.md). The visual system is in [`DESIGN.md`](DESIGN.md).

## Target hardware

| | |
|---|---|
| TV | Xiaomi MiTV-AXSO2 (Amlogic T962X, 4× Cortex-A53, 32-bit userspace) |
| OS | Android 9 (API 28) |
| GPU | ARM Mali-450 MP: OpenGL ES 2.0, 16-bit fragment precision |
| Display | 1920×1080 at 60 Hz, 320 dpi (960×540 dp) |
| RAM | 2 GB total; about 550 MB reserved for video, about 560–830 MB free in use |

## Build and install

Requirements:
- **JDK 25.** Its path is pinned in `gradle.properties`; change `org.gradle.java.home` if yours is elsewhere.
- **Android SDK** with platform 36 and build-tools 36.x. `local.properties` points to it and isn't committed.
- **The TV** reachable over ADB (Developer options → USB/network debugging).

```sh
export TV_DEVICE=192.168.x.x:5555   # your TV's address
scripts/deploy.sh                   # build debug, install and launch
scripts/deploy.sh release           # minified release build
```

Toolchain: Gradle 9.8.2 (wrapper), Android Gradle Plugin 9.5.0 with built-in Kotlin, `compileSdk 36`, `minSdk`/`targetSdk 28`.

## Measuring memory

```sh
scripts/mem.sh baseline-patchwall   # snapshot before switching
scripts/mem.sh tvos                 # snapshot after
```

Each run saves total, free and used RAM, the PSS of the launcher, PatchWall, Google's tvlauncher and katniss, and the top 15 processes to `mem-logs/` (which isn't committed).

## Probes (debug only)

The current app includes two debug helpers used during design:
- **`MediaProbeService`:** a notification listener that logs every media-session field apps publish. Enable it with:
  ```sh
  adb shell cmd notification allow_listener dev.tvos.launcher/.MediaProbeService
  ```
- **`MainActivity --ez dumpIcons true`:** writes every launchable app's TV banner, icon and name to the app's files folder.

Both will be removed or replaced in the real launcher.

## Roadmap

1. Shell: register as HOME and LEANBACK_LAUNCHER, D-pad focus with row memory, control bar, Who's watching.
2. Glass renderer: the GLES 2.0 pipeline from the design.
3. Rows: Favourites, All apps, and the control bar actions (Jio input, Inputs, Wi-Fi, Settings).
4. Continue watching: a session store per profile, poster lookup, on-disk cache.
5. Screensaver as a DreamService.
6. Measure against PatchWall, then disable bloat: Xiaomi TV+, analytics, Help and auto-installers.
7. Display calibration helper: test patterns, with a MacBook in its BT.709 preset as the reference.

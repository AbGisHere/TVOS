---
name: TV-OS
description: Night glass. A light Android TV launcher whose surfaces are clear, refracting glass slabs over the household's own artwork.
colors:
  night-floor: "#030304"
  overlay-scrim: "rgba(6, 7, 11, 0.72)"
  toast-surface: "rgba(20, 22, 30, 0.78)"
  ink: "#ffffff"
  ink-heading: "rgba(255, 255, 255, 0.86)"
  ink-body: "rgba(255, 255, 255, 0.78)"
  ink-meta: "rgba(255, 255, 255, 0.66)"
  ink-quiet: "rgba(255, 255, 255, 0.55)"
  glass-lit: "rgba(255, 255, 255, 0.24)"
  glass-well: "rgba(255, 255, 255, 0.06)"
  track: "rgba(255, 255, 255, 0.18)"
  rim-reflection: "#d9e0f2"
  live-green: "#5ad38a"
  remove-blush: "#ffc2b8"
typography:
  display:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "112px"
    fontWeight: 300
    lineHeight: 0.9
    letterSpacing: "-0.04em"
    fontFeature: "\"tnum\""
  headline:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "50px"
    fontWeight: 700
    lineHeight: 1
    letterSpacing: "-0.035em"
  headline-sm:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "40px"
    fontWeight: 700
    letterSpacing: "-0.03em"
  title-lg:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "28px"
    fontWeight: 700
    letterSpacing: "-0.025em"
  clock:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "26px"
    fontWeight: 600
    letterSpacing: "-0.02em"
    fontFeature: "\"tnum\""
  title:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "17px"
    fontWeight: 700
    lineHeight: 1.1
    letterSpacing: "-0.015em"
  panel-title:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "16px"
    fontWeight: 700
    letterSpacing: "-0.01em"
  row-heading:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "15px"
    fontWeight: 600
    letterSpacing: "-0.01em"
  body:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "14px"
    fontWeight: 500
    letterSpacing: "-0.005em"
  label:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "13px"
    fontWeight: 600
  label-sm:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "12.5px"
    fontWeight: 600
    letterSpacing: "0.01em"
  caption:
    fontFamily: "Hanken Grotesk, Helvetica Neue, sans-serif"
    fontSize: "11.5px"
    fontWeight: 500
rounded:
  menu-item: "9px"
  row: "11px"
  app-tile: "14px"
  card: "16px"
  show-tile: "18px"
  bar: "22px"
  profile: "26px"
  full: "999px"
spacing:
  hairline: "2px"
  xs: "6px"
  sm: "8px"
  md: "10px"
  lg: "12px"
  banner-gap: "12px"
  tile-gap: "16px"
  safe-bottom: "27px"
  safe-x: "56px"
  overlay-x: "64px"
  panel-top: "80px"
components:
  control-bar:
    textColor: "{colors.ink-body}"
    rounded: "{rounded.bar}"
    height: "44px"
    padding: "0 5px"
  control-bar-icon:
    textColor: "{colors.ink-body}"
    rounded: "{rounded.full}"
    height: "34px"
    width: "34px"
  control-bar-icon-focused:
    textColor: "{colors.ink}"
  control-bar-label:
    textColor: "{colors.ink}"
    typography: "{typography.label-sm}"
  show-tile:
    textColor: "{colors.ink}"
    typography: "{typography.title}"
    rounded: "{rounded.show-tile}"
    padding: "12px 14px"
    width: "212px"
    height: "116px"
  favourite-tile:
    rounded: "{rounded.app-tile}"
    width: "112px"
    height: "63px"
  row-heading:
    textColor: "{colors.ink-heading}"
    typography: "{typography.row-heading}"
  panel:
    textColor: "{colors.ink}"
    rounded: "{rounded.bar}"
    padding: "12px 8px 8px"
  panel-row:
    textColor: "{colors.ink-body}"
    typography: "{typography.label}"
    rounded: "{rounded.row}"
    height: "30px"
    padding: "0 10px"
  panel-row-focused:
    backgroundColor: "{colors.glass-lit}"
    textColor: "{colors.ink}"
  input-card:
    backgroundColor: "{colors.glass-well}"
    textColor: "{colors.ink}"
    rounded: "{rounded.card}"
    padding: "12px"
    width: "100px"
    height: "136px"
  settings-tile:
    backgroundColor: "{colors.glass-well}"
    textColor: "{colors.ink}"
    rounded: "{rounded.app-tile}"
    height: "64px"
    padding: "0 10px"
  chip:
    textColor: "{colors.ink-heading}"
    rounded: "{rounded.full}"
    padding: "3px 8px"
  pill-action:
    textColor: "{colors.ink-body}"
    rounded: "{rounded.full}"
    height: "34px"
  remove-menu:
    rounded: "{rounded.card}"
    padding: "6px"
    width: "148px"
    height: "72px"
  remove-menu-item:
    textColor: "{colors.ink-body}"
    typography: "{typography.label-sm}"
    rounded: "{rounded.menu-item}"
    height: "28px"
    padding: "0 12px"
  remove-menu-item-destructive-focused:
    backgroundColor: "{colors.glass-lit}"
    textColor: "{colors.remove-blush}"
  all-apps-tile:
    rounded: "{rounded.app-tile}"
    width: "152px"
    height: "86px"
  profile-card:
    textColor: "{colors.ink}"
    rounded: "{rounded.profile}"
    width: "132px"
    height: "150px"
  toast:
    backgroundColor: "{colors.toast-surface}"
    textColor: "{colors.ink}"
    typography: "{typography.label-sm}"
    rounded: "{rounded.full}"
    padding: "9px 16px"
---

# Design System: TV-OS

## Overview

**Creative North Star: "Night Glass"**

The launcher is a dark room with a few slabs of clear, rounded glass standing in it. Behind the glass is the household's own artwork: the key art of whatever is focused fills the right of the screen and fades into near-black behind the title, and its colours light the room. Every interactive surface is a glass slab drawn by a shader that follows real optics: flat in the middle, a circular bezel at the rim that pulls light inward, red bending a little more than blue so thin colour fringes appear at the edges, and a Fresnel rim that reflects more at grazing angles, lit from the top left. Focus is physical: the focused slab becomes a thicker piece of glass, bending harder and casting a longer, softer shadow, with one sheen sweeping across it.

The world is sparse by conviction. A clock, an icon-only control bar, one hero title, two rows. No feeds, no promotions, no decoration that is not glass or artwork. Type is a single family (Hanken Grotesk) in sentence case throughout, large and tight for titles, quiet and translucent-white for metadata. Colour is never chosen by hand: glows, tints and the backdrop are derived from the artwork on screen, so the palette of the room changes with what you point at.

The material is built for a Mali-450 on OpenGL ES 2.0 with fp16 fragment precision. That constraint is part of the system, not a footnote: the backdrop is rendered once into a texture, each slab is its own small quad, glass costs three texture reads with no loops, and the GPU stops when nothing moves. A visual idea that needs live blur, per-frame backdrop rendering or loops in a fragment shader is outside this world.

**Key Characteristics:**
- Clear refracting glass (circular bezel, dispersion, Fresnel, top-left light) as the only surface material; frosted glass for overlays.
- Near-black room lit only by colour derived from the focused artwork.
- Hanken Grotesk only, sentence case, tight negative tracking on large sizes.
- Focus as thickness: scale 1.07, stronger bend, longer softer shadow, one sheen sweep.
- One time-based motion clock; frame-rate independent; GPU idles at rest; reduced motion snaps.
- GLES2 budget: static backdrop texture, per-shape quads, three texture reads, no loops, no caustics.

## Colors

A near-black room, white ink at graded opacities, and artwork-derived light; the only fixed hues are a live-signal green and a soft destructive blush.

### Primary
- **Artwork Glow** (derived, no fixed value): three tones sampled from the focused artwork at 32x18: a vibrant tone (the 40 most saturated, reasonably bright pixels, boosted to 0.95), a top tone (0.5) and a bottom tone (0.42). They light the backdrop as soft blobs at the upper right, top centre and right edge, tint the light lines, and crossfade over 480ms when focus moves. Favourite apps take their glow from their own banner ("brand glow"); shows take it from key art, and key art wins when both exist.

### Secondary
- **Live Green** (live-green): the one fixed signal colour. A 7dp dot with an 8dp glow marks a connected input or network; a live input card gets a 35% green inner ring and an 18dp green halo, and its icon well tints green at 18%.

### Tertiary
- **Remove Blush** (remove-blush): text colour of the focused "Remove" item in the long-press menu. Destructive intent is signalled by tint, never by a red fill.

### Neutral
- **Night Floor** (night-floor): the backdrop's base before any glow; the room is this dark wherever artwork and glow do not reach. A vignette and a top-left darkening (60% while the hero is up) keep the title area black.
- **Overlay Scrim** (overlay-scrim): the dense dark tint under full-screen frosted overlays (All apps).
- **Toast Surface** (toast-surface): transient confirmation pills.
- **Ink** (ink): titles, focused items, progress fills, signal bars.
- **Ink Heading** (ink-heading): row headings, chip text.
- **Ink Body** (ink-body): resting control-bar icons, panel rows, menu items, hero metadata line (0.8).
- **Ink Meta** (ink-meta): provider names and secondary lines on tiles, clock date (0.62), hero source line (0.72).
- **Ink Quiet** (ink-quiet): tertiary panel text, picker subtitle, hints (0.5).
- **Glass Lit** (glass-lit): top stop of the focused-row gradient (to 0.09-0.10 at the bottom) on panel rows and menu items, always paired with a 1dp white inner top highlight.
- **Glass Well** (glass-well): resting fill of cards and tiles inside a frosted panel, with a 1dp inner top highlight at 0.14-0.16.
- **Track** (track): unfilled progress bars and empty signal arcs.
- **Rim Reflection** (rim-reflection): the cool tint the Fresnel rim mixes toward; the "room" the glass reflects.

### Named Rules
**The Artwork Owns Colour Rule.** Glow colours are sampled from the artwork on screen, never hand-picked. If there is no artwork, fall back to the neutral system tones (a desaturated blue-grey), not to an invented accent.

**The White Ink Rule.** Text is white at a graded opacity (1.0, 0.86, 0.78, 0.66, 0.55). Hierarchy comes from opacity and weight, not from new hues.

## Typography

**Display Font:** Hanken Grotesk (with Helvetica Neue, sans-serif)
**Body Font:** Hanken Grotesk
**Label/Mono Font:** Hanken Grotesk with tabular figures for clocks

**Character:** One grotesque family carries everything. Large sizes are bold and tightly tracked so titles read as solid shapes from the couch; small sizes sit at weight 500-600 in translucent white.

### Hierarchy
- **Display** (300, 112px, 0.9): screensaver clock only, light weight, tabular figures; date beneath at 500, 18px, ink-body.
- **Headline** (700, 50px, 1.0, -0.035em): the hero title of the focused item; carries a soft 30px dark text-shadow over key art.
- **Headline Small** (700, 40px, -0.03em): "Who's watching?" picker title.
- **Title Large** (700, 28px, -0.025em): full-screen overlay titles (All apps).
- **Clock** (600, 26px, -0.02em): home clock, top left, with the date at 500, 13px beside it on the baseline.
- **Title** (700, 17px, 1.1, -0.015em): show title on a Continue watching tile. The Wi-Fi network name uses the same voice at 19px.
- **Panel Title** (700, 16px, -0.01em): panel headings.
- **Row Heading** (600, 15px, -0.01em): "Continue watching", "Favourites".
- **Body** (500, 14px): the hero source line (provider · season) and the hero metadata line.
- **Label** (600, 13px): panel rows and pill actions. Label Small (600, 12.5px, +0.01em): control-bar label slot, menu items, toasts, card names (at 700).
- **Caption** (500, 11.5px): provider names, panel subtitles, statuses. This is the smallest canonical size.

### Named Rules
**The Sentence Case Rule.** Every string is sentence case, including labels, headings and buttons. No small all-caps tracked labels; the user rejected them along with the earlier serif.

**The One Family Rule.** Hanken Grotesk only. Weight and tracking make hierarchy; never add a second family.

## Layout

The layout space is 960x540dp (1920x1080 output at 320dpi). Composition is fixed, not responsive; the TV has one screen.

- **Safe area:** 56dp left and right on home; 27dp minimum below the last row; full-screen overlays use 64dp.
- **Home stack:** clock at top-left (56, 30); control bar at top-right (right 56, top 24, 44dp tall); hero block at (56, 100), 520dp wide; "Continue watching" heading at y 254 with tiles at y 286; "Favourites" heading at y 418 with tiles at y 450. Each heading sits 10dp or more above its row.
- **Rows:** Continue watching tiles 212x116 on a 228dp stride (16dp gap); Favourites tiles 112x63 (16:9) on a 124dp stride (12dp gap). Removing a tile reflows the row by sliding the remaining slabs to their new stride positions.
- **Hero:** source line, then the title 10dp below, then the metadata line 12dp below (with an optional 120x3 progress track), then the hint 16dp below. Key art occupies the right side of the backdrop and fades out across the left 10-62% and below 42-80% of the height.
- **Panels:** anchored right at 56dp, top at 80dp; they stop above the content rows and never cover the bottom row. Tiles a panel overlaps hide their text; the hero fades out while a bar panel is open.
- **All apps:** full screen, 5 columns of 152x86 banners on a 172x106 stride starting at (64, 112).
- **Focus memory:** each row remembers its last focused item; an unvisited row starts at its first item.

## Elevation & Depth

Depth is optical, not decorative. Every slab is glass over a lit backdrop, separated from it by a shader shadow and by the light it bends. There are no CSS box-shadow elevations for glass surfaces; shadows are drawn per shape as a separate quad that falls to exactly zero inside its bounds.

### Shadow Vocabulary
- **Slab shadow at rest** (shader: offset y 7dp, reach 34dp, peak alpha 0.41, quadratic falloff from a box at 96% x 90% of the slab): every glass tile and panel.
- **Slab shadow focused** (shader: offset y 18dp, reach 58dp, peak alpha 0.62): the focused slab; interpolates continuously with focus amount.
- **Floating bar** (no shadow): the control bar floats flush; it casts nothing.
- **Banner tile** (`0 0 0 1px rgba(255,255,255,.14), inset 0 1px 1px rgba(255,255,255,.4), 0 6px 16px rgba(0,0,0,.35)`): All apps banners only; focused `0 0 0 2px rgba(255,255,255,.9), 0 14px 30px rgba(0,0,0,.5)`.

### Glass Material
- **Clear glass:** bezel width 14dp (22dp focused, capped at 85% of the shorter half-size); inward bend 26dp (44dp focused) along the circular profile m = 1 - sqrt(1 - t^2); dispersion 0.10 (0.14 focused) with red bending more than blue; backdrop seen through glass is saturated 1.45x and brightened 1.12x; Fresnel F = 0.03 + 0.97·m^2.5 mixes toward rim reflection; light from the top left (-0.55, -0.85); bright 1.6dp top rim (0.5, 0.8 focused), half-strength side rim, bottom rim darkened 35%; a 14dp soft inner glow; a top-to-bottom face lift of 0.035 (0.07 focused); one diagonal sheen sweep over 650ms on focus.
- **Frosted glass:** six soft taps around the bent point, then a cool dark tint. Frost radius sets the variant: control bar 12 (translucent, stays glassy), remove menu 13 (frosted over the host tile's own pre-blurred poster), panels 24 (dense: mostly tint, 97% mix). The lens in the control bar is clear glass with frost 6.
- **Image under glass:** posters sit under the glass and bend with it; their lower half darkens to 16% for text, with the bezel exempt so fringes show on every edge. Favourite banners sit inset at 80% under the glass so only their plain margin reaches the rim.

### Named Rules
**The Zero Edge Rule.** A shadow fades to exactly zero before its quad ends. No shadow ever terminates on a visible edge.

**The Thicker Glass Rule.** Focus is expressed as thicker glass (scale 1.07, wider bezel, stronger bend, more dispersion, longer softer shadow), never as an outline or colour fill on glass slabs.

**The Static Room Rule.** The backdrop is rendered once into a 960x540 texture and re-rendered only while its colours or hero amount change. Glass reads that texture; it never triggers a redraw of it.

## Shapes

Rounded rectangles throughout, with radius growing with the object: menu items 9dp, panel rows 11dp, app tiles and settings tiles 14dp, cards and the remove menu 16dp, show tiles 18dp, the control bar and panels 22dp, profile cards 26dp. Pills (chips, pill actions, toasts, the lens) are fully round; the lens radius is half its height. The shader clamps every glass radius to half the slab height, so a shape can become a capsule but never exceed one. Icons are 17dp line icons at stroke 1.7, round caps, no fills. Avatars are circles of white-gradient glass with a 1dp inner highlight.

## Components

### Control Bar
Icons only, in one translucent frosted pill (44dp tall, 34dp icon cells, 2dp gaps, a 2dp × 14dp rounded divider before the profile avatar, shorter than the icons with 9dp space each side). Order: Jio Set-top Box, Inputs, Wi-Fi, Settings, Screensaver, All apps, Profile. Resting icons are ink-body; the focused icon turns ink.
- **Lens:** a clear glass **circle** (diameter = icon cell − 6dp) centred on the focused icon, with a clear ring of the pill's glass around it. It glides over 460ms with a back-out overshoot, stretches up to 16dp horizontally with its speed and settles back to a circle (40ms time constant); fades in and out over a 70ms time constant.
- **Label slot:** one slot at the pill's left edge opens once when focus enters the bar (max 104dp, 450ms), then only its text crossfades (140ms out, 3dp drop). It never resizes per item.

### Continue Watching Tile
Poster under clear glass, 212x116, radius 18. Text bottom-left at 12x14 padding: provider (caption, ink-meta), show title (title), optional 3dp progress track (track / ink), then a status line (caption, ink-meta; the build draws it at 11px, below the floor). The lower half of the poster darkens for legibility; the rim keeps its light. The placeholder tile carries real app icons on a faint blue-tinted face and cannot be removed.

### Favourite Tile
The app's own 16:9 TV banner inset under glass, 112x63, radius 14. The name stays in the DOM for screen readers but is not drawn. Focusing it lights the room with the banner's own colour.

### Remove Menu
Long-press OK (500ms) on a removable tile: a 148x72 frosted panel centred on the tile itself, never spilling onto the next row. Two items, Remove and Cancel, 28dp tall; the selected item gets the glass-lit gradient, and Remove tints to remove blush. The tile's own text hides underneath.

### Panels (Control Center style)
Dense frosted glass, radius 22, anchored top-right under the bar.
- **Inputs:** the TV's back panel (a 440×178dp sheet) as a recessed glass plate (radius 18, inset shadow) holding real connector drawings: HDMI trapezoid sockets, yellow/white/red RCA jacks for AV, a hex coax socket with a gold pin for Antenna. The live port shows a plugged-in cable with a green signal LED and its device name in green ("Jio Set-top Box"). Empty ports read "No signal" (never a guessed state). Under each socket: port name (12.5/700) and status. Focus is a glass chip that lifts 3dp; a detail line under the plate explains the focused port and what OK does.
- **Wi-Fi:** one compact row (500×112dp). On the left, a 30dp signal glyph, a small "Wi-Fi" eyebrow (11.5/600), the network name (19/700) and one meta line ("Connected · 5 GHz · 292 Mbps · Good signal"). On the right, two round glass buttons (Networks, Settings). No title, divider or detail line: the labels say enough.
- **Settings:** one row of six round glass buttons (Picture, Sound, Display, Apps, Network, All) with one-word labels and no sub-text. The focused button becomes a solid "pearl" (white radial gradient, dark icon, scale 1.12), and a single detail line below explains it.
- **Round glass button** (shared): a 48dp orb of radial white glass (top highlight, bottom inner shadow, soft drop shadow), a 20dp icon and a 12/600 label. Used where a panel offers a few actions; never boxed in cards.
- **Focused row:** glass-lit gradient, inner top highlight 0.5, inner bottom shade, 2dp/10dp soft drop.

### All Apps
Full screen over the overlay scrim, 5 columns of real app banners (152x86, radius 14) with a top sheen fading out by 40%. Focus scales 1.10 with a 2dp white ring and a deeper drop shadow; the transform uses an overshooting ease over 160ms.

### Who's Watching
Five profile cards (132x150, radius 26) of glass, a 60dp glass avatar with the initial, the name at 600/14. Headline-small title centred at y 128 with a caption-sized subtitle.

### Screensaver
Static generated wallpapers (dunes at dusk, moon over water, mountains at blue hour, gold contours, a soft mesh of light) with film grain so gradients never band, under a 20-degree dark gradient from the bottom-left. Display clock bottom-left at (64, bottom 58) with the date beneath. Wallpapers crossfade slowly (every 3 minutes on the TV); a black dimmer reaches 45% over 3s after 1 minute. Any button returns home. It never sleeps.

### Motion
One time-based clock drives glass and text, frame-rate independent (dt capped at 50ms). Focus thickness eases with a 60ms time constant; the hero backdrop with 110ms; panel visibility 70ms; slab reflow 90ms; artwork palettes crossfade linearly over 480ms with an ease-in-out in the shader. The hero text swaps by fading out, changing at 130ms, and rising 6dp back in. Rendering continues 700ms after the last input, then the GPU idles. With reduced motion, every value snaps to its target.

## Do's and Don'ts

### Do:
- **Do** draw every interactive surface as a glass slab from the shared shader: one quad per shape, three texture reads for dispersion, no loops, fp16-safe local coordinates.
- **Do** take glow colours from the artwork on screen (vibrant, top and bottom tones); favourite apps use their own banner's glow.
- **Do** express focus as thicker glass: scale 1.07, bezel 14 to 22dp, bend 26 to 44dp, dispersion 0.10 to 0.14, a longer softer shadow, one sheen sweep.
- **Do** use frosted glass for anything that overlays content: the control bar at frost 12 (translucent), panels at 24 (dense), the remove menu at 13 over the host tile's pre-blurred poster.
- **Do** keep text on poster tiles over the darkened lower half, with the bezel exempt from darkening so fringes show on every edge.
- **Do** keep 56dp side margins, 27dp below the last row, and 10dp or more between a row heading and its tiles.
- **Do** stop the GPU when nothing moves, and re-render the backdrop texture only when its colours change.
- **Do** drive all motion from one time-based clock and snap everything under reduced motion.

### Don't:
- **Don't** use small all-caps tracked labels or a serif; the user rejected both.
- **Don't** add caustics to the glass; the user removed them.
- **Don't** hand-pick glow or accent colours for content; the only fixed hues are live green and remove blush.
- **Don't** let a shadow end on a hard edge, and don't put a shadow under the control bar.
- **Don't** use live blur (RenderEffect needs API 31; the TV runs API 28) or re-render the backdrop per frame; frost comes from the shader's taps or a pre-blurred copy.
- **Don't** put a CSS or View transition on a property the frame clock animates.
- **Don't** resize the control-bar label slot per item; open it once and crossfade the text.
- **Don't** let a panel cover the content rows, or leave tile text visible under a panel.
- **Don't** set text below 11.5dp; it has to be read from 2-3 m away.

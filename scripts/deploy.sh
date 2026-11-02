#!/usr/bin/env bash
# Build + install + launch. Usage: scripts/deploy.sh [debug|release]
set -euo pipefail
cd "$(dirname "$0")/.."
DEVICE="${TV_DEVICE:-192.168.29.88:5555}"
VARIANT="${1:-debug}"
PKG=dev.tvos.launcher
CAP="$(tr '[:lower:]' '[:upper:]' <<<"${VARIANT:0:1}")${VARIANT:1}"

adb connect "$DEVICE" >/dev/null
./gradlew ":app:assemble$CAP"
APK="app/build/outputs/apk/$VARIANT/app-$VARIANT.apk"
ls -lh "$APK"
adb -s "$DEVICE" install -r -d "$APK"
adb -s "$DEVICE" shell am start -n "$PKG/.MainActivity"

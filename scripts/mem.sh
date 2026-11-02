#!/usr/bin/env bash
# Snapshot launcher + system memory to mem-logs/<timestamp>-<label>.txt
# Usage: scripts/mem.sh <label> [package ...]
set -euo pipefail
cd "$(dirname "$0")/.."
DEVICE="${TV_DEVICE:-192.168.29.88:5555}"
LABEL="${1:-snapshot}"; shift || true
PKGS=("${@:-dev.tvos.launcher com.mitv.tvhome.atv com.google.android.tvlauncher com.google.android.katniss}")
read -ra PKGS <<<"${PKGS[*]}"
mkdir -p mem-logs
OUT="mem-logs/$(date +%Y%m%d-%H%M%S)-$LABEL.txt"
A="adb -s $DEVICE shell"
{
  echo "# $LABEL  $(date)"
  $A dumpsys meminfo | grep -E "Total RAM|Free RAM|Used RAM|Lost RAM"
  echo
  printf "%-40s %10s\n" PACKAGE "PSS(KB)"
  for p in "${PKGS[@]}"; do
    pss=$($A dumpsys meminfo "$p" 2>/dev/null | awk '/TOTAL:/{print $2; exit} /^ *TOTAL /{print $2; exit}')
    printf "%-40s %10s\n" "$p" "${pss:-not running}"
  done
  echo; echo "## Top 15 processes by PSS"
  $A dumpsys meminfo | sed -n '/Total PSS by process/,/^$/p' | head -16
} | tee "$OUT"
echo "-> $OUT"

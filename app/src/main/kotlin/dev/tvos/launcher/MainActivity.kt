package dev.tvos.launcher

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import java.io.File

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TextView(this).apply {
            text = "TV-OS build pipeline OK"
            textSize = 32f
            gravity = Gravity.CENTER
        })
        if (intent.getBooleanExtra("dumpIcons", false)) Thread { dumpIcons() }.start()
    }

    /** Debug: write each app's TV banner and icon to files/icons so design mocks use the real artwork. */
    private fun dumpIcons() {
        val out = File(getExternalFilesDir(null), "icons").apply { mkdirs() }
        val pm = packageManager
        val all = pm.queryIntentActivities(android.content.Intent(android.content.Intent.ACTION_MAIN).addCategory(android.content.Intent.CATEGORY_LEANBACK_LAUNCHER), 0)
            .map { it.activityInfo.packageName }.distinct()
        for (p in all) try {
            val ai = pm.getApplicationInfo(p, 0)
            val banner = pm.getLeanbackLaunchIntentForPackage(p)?.let { pm.getActivityBanner(it) } ?: pm.getApplicationBanner(ai)
            banner?.let { save(it, File(out, "$p.banner.png")) }
            save(pm.getApplicationIcon(ai), File(out, "$p.icon.png"))
        } catch (e: Exception) { Log.w("IconDump", "$p: $e") }
        File(out, "labels.txt").writeText(all.joinToString("\n") { p -> p + "\t" + runCatching { pm.getApplicationLabel(pm.getApplicationInfo(p, 0)) }.getOrDefault(p) })
        Log.i("IconDump", "done -> ${out.path}")
    }

    private fun save(d: Drawable, f: File) {
        val w = d.intrinsicWidth.takeIf { it > 0 } ?: 320
        val h = d.intrinsicHeight.takeIf { it > 0 } ?: 180
        val b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        d.setBounds(0, 0, w, h); d.draw(Canvas(b))
        f.outputStream().use { b.compress(Bitmap.CompressFormat.PNG, 100, it) }
    }

    companion object {
        val PKGS = listOf(
            "com.netflix.ninja", "com.amazon.amazonvideo.livingroom", "com.google.android.youtube.tv",
            "in.startv.hotstar", "com.sonyliv", "com.graymatrix.did",
        )
    }
}

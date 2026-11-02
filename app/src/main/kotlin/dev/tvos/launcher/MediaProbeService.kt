package dev.tvos.launcher

import android.content.ComponentName
import android.media.MediaMetadata
import android.media.session.MediaController
import android.media.session.MediaSessionManager
import android.service.notification.NotificationListenerService
import android.graphics.Bitmap
import android.app.Notification
import android.service.notification.StatusBarNotification
import android.util.Log
import java.io.File

/** Debug probe: logs every metadata key published by active media sessions. */
class MediaProbeService : NotificationListenerService() {
    override fun onListenerConnected() {
        val msm = getSystemService(MediaSessionManager::class.java)
        val me = ComponentName(this, MediaProbeService::class.java)
        msm.getActiveSessions(me).forEach(::dump)
        activeNotifications?.forEach(::savePic)
        msm.addOnActiveSessionsChangedListener({ it?.forEach(::dump) }, me)
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) = savePic(sbn)

    private fun savePic(sbn: StatusBarNotification) {
        val ex = sbn.notification.extras
        val bmp = ex.getParcelable<Bitmap>(Notification.EXTRA_PICTURE) ?: return
        val f = File(getExternalFilesDir(null), "np-${sbn.packageName}.png")
        f.outputStream().use { bmp.compress(Bitmap.CompressFormat.PNG, 100, it) }
        Log.i("MediaProbe", "saved ${f.path} title=${ex.getCharSequence(Notification.EXTRA_TITLE)}")
    }

    private fun dump(c: MediaController) {
        c.registerCallback(object : MediaController.Callback() {
            override fun onMetadataChanged(m: MediaMetadata?) = log(c, m)
        })
        log(c, c.metadata)
    }

    private fun log(c: MediaController, m: MediaMetadata?) {
        val keys = m?.keySet()?.joinToString { k ->
            val v = m.getString(k) ?: m.getLong(k).toString().takeIf { it != "0" } ?: (if (m.getBitmap(k) != null) "<bitmap>" else "?")
            "$k=$v"
        }
        m?.getBitmap(MediaMetadata.METADATA_KEY_ART)?.let { b ->
            File(getExternalFilesDir(null), "art-${c.packageName}.png").outputStream().use { b.compress(Bitmap.CompressFormat.PNG, 100, it) }
        }
        Log.i("MediaProbe", "${c.packageName} state=${c.playbackState?.state} pos=${c.playbackState?.position} :: $keys")
    }
}

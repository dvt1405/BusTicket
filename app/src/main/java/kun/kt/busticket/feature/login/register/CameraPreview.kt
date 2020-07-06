package kun.kt.busticket.feature.login.register

import android.content.Context
import android.hardware.Camera
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.lang.Exception

class CameraPreview(context: Context, private val camera: Camera) : SurfaceView(context),
    SurfaceHolder.Callback {
    var surfaceHolder = this.holder.apply {
        addCallback(this@CameraPreview)
        setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        if (surfaceHolder.surface == null) {
            return
        }
        try {
            camera.stopPreview()
        } catch (e: Exception) {
            throw e
        }
        camera.apply {
            try {
                setPreviewDisplay(holder)
                startPreview()
            } catch (e: Exception) {
                throw e
            }
        }
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        camera.stopPreview()
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        camera.apply {
            try {
                setPreviewDisplay(holder)
                startPreview()
            } catch (e: Exception) {
                throw e
            }
        }
    }
}
package kun.kt.busticket.feature.login

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kun.kt.busticket.BusTicketApplication
import kun.kt.busticket.R
import kun.kt.busticket.basecomponent.BaseTicketActivity
import kun.kt.busticket.feature.login.register.FragmentRegister
import kun.kt.busticket.feature.login.startfragment.StartFragment
import javax.inject.Inject

class LoginActivity() : BaseTicketActivity() {
    override val fragmentContainer: Int = R.id.fragment_container
    override val backStack: String = this::class.java.name

    @Inject
    lateinit var viewModelFactory: LoginViewModelFactory
    val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as BusTicketApplication).loginComponent.inject(this)
        ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
        setContentView(R.layout.activity_login)
        replaceFragment(StartFragment(), StartFragment::class.java.name)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (i in permissions.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    val fragment =
                        supportFragmentManager.findFragmentByTag(FragmentRegister::class.java.name)
                    if (fragment != null) {
                        (fragment as FragmentRegister).startTakePicture()
                    }
                } else {
                    Toast.makeText(this, "Provide permission to continue", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            val fragment =
                supportFragmentManager.findFragmentByTag(FragmentRegister::class.java.name)
            if (fragment != null) {
                (fragment as FragmentRegister).setImageAfterCapture(imageBitmap)
            }
        } else {
            Toast.makeText(this, "Take picture fail!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        const val REQUEST_CAPTURE_IMAGE_CODE = 1
        const val REQUEST_PERMISSION_CODE = 100
    }
}

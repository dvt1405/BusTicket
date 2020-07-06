package kun.kt.busticket.feature.login.register

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.hardware.Camera
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_sign_up.view.*
import kun.kt.busticket.R
import kun.kt.busticket.basecomponent.BaseFragment
import kun.kt.busticket.basedata.DataState
import kun.kt.busticket.feature.buyticket.BuyTicketActivity
import kun.kt.busticket.feature.login.LoginActivity
import kun.kt.busticket.feature.login.LoginViewModel
import kun.kt.busticket.model.Customer
import kun.kt.busticket.util.checkCameraHardware
import kun.kt.busticket.util.hasPermissions
import roxwin.tun.baseui.dialog.ProgressDialog
import java.io.ByteArrayOutputStream

class FragmentRegister : BaseFragment(R.layout.fragment_sign_up) {
    private var camera: Camera? = null
    private var imgSignUp: String? = null
    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)
    }
    private val progressDialog by lazy {
        ProgressDialog(requireContext(), false)
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {

    }

    override fun initAction(view: View, savedInstanceState: Bundle?) {
        view.btn_sign_up_take_picture.setOnClickListener {
            checkTakePicturePermissions()
        }
        view.btn_sign_up.setOnClickListener {
            signUp()
        }
        viewModel.registerState.observe(viewLifecycleOwner, Observer {
            handleRegisterState(it)
        })
    }

    private fun signUp() {
        val userName = view?.sign_up_name?.text?.toString()
        val phone = view?.sign_up_phone?.text?.toString()
        viewModel.register(Customer(imgSignUp ?: "", userName ?: "", phone ?: ""))
        viewModel.registerState.postValue(DataState.Loading())
    }

    private fun handleRegisterState(data: DataState<Boolean>) {
        when (data) {
            is DataState.Success -> {
                // go to Login
                viewModel.registerState.postValue(DataState.Succeeded())
                startActivity(Intent(requireContext(), BuyTicketActivity::class.java))
            }
            is DataState.Error -> {

            }
        }
        if (data is DataState.Loading) {
            progressDialog.show()
        } else {
            progressDialog.dismiss()
        }
    }

    private fun checkTakePicturePermissions() {
        if (!requireActivity().hasPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(Manifest.permission.CAMERA),
                LoginActivity.REQUEST_PERMISSION_CODE
            )
        } else {
            startTakePicture()
        }

    }

    fun startTakePicture() {
        if (requireContext().checkCameraHardware()) {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity((requireActivity().packageManager))?.also {
                    startActivityForResult(
                        takePictureIntent,
                        LoginActivity.REQUEST_CAPTURE_IMAGE_CODE
                    )
                }
            }
        } else {
            Toast.makeText(context, "No camera found", Toast.LENGTH_SHORT).show()
        }
    }

    fun setImageAfterCapture(imgBitmap: Bitmap) {
        view?.sign_up_avatar?.setImageBitmap(imgBitmap)
        try {
            val bytes = ByteArrayOutputStream()
            imgBitmap.compress(Bitmap.CompressFormat.PNG, 100, bytes)
            val byteArray = bytes.toByteArray()
            imgSignUp = Base64.encodeToString(byteArray, Base64.DEFAULT)
        } catch (e: Throwable) {
            throw e
        }
    }
}
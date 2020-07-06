package kun.kt.busticket.feature.login.startfragment

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import androidx.transition.Fade
import kotlinx.android.synthetic.main.fragment_start_sign_up.view.*
import kun.kt.busticket.R
import kun.kt.busticket.basecomponent.BaseFragment
import kun.kt.busticket.feature.login.LoginActivity
import kun.kt.busticket.feature.login.register.FragmentRegister


class StartFragment : BaseFragment(R.layout.fragment_start_sign_up) {
    override fun initView(view: View, savedInstanceState: Bundle?) {

    }

    override fun initAction(view: View, savedInstanceState: Bundle?) {
        view.btn_sign_up.setOnClickListener {
            val changeTransform = TransitionInflater.from(requireContext())
                .inflateTransition(R.transition.shared_image)
            val fragment = FragmentRegister()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                fragment.sharedElementEnterTransition = changeTransform
                fragment.enterTransition = changeTransform
                fragment.exitTransition = changeTransform
                fragment.sharedElementReturnTransition = changeTransform
            }

            requireActivity().supportFragmentManager.beginTransaction()
                .addSharedElement(view.btn_sign_up, getString(R.string.transition_name))
                .replace(R.id.fragment_container, fragment, FragmentRegister::class.java.name)
                .addToBackStack(LoginActivity::class.java.name)
                .commit()
        }
    }
}
package kun.kt.busticket.basecomponent

import android.util.Log
import androidx.fragment.app.Fragment
import tun.kt.apilib.apihistory.BaseActivity

abstract class BaseTicketActivity : BaseActivity() {
    abstract val fragmentContainer: Int
    abstract val backStack: String
    fun addFragment(fragment: Fragment, tag: String) {
        Log.e("Fragment", fragment.javaClass.name)
        supportFragmentManager.beginTransaction()
            .add(fragmentContainer, fragment, tag)
            .commit()
    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainer, fragment, tag)
            .addToBackStack(backStack)
            .commit()
    }
}
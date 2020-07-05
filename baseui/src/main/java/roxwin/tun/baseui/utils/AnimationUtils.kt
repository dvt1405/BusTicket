package roxwin.tun.baseui.utils

import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.default_tooltip.view.*
import roxwin.tun.baseui.R

object AnimationUtils {
    @JvmStatic
    fun getRotateAnimation(isArrowDown: Boolean, width: Int, height: Int): RotateAnimation =
        if (isArrowDown) {
            RotateAnimation(
                0f,
                180f,
                width / 2.toFloat(),
                height / 2.toFloat()
            )
        } else {
            RotateAnimation(
                180f,
                360f,
                width / 2.toFloat(),
                height / 2.toFloat()
            )
        }

}

fun RecyclerView.runLayoutAnimation() {
    val layoutAnimation =
        AnimationUtils.loadLayoutAnimation(context, R.anim.recycler_view_layout_anim_fall_down)
    setLayoutAnimation(layoutAnimation)
    adapter?.notifyDataSetChanged()
    scheduleLayoutAnimation()
}
package roxwin.tun.baseui.bottomsheet

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.ArrayRes
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*
import roxwin.tun.baseui.R

class BottomSheetOptionsMenu : BottomSheetDialogFragment {
    @ArrayRes
    private var itemId: Int? = null
    private var onItemClickListener: OnItemClickListener? = null
    private var itemList: Array<CharSequence>? = null

    constructor() : super() {
    }

    constructor(
        @ArrayRes itemId: Int,
        onItemClickListener: OnItemClickListener
    ) : super() {
        this.itemId = itemId
        this.onItemClickListener = onItemClickListener
    }

    constructor(
        listItem: Array<String>,
        onItemClickListener: OnItemClickListener
    ) : super() {
        this.itemList = listItem.map { it }.toTypedArray()
        this.onItemClickListener = onItemClickListener
    }

    constructor(
        listItem: ArrayList<String>,
        onItemClickListener: OnItemClickListener
    ) : super() {
        this.itemList = listItem.map { it }.toTypedArray()
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheet)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_layout, container, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (itemList.isNullOrEmpty()) {
            if (itemId != null) {
                this.itemList = requireContext().resources.getTextArray(itemId!!)
            }
        }
        for (i in itemList!!.indices) {
            val textView = context?.let {
                val styleRes =
                    if (i == 0) R.style.BottomSheetItem_FirstItem else R.style.BottomSheetItem
                AppCompatTextView(
                    ContextThemeWrapper(
                        context,
                        styleRes
                    )
                )
            }
            textView?.id = i
            view.container.addView(textView)
            textView?.text = itemList!![i]
            if (i < itemList!!.size - 1) {
                val line = View(context)
                line.setBackgroundColor(R.color.colorGreyTransparent)
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    resources.displayMetrics.scaledDensity.toInt()
                )
                line.layoutParams = layoutParams
                view.container.addView(line)
            }
            textView?.setOnClickListener {
                onItemClickListener?.onClick(i, this)
                this.dismiss()
            }
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
    }

    override fun onStart() {
        super.onStart()
        val bottomSheetBehavior = BottomSheetBehavior.from(requireView().parent as View)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    interface OnItemClickListener {
        fun onClick(where: Int, bottomSheetInterface: BottomSheetOptionsMenu)
    }
}
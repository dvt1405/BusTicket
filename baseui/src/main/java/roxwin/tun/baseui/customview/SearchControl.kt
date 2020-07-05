package roxwin.tun.baseui.customview

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import roxwin.tun.baseui.R
import roxwin.tun.baseui.utils.KeyboardUtil
import roxwin.tun.baseui.utils.LogUtil
import java.lang.Exception

class SearchControl(private val view: View, private val activity: Activity) {

    private lateinit var editTextSearch: EditText
    private lateinit var btnCancel: View

    init {
        try {
            editTextSearch = view.findViewById(R.id.editTextSearch)
            btnCancel = view.findViewById(R.id.icon_cancel)
        } catch (e: Exception) {
            LogUtil.e(e)
        }
        onFocusChangeListener { view, hasFocus ->
            if (!editTextSearch.text.isNullOrEmpty()) {
                hideBtnCancelSearch(false)
            } else {
                hideBtnCancelSearch(true)
            }
        }

        onEditActionListener { view, actionId, event ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    KeyboardUtil.hideSoftKeyboard(activity)
                    editTextSearch.clearFocus()
                    return@onEditActionListener true
                }
            }
            return@onEditActionListener false
        }
        onCancelListener {
            editTextSearch.text.delete(
                0,
                if (editTextSearch.text.isNotEmpty()) editTextSearch.text.length else 0
            )
            btnCancel.visibility = View.GONE
            editTextSearch.clearFocus()
        }
    }

    fun setOnSearchListener(onSearch: (text: String) -> Unit) {
        editTextSearch.doOnTextChanged { text, start, count, after ->
            if (!editTextSearch.text.isNullOrEmpty()) {
                hideBtnCancelSearch(false)
            } else {
                hideBtnCancelSearch(true)
            }
            onSearch(text.toString())
        }
    }

    fun clear() {
        editTextSearch.text.clear()
    }

    private fun hideBtnCancelSearch(shouldHide: Boolean) {
        if (!shouldHide) {
            btnCancel.visibility = View.VISIBLE
        } else {
            btnCancel.visibility = View.GONE
        }
    }

    fun onCancelListener(listener: (view: View) -> Unit) {
        btnCancel.setOnClickListener {
            listener(it)
        }
    }

    fun onEditActionListener(listener: (view: View, actionId: Int, event: KeyEvent?) -> Boolean) {
        editTextSearch.setOnEditorActionListener { v, actionId, event ->
            listener(v, actionId, event)
        }
    }

    fun onFocusChangeListener(listener: (view: View, hasFocus: Boolean) -> Unit) {
        editTextSearch.setOnFocusChangeListener { v, hasFocus ->
            listener(v, hasFocus)
        }
    }
}
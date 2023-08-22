package com.demo.view

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.demo.R
import com.google.android.material.textfield.TextInputLayout

class CustomTextInputLayoutRegular @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : TextInputLayout(context, attrs) {

    init {
        defaultHintTextColor = ContextCompat.getColorStateList(context, R.color.txt_gray)
    }
}
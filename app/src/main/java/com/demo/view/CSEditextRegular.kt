package com.demo.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import com.demo.R
import com.google.android.material.textfield.TextInputEditText

class CSEditextRegular @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : TextInputEditText(context, attrs) {

    init {
        setTextColor(resources.getColor(R.color.txt_black))
        textSize = 13F
        val typeface = Typeface.createFromAsset(context.assets, "Poppins-Regular.ttf")
        setTypeface(typeface)
    }
}
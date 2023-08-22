package com.demo.utils

import android.content.Context
import android.view.View
import com.demo.R
import com.google.android.material.snackbar.Snackbar


object SnakebarUtility
{
    // SnackBar without Button
     fun showSnackBarWithoutAction(message: String, binding: View, context: Context) {
         val snackBar: Snackbar
         snackBar = Snackbar.make(binding, message, Snackbar.LENGTH_LONG)
         val snackBarView = snackBar.view
         snackBarView.setBackgroundColor(context.resources.getColor(R.color.blue))
         snackBar.show()
    }

    // SnackBar with action Button
    fun showSnackbarWithAction(actionMsg : String,message: String,binding: View, block: () -> Unit) {
        Snackbar.make(
            binding,
            message,
            Snackbar.LENGTH_LONG
        ).setAction(actionMsg) {
            block()
        }.show()
    }
}
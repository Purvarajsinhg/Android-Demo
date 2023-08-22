package com.demo.utils

import android.R
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

object AlertDialogutility
{
    private const val NO_INTERNET = "Please check your Internet connection !"
    private const val RETRY = "Retry"

    fun showInternetAlert(context: Context)
    {
        try {
            val dialogBuilder = AlertDialog.Builder(context)
            dialogBuilder.setMessage(RETRY)
                .setPositiveButton("", DialogInterface.OnClickListener { dialog, id ->
//                    recreate()
                })
            // create dialog box
            val alert = dialogBuilder.create()
            alert.setTitle(NO_INTERNET)
            alert.setIcon(R.drawable.ic_dialog_alert)
            // show alert dialog
            alert.show()
        } catch (e: Exception) {
                e.printStackTrace()
        }
    }
}
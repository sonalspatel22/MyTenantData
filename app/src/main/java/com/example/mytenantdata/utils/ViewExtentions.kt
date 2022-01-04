package com.example.mytenantdata.utils

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Uri.getPathString(context: Context): String {

    var path: String = ""
    context.contentResolver.query(this, arrayOf(MediaStore.Images.Media.DATA), null, null, null)?.apply {
        val columnIndex = getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        moveToFirst()
        path = getString(columnIndex)
        close()
    }

    return path
}


fun hideKeyboard(activity: Activity) {
    val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    //Find the currently focused view, so we can grab the correct window token from it.
    var view = activity.currentFocus
    //If no view currently has focus, create a new one, just so we can grab a window token from it
    if (view == null) {
        view = View(activity)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}
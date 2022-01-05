package com.example.mytenantdata.base

import android.app.Activity
import android.content.Context
import android.graphics.Color.red
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.mytenantdata.R
import com.example.mytenantdata.data.room.PropertyDatabase
import com.example.mytenantdata.utils.hideKeyboard
import com.google.android.material.snackbar.Snackbar


open class BaseFragment : Fragment() {
    lateinit var activity: Activity
    lateinit var database: PropertyDatabase


    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.let {
            activity = (context as Activity)
             database = PropertyDatabase.getInstance(activity)
        }
    }

    fun showToast(message: String) {
        view?.let {
            Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun errorMessage(message: String) {
        hideKeyboard(activity)
        view?.let {
            val snack = Snackbar.make(it, message, Snackbar.LENGTH_LONG)
            val textView = snack.view.findViewById(R.id.snackbar_text) as TextView
            textView.setTextColor(ContextCompat.getColor(activity, R.color.black))
            snack.show()
        }
    }

}
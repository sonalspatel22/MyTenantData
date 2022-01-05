package com.example.mytenantdata.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.mytenantdata.R
import com.example.mytenantdata.base.BaseFragment
import com.example.mytenantdata.data.room.PropertyDatabase
import com.example.mytenantdata.data.room.dao.repo.PropertyRepository
import com.example.mytenantdata.data.room.dao.repo.TenantRepository
import com.example.mytenantdata.ui.PropertyViewModelFactory
import com.example.mytenantdata.utils.getPathString
import com.example.mytenantdata.viewmodel.PropertyViewModel
import kotlinx.android.synthetic.main.fragment_add_property.*
import java.io.File
import java.io.IOException


class AddPropertyFragment : BaseFragment() {
    private val GALLERY = 1


    val propertyViewModel: PropertyViewModel by viewModels {
        PropertyViewModelFactory(
            PropertyRepository(propertyDao = database.getPropertyDao()),
            TenantRepository(database.getTenantDao())
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_property, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        propertyViewModel.propertyAdded.observe(viewLifecycleOwner, Observer {
            val navDirections =
                AddPropertyFragmentDirections.actionAddPropertyFragmentToPropertyListFragment(it)
            Navigation.findNavController(view).navigate(navDirections)
        })

        addPropertytextView.setOnClickListener {
            propertyViewModel.insertProperty(
                editTextTextPropertyName.text.trim().toString(),
                editTextTextPropertyAddress.text.trim().toString()
            )
        }
        openGalleryTextView.setOnClickListener {
            choosePhotoFromGallery()
        }

    }

    private fun choosePhotoFromGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GALLERY) {
            if (data != null) {
                try {
                    val contentURI: Uri = data.data as Uri
                    activity.let {
                        val path = it.let { it1 -> contentURI.getPathString(it1) }
                        val file = File(path)
                        propertyViewModel.addImageFile(file)
                    }
                    showToast(getString(R.string.image_fetch_from_gallery))
                } catch (e: IOException) {
                    e.printStackTrace()
                    showToast(getString(R.string.image_fetch_failed))
                }
            }
        }
    }
}
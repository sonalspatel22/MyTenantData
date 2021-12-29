package com.example.mytenantdata.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mytenantdata.R
import com.example.mytenantdata.data.room.PropertyDatabase
import com.example.mytenantdata.data.room.dao.repo.PropertyRepository
import com.example.mytenantdata.data.room.dao.repo.TenantRepository
import com.example.mytenantdata.ui.PropertyViewModelFactory
import com.example.mytenantdata.viewmodel.PropertyViewModel

class PropertyListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_property_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mydatabase: PropertyDatabase = PropertyDatabase.getInstance(requireContext())
        val propertyViewModel: PropertyViewModel by viewModels {
            PropertyViewModelFactory(
                PropertyRepository(propertyDao = mydatabase.getPropertyDao()),
                TenantRepository(mydatabase.getTenantDao())
            )
        }
        propertyViewModel.AllProperty.observe(this) {
            Log.e("properties", "" + it)
        }
        arguments?.let {
            val properti = PropertyListFragmentArgs.fromBundle(bundle = it).propertyModel
            Log.i("Property", "" + properti)
            Toast.makeText(activity, "" + properti, Toast.LENGTH_LONG)
        }
    }
}
package com.example.mytenantdata.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mytenantdata.R
import com.example.mytenantdata.data.room.PropertyDatabase
import com.example.mytenantdata.data.room.dao.repo.PropertyRepository
import com.example.mytenantdata.data.room.dao.repo.TenantRepository
import com.example.mytenantdata.model.Properti
import com.example.mytenantdata.ui.PropertyViewModelFactory
import com.example.mytenantdata.viewmodel.PropertyViewModel
import kotlinx.android.synthetic.main.fragment_add_property.*


class AddPropertyFragment : Fragment() {


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
        val mydatabase: PropertyDatabase = PropertyDatabase.getInstance(requireContext())
        val propertyViewModel: PropertyViewModel by viewModels {
            PropertyViewModelFactory(
                PropertyRepository(propertyDao = mydatabase.getPropertyDao()),
                TenantRepository(mydatabase.getTenantDao())
            )
        }
        addPropertytextView.setOnClickListener {
            val properti = Properti(
                0,
                editTextTextPropertyName.text.toString(),
                editTextTextPropertyAddress.text.toString()
            )
            propertyViewModel.insertProperty(properti)
            val navDirections =
                AddPropertyFragmentDirections.actionAddPropertyFragmentToPropertyListFragment(
                    properti
                )
            Navigation.findNavController(it).navigate(navDirections)
        }
    }

}
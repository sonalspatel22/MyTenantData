package com.example.mytenantdata.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mytenantdata.R
import com.example.mytenantdata.base.BaseFragment
import com.example.mytenantdata.model.Tenant
import kotlinx.android.synthetic.main.fragment_add_tenant.*


class AddTenantFragment : BaseFragment() {

//    lateinit var  propertyViewModel: PropertyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_tenant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        propertyViewModel = ViewModelProvider(requireActivity()).get(PropertyViewModel::class.java)
        addTenantTextView.setOnClickListener {
            val tenant = Tenant(0, editTextTextTenantName.text.toString(),editTextTextMobiletNumber.text.toString())
//            propertyViewModel.insertTenant(tenant)
            val navDirections = AddTenantFragmentDirections.actionAddTenantFragmentToTenantListFragment(tenant)
            Navigation.findNavController(it).navigate(navDirections)
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = AddTenantFragment()
    }
}
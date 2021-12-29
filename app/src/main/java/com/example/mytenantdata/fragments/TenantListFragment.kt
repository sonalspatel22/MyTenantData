package com.example.mytenantdata.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mytenantdata.fragments.TenantListFragmentArgs
import com.example.mytenantdata.R
import com.example.mytenantdata.model.Tenant


class TenantListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tenant_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val tenant = TenantListFragmentArgs.fromBundle(bundle = it).tenantModel as Tenant
            Log.i("Property", "" + tenant)
            Toast.makeText(activity,""+tenant,Toast.LENGTH_LONG)
        }
    }
}
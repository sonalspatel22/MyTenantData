package com.example.mytenantdata.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mytenantdata.data.room.dao.repo.PropertyRepository
import com.example.mytenantdata.data.room.dao.repo.TenantRepository
import com.example.mytenantdata.model.Properti
import com.example.mytenantdata.model.Tenant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PropertyViewModel(
    private val propertyRepository: PropertyRepository,
    private val tenantRepository: TenantRepository
) : ViewModel() {

    var AllProperty = propertyRepository.getAllProperty().asLiveData()

    fun getAllTenant(): Flow<List<Tenant>> = tenantRepository.getAllTenant()

    fun insertProperty(properti: Properti) =
        viewModelScope.launch(Dispatchers.IO) { propertyRepository.insertProperty(properti) }

    fun insertTenant(tenant: Tenant) = tenantRepository.insertTenant(tenant)

}
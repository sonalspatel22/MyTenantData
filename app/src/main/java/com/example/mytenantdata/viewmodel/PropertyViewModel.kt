package com.example.mytenantdata.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mytenantdata.data.room.dao.repo.PropertyRepository
import com.example.mytenantdata.data.room.dao.repo.TenantRepository
import com.example.mytenantdata.model.Property
import com.example.mytenantdata.model.Tenant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.io.File

class PropertyViewModel(
    private val propertyRepository: PropertyRepository,
    private val tenantRepository: TenantRepository
) : ViewModel() {

    var propertyAdded :MutableLiveData<Property> = MutableLiveData()

    val imageList : MutableList<File> = mutableListOf()
    var AllProperty = propertyRepository.getAllProperty().asLiveData()

    fun getAllTenant(): Flow<List<Tenant>> = tenantRepository.getAllTenant()

    fun insertProperty(property: Property) = viewModelScope.launch(Dispatchers.IO) { propertyRepository.insertProperty(property) }

    fun insertTenant(tenant: Tenant) = tenantRepository.insertTenant(tenant)

    fun addImageFile(vararg file: File) {
        imageList.addAll(file)
    }

    fun insertProperty(name: String, address: String) {
        val properti =  Property(name = name, address = address, images = imageList.toString())
        viewModelScope.launch(Dispatchers.IO){
            propertyRepository.insertProperty(properti)
            propertyAdded.postValue(properti)
        }
    }

}
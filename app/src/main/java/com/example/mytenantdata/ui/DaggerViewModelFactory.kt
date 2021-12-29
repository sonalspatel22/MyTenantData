package com.example.mytenantdata.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytenantdata.data.room.dao.repo.PropertyRepository
import com.example.mytenantdata.data.room.dao.repo.TenantRepository
import com.example.mytenantdata.viewmodel.PropertyViewModel
import java.lang.IllegalArgumentException
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

//@Suppress("UNCHECKED_CAST")
//class DaggerViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        var creator=creators[modelClass]
//        if(creator==null){
//            for((key,value) in creators){
//                if(modelClass.isAssignableFrom(key)){
//                    creator=value
//                    break
//                }
//            }
//        }
//        requireNotNull(creator){"unknown model class $modelClass"}
//        try {
//            return creator.get() as T
//        }catch (e:Exception){
//            throw RuntimeException(e)
//        }
//    }
//
//}

class PropertyViewModelFactory(private val propertyRepository: PropertyRepository, private val tenantRepository: TenantRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PropertyViewModel::class.java)) {
            return PropertyViewModel(propertyRepository, tenantRepository = tenantRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}


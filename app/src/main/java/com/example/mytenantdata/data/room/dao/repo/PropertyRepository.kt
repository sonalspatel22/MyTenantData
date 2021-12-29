package com.example.mytenantdata.data.room.dao.repo

import com.example.mytenantdata.data.room.dao.PropertyDao
import com.example.mytenantdata.model.Properti

class PropertyRepository(private val propertyDao: PropertyDao) {

    fun getAllProperty() = propertyDao.getAllProperty()

     suspend fun insertProperty(vararg properti: Properti) = propertyDao.insertAllProperty(*properti)
}
package com.example.mytenantdata.data.room.dao.repo

import com.example.mytenantdata.data.room.dao.TenantDao
import com.example.mytenantdata.model.Tenant

class TenantRepository(private val tenantDao: TenantDao) {

    fun getAllTenant() = tenantDao.getAllProperty()

    fun insertTenant(vararg tenant: Tenant) = tenantDao.insertAllProperty(*tenant)
}
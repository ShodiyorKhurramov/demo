package com.example.demo.services

import com.example.demo.dtos.CompanyCreateDto
import com.example.demo.dtos.CompanyResponseDto
import com.example.demo.dtos.CompanyUpdateDto


interface  CompanyService {

    fun create(dto: CompanyCreateDto)
    fun update(companyId:Long,dto: CompanyUpdateDto)
    fun getAll(): List<CompanyResponseDto>
    fun getOne(id: Long): CompanyResponseDto
    fun delete(id: Long)
}
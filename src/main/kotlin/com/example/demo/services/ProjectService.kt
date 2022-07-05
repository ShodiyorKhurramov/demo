package com.example.demo.services

import com.example.demo.dtos.*


interface ProjectService {

    fun create(dto: ProjectCreateDto)
    fun addProjectCompany(companyId:Long,dto: addProjectCompanyDto)
    fun update(projectId:Long,dto: ProjectUpdateDto)
    fun getAll(): List<ProjectResponseDto>
    fun getOne(id: Long): ProjectResponseDto
    fun delete(id: Long)
}
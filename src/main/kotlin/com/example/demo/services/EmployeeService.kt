package com.example.demo.services

import com.example.demo.dtos.*


interface EmployeeService {
    fun create(dto: EmployeeCreateDto)
    fun getOne(id:Long):getEmployee
    fun getAll(): List<EmployeeResponseDto>
    fun addEmployeeCompany(companyId:Long,dto: addEmployeeDto)
    fun addEmployeeProject(projectId:Long,dto: addEmployeeDto)
    fun delete(id:Long)

}

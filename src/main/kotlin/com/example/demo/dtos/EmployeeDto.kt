package com.example.demo.dtos

import com.example.demo.entities.Company
import com.example.demo.entities.Employee
import com.example.demo.entities.Region


data class EmployeeCreateDto(
        val name: String,
        val age: Int,
        val job: String,
        val roleName: String
)


data class addEmployeeDto(
        val employeeIds: List<Long>

)

data class getEmployee(
        val id: Long,
        val name: String,
        val age: Int,
        val job: String,
        val roleName: String,
        val companyName: String,
        val projectName: String

)


data class EmployeeResponseDto(
        val id: Long?,
        val name: String,
        val age: Int,
        val job: String,
        val roleName: String
) {
    companion object {
        fun toDto(r: Employee) = r.run {
            EmployeeResponseDto(id, name, age, job, role.name)
        }
    }
}





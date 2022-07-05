package com.example.demo.repositories

import com.example.demo.entities.Company
import com.example.demo.entities.Employee
import org.springframework.data.jpa.repository.Query


interface EmployeeRepository : BaseRepository<Employee> {
//    fun existsByUsername(username: String): Boolean


}
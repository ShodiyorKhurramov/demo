package com.example.demo.companent

import com.example.demo.entities.Employee
import com.example.demo.entities.Role
import com.example.demo.enums.Permisson

import com.example.demo.repositories.EmployeeRepository
import com.example.demo.repositories.RoleRepository
import com.example.demo.utils.AppCanstans
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class DataLoader(
        @Value("\${spring.sql.init.mode}") private val mode: String,
        private val employeeRepository: EmployeeRepository,
        private val roleRepository: RoleRepository
) : CommandLineRunner {


    override fun run(vararg args: String?) {

        if (mode == "always") {
            val permission = Permisson.values()

            val admin = roleRepository.save(Role(AppCanstans.ADMIN, permission.toList()))
            val employee = roleRepository.save(Role(AppCanstans.EMPLOYEE, arrayOf(Permisson.EDIT_MY_NAME).toList()))

            employeeRepository.save(Employee("Shodiyor", 22, "Director", admin))

            employeeRepository.save(Employee("Abdulaziz", 23, "employee", employee))






        }

    }
}
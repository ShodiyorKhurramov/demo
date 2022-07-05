package com.example.demo.controllers

import com.example.demo.dtos.*
import com.example.demo.services.EmployeeService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("employee")
class EmployeeController(private val employeeService: EmployeeService) {

    @PostMapping("create")
    fun create(@RequestBody dto: EmployeeCreateDto) = employeeService.create(dto)

    @PutMapping("company/{companyId}")
    fun addEmployeeCompany(@PathVariable companyId: Long, @RequestBody dto: addEmployeeDto) = employeeService.addEmployeeCompany(companyId, dto)

    @PutMapping("project/{projectId}")
    fun addEmployeeProject(@PathVariable projectId: Long, @RequestBody dto: addEmployeeDto) = employeeService.addEmployeeProject(projectId, dto)

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = employeeService.getOne(id)

    @GetMapping
    fun getAll() = employeeService.getAll()

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = employeeService.delete(id)

}
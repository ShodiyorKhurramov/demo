package com.example.demo.controllers

import com.example.demo.dtos.RoleCreateDto
import com.example.demo.services.EmployeeService
import com.example.demo.services.RoleService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("role")
class RoleController(
        private val roleService: RoleService
){
    @PostMapping("create")
    fun create(@RequestBody dto: RoleCreateDto) = roleService.create(dto)
}
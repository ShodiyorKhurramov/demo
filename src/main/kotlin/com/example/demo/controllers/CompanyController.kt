package com.example.demo.controllers

import com.example.demo.dtos.CompanyCreateDto
import com.example.demo.dtos.CompanyUpdateDto
import com.example.demo.services.CompanyService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("company")
class CompanyController(
        private val companyService: CompanyService
) {

    @PostMapping("create")
    fun create(@RequestBody dto: CompanyCreateDto) = companyService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: CompanyUpdateDto) = companyService.update(id, dto)

    @GetMapping
    fun getAll() = companyService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = companyService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = companyService.delete(id)
}
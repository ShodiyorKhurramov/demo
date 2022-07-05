package com.example.demo.controllers

import com.example.demo.dtos.ProjectCreateDto
import com.example.demo.dtos.ProjectUpdateDto
import com.example.demo.dtos.addProjectCompanyDto
import com.example.demo.services.ProjectService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("project")
class ProjectController(
        private val projectService: ProjectService
){

    @PostMapping("create")
    fun create(@RequestBody dto: ProjectCreateDto)=projectService.create(dto)

    @PutMapping("{add}/{id}")
    fun addProjectCompany(@PathVariable id: Long, @RequestBody dto: addProjectCompanyDto) = projectService.addProjectCompany(id, dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: ProjectUpdateDto) = projectService.update(id, dto)

    @GetMapping
    fun getAll() = projectService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = projectService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = projectService.delete(id)
}
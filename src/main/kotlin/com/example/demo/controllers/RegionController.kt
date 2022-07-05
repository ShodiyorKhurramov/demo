package com.example.demo.controllers

import com.example.demo.dtos.RegionCreateDto
import com.example.demo.dtos.RegionUpdateDto
import com.example.demo.services.RegionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("region")
class RegionController(
    private val regionService: RegionService,
) {

    @PostMapping("create")
    fun create(@RequestBody dto: RegionCreateDto) = regionService.create(dto)

    @GetMapping
    fun getAll() = regionService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = regionService.getOne(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: RegionUpdateDto) = regionService.update(id, dto)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = regionService.delete(id)
}

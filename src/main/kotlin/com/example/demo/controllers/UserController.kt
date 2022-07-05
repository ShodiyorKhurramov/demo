package com.example.demo.controllers

import com.example.demo.UserCreateDto
import com.example.demo.UserUpdateDto
import com.example.demo.services.UserService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("users")
class UserController(
    private val userService: UserService,
) {

    @PostMapping("create")
    fun create(@RequestBody dto: UserCreateDto) = userService.create(dto)

    @GetMapping
    fun getAll(s: String, pageable: Pageable) = userService.getAll(s,pageable)


    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = userService.getOne(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: UserUpdateDto) = userService.update(id, dto)


    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = userService.delete(id)


}
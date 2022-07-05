package com.example.demo.services

import com.example.demo.UserCreateDto
import com.example.demo.UserResponseDto
import com.example.demo.UserUpdateDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface UserService {
    fun create(dto: UserCreateDto)
    fun getAll(s:String,pageable: Pageable): Page<UserResponseDto>
    fun getOne(id: Long): UserResponseDto
    fun update(id: Long, dto: UserUpdateDto)
    fun delete(id: Long)



}

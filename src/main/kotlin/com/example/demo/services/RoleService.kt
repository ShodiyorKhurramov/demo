package com.example.demo.services

import com.example.demo.dtos.DistrictCreateDto
import com.example.demo.dtos.DistrictResponseDto
import com.example.demo.dtos.DistrictUpdateDto
import com.example.demo.dtos.RoleCreateDto
import org.springframework.stereotype.Service

@Service
interface RoleService {
    fun create(dto: RoleCreateDto):String


}

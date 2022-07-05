package com.example.demo.services

import com.example.demo.dtos.RegionCreateDto
import com.example.demo.dtos.RegionResponseDto
import com.example.demo.dtos.RegionUpdateDto

interface RegionService {
    fun create(dto: RegionCreateDto)
    fun getAll(): List<RegionResponseDto>
    fun getOne(id: Long): RegionResponseDto
    fun update(id: Long, dto: RegionUpdateDto)
    fun delete(id: Long)

}
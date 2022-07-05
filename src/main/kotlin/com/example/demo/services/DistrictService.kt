package com.example.demo.services

import com.example.demo.dtos.DistrictCreateDto
import com.example.demo.dtos.DistrictResponseDto
import com.example.demo.dtos.DistrictUpdateDto


interface DistrictService {
    fun create(dto: DistrictCreateDto)
    fun getAll(regionId: Long): List<DistrictResponseDto>
    fun getOne(districtId: Long): DistrictResponseDto
    fun update(id: Long, dto: DistrictUpdateDto)
    fun delete(id: Long)


}

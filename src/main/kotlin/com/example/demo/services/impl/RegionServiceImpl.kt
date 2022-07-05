package com.example.demo.services.impl

import com.example.demo.dtos.RegionCreateDto
import com.example.demo.dtos.RegionResponseDto
import com.example.demo.dtos.RegionUpdateDto
import com.example.demo.entities.Region
import com.example.demo.repositories.DistrictRepository
import com.example.demo.repositories.RegionRepository
import com.example.demo.services.RegionService
import org.springframework.stereotype.Service

@Service
class RegionServiceImpl(
    private val districtRepository: DistrictRepository,
    private val regionRepository: RegionRepository
) : RegionService {


    override fun create(dto: RegionCreateDto) {
        regionRepository.save(Region(dto.name))

    }

    override fun getAll() = regionRepository.findAll().map { RegionResponseDto.toDto(it) }

    override fun getOne(id: Long): RegionResponseDto {
        val region = regionRepository.findById(id).orElseThrow { Exception("Region not found by id: $id") }
        return RegionResponseDto.toDto(region)
    }

    override fun update(id: Long, dto: RegionUpdateDto) {
        val region = regionRepository.findById(id).orElseThrow { Exception("Region not found by id: $id") }
        dto.apply {
            name?.let {
                region.name = it
            }

        }
        regionRepository.save(region)
    }


    override fun delete(id: Long) {

        val allDistrict = districtRepository.findAllByRegionId(id)
        districtRepository.deleteAll(allDistrict)
        regionRepository.deleteById(id)

    }
}
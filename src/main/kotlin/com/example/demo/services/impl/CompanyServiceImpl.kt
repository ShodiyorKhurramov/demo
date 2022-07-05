package com.example.demo.services.impl

import com.example.demo.dtos.CompanyCreateDto
import com.example.demo.dtos.CompanyResponseDto
import com.example.demo.dtos.CompanyUpdateDto
import com.example.demo.entities.Company
import com.example.demo.repositories.CompanyRepository
import com.example.demo.repositories.DistrictRepository
import com.example.demo.repositories.RoleRepository
import com.example.demo.services.CompanyService
import org.springframework.stereotype.Service

@Service
class CompanyServiceImpl(private val companyRepository: CompanyRepository, private val roleRepository: RoleRepository, private val districtRepository: DistrictRepository

) : CompanyService {
    override fun create(dto: CompanyCreateDto) {
        val district = districtRepository.findByName(dto.district)
        companyRepository.save(Company(dto.name, district))
    }

    override fun update(companyId: Long, dto: CompanyUpdateDto) {
        val company = companyRepository.findById(companyId).orElseThrow { Exception("Company not by id: $companyId") }
        dto.apply {
            name?.let { company.name = it }
            districtId?.let {
                company.district = districtRepository.findById(it).orElseThrow { Exception("District not by id: $districtId") }
            }
        }

        companyRepository.save(company)
    }

    override fun getAll() = companyRepository.findAll().map { CompanyResponseDto.toDto(it) }
    override fun getOne(id: Long) = CompanyResponseDto.toDto(companyRepository.findById(id).orElseThrow { Exception("Region not found by id: $id") })
    override fun delete(id: Long) { companyRepository.deleteById(id) }


}












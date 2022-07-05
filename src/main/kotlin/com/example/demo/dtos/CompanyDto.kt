package com.example.demo.dtos

import com.example.demo.entities.*

data class CompanyCreateDto(
        val name: String,
        val district: String
)


data class CompanyUpdateDto(
        val name: String?,
        val districtId: Long?
)

data class CompanyResponseDto(
        val id: Long?,
        val name: String,
        val districtId: Long?

) {
    companion object {
        fun toDto(r: Company) = r.run {
            CompanyResponseDto(id, name, district.id)
        }
    }
}







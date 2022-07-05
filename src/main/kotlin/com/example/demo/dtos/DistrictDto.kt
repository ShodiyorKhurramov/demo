package com.example.demo.dtos

import com.example.demo.entities.District


data class DistrictCreateDto(
    val name: String,
    val regionId: Long


)

data class DistrictUpdateDto(
    val name: String? = null,
    val regionId: Long? = null
)

data class DistrictResponseDto(
    val id: Long?,
    val name: String,
) {
    companion object {
        fun toDto(r: District) = r.run {
            DistrictResponseDto(id, name)
        }
    }
}


package com.example.demo.dtos

import com.example.demo.entities.Region

data class RegionCreateDto(
    val name: String,
)

data class RegionUpdateDto(
    val name: String? = null,
)

data class RegionResponseDto(
    val id: Long?,
    val name: String,
) {
    companion object {
        fun toDto(r: Region) = r.run {
            RegionResponseDto(id, name)
        }
    }
}

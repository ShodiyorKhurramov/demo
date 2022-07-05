package com.example.demo

import com.example.demo.entities.User


data class UserCreateDto(
    val first_name: String,
    val last_name: String,
    val user_name: String,
    val regionId: Long,
    val districtId: Long
)

data class UserUpdateDto(
    val first_name: String,
    val last_name: String,
    val user_name: String,
    val regionId: Long,
    val districtId: Long
)


data class UserResponseDto(
    val id: Long?,
    val first_name: String,
    val last_name: String,
    val user_name: String,
    val district: String

) {
    companion object {
        fun toDto(r: User) = r.run {
            UserResponseDto(id, first_name, last_name, user_name, district.name)
        }
    }
}



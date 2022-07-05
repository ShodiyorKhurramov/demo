package com.example.demo.services.impl

import com.example.demo.UserCreateDto
import com.example.demo.UserResponseDto
import com.example.demo.UserUpdateDto
import com.example.demo.entities.User
import com.example.demo.repositories.DistrictRepository
import com.example.demo.repositories.UserRepository
import com.example.demo.services.UserService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val districtRepository: DistrictRepository
) : UserService {
    override fun create(dto: UserCreateDto) {
        val district = districtRepository.findById(dto.districtId).orElseThrow { Exception("Region not found by id: ${dto.regionId}") }
        userRepository.save(User(dto.first_name, dto.last_name, dto.user_name,district))
    }
    override fun getAll(s:String,pageable: Pageable)= userRepository.search(s,pageable).map { UserResponseDto.toDto(it) }
    override fun getOne(id: Long)= UserResponseDto.toDto( userRepository.findById(id).orElseThrow { Exception("Region not found by id: $id") })
    override fun update(id: Long, dto: UserUpdateDto) {
        val user = userRepository.findById(id).orElseThrow { Exception("District not by id: $id") }

        dto.apply {
            user.first_name = first_name
            user.last_name = last_name
            user.user_name = user_name


            districtId.let {
                val district = districtRepository.findById(it).orElseThrow { Exception("District not by id: $id") }
                user.district = district
            }

        }
        userRepository.save(user)

    }
    override fun delete(id: Long) {
        userRepository.deleteById(id)
    }



}

package com.example.demo.services.impl

import com.example.demo.dtos.RoleCreateDto
import com.example.demo.entities.Role
import com.example.demo.repositories.RoleRepository
import com.example.demo.services.RoleService
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl(
        private val roleRepository: RoleRepository
) : RoleService {
    override fun create(dto: RoleCreateDto):String {
        if (roleRepository.existsByName(dto.name))
            return  "Bunday role yo'q"

        val role=Role(dto.name,dto.permission)

        roleRepository.save(role)

        return "Saqlandi"

    }



}
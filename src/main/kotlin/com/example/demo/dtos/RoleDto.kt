package com.example.demo.dtos

import com.example.demo.enums.Permisson

data class RoleCreateDto(
         val name: String,
         val permission: List<Permisson>
        )



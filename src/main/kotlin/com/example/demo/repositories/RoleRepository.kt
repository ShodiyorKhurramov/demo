package com.example.demo.repositories

import com.example.demo.entities.Role

interface RoleRepository : BaseRepository<Role> {

    fun existsByName(name:String):Boolean

    fun findByName(name: String):Role


}
package com.example.demo.repositories

import com.example.demo.entities.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query


interface UserRepository : BaseRepository<User> {

    @Query("select u from users u where u.first_name like %?1%")
    fun search(s: String, pageable: Pageable): Page<User>

    
}
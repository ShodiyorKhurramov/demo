package com.example.demo.entities

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table


@Entity(name = "users")
class User(
    var first_name: String,
    var last_name: String,
    var user_name: String,
    @ManyToOne
    var district: District

) : BaseEntity()

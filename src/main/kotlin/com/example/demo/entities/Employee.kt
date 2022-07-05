package com.example.demo.entities

import javax.persistence.*

@Entity
//@Table(uniqueConstraints = [UniqueConstraint(name = "", ["username"])])
class Employee(
//        @Column(unique = true)
//        val username: String,
        val name: String,
        val age: Int,
        val job: String,
        @ManyToOne(optional = false, fetch = FetchType.LAZY) val role: Role,
        ) : BaseEntity()






package com.example.demo.entities

import com.example.demo.enums.Permisson
import javax.persistence.*

@Entity
class Role(
        @Column(unique = true, nullable = false) val name: String,

           @Enumerated(value = EnumType.STRING)
           @ElementCollection val permission: List<Permisson>) : BaseEntity()
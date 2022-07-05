package com.example.demo.entities

import javax.persistence.*


@Entity
class Company(var name: String,

              @ManyToOne var district: District,

              @OneToMany(cascade= [CascadeType.ALL]) var employee: MutableList<Employee>? = null,

              @OneToMany(cascade= [CascadeType.ALL], orphanRemoval = true) var project: MutableList<Project>? = null

) : BaseEntity()
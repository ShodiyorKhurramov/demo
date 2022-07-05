package com.example.demo.entities

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne


@Entity
class Project(
        var name: String,
        var time: String,
        var cost: String,
        @ManyToMany(cascade = [CascadeType.PERSIST,CascadeType.MERGE])
        var employee: MutableList<Employee>?=null,


) : BaseEntity()

package com.example.demo.entities

import javax.persistence.Entity

@Entity
class File(var fileOrginalName: String, var size: Long, var contentType: String?, var uuid: String, var filePath: String) : BaseEntity()


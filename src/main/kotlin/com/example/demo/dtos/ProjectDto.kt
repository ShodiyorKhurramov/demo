package com.example.demo.dtos

import com.example.demo.entities.Project

data class ProjectCreateDto(
        val name:String,
        val time:String,
        val cost:String

)


data class ProjectUpdateDto(
        var name:String?,
        var time:String?,
        var cost:String?

)

data class addProjectCompanyDto(
        val projectIds:List<Long>

)



data class ProjectResponseDto(
        val id: Long?,
        val name: String,
        var time: String,
        var cost: String

) {
    companion object {
        fun toDto(r: Project) = r.run {
            ProjectResponseDto(id,name,time,cost)
        }
    }
}

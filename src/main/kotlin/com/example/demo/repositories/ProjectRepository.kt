package com.example.demo.repositories

import com.example.demo.entities.Employee
import com.example.demo.entities.Project
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface ProjectRepository : BaseRepository<Project> {
    fun findByEmployeeIn(employee: List<Employee>): Project

   /* @Query("delete  from Company c where c.project = ?1")
    fun deleteProjectFromCPById(project_id: Long): List<Project>*/


    @Modifying
    @Query("delete from public.company_project where project_id = ?1", nativeQuery = true)
    fun deleteProjectFromCPById(id: Long)

    fun findAllByEmployeeId(id:Long):List<Project>

}

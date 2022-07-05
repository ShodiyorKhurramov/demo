package com.example.demo.services.impl

import com.example.demo.dtos.*
import com.example.demo.entities.Employee
import com.example.demo.entities.Project
import com.example.demo.repositories.CompanyRepository
import com.example.demo.repositories.ProjectRepository
import com.example.demo.services.ProjectService
import org.springframework.stereotype.Service

@Service
class ProjectServiceImpl(
        private val projectRepository: ProjectRepository,
        private val companyRepository: CompanyRepository

) : ProjectService {
    override fun create(dto: ProjectCreateDto) {

        val project = Project(dto.name, dto.time, dto.cost)
        projectRepository.save(project)


    }

    override fun addProjectCompany(companyId: Long, dto: addProjectCompanyDto) {
        val company = companyRepository.findById(companyId).orElseThrow { Exception("Company not found by id: $companyId") }
        for (projectId in dto.projectIds!!) {
            val project = projectRepository.findById(projectId).orElseThrow { Exception("Employee not found by id: $projectId") }

            if (company.project == null) {
                val array = mutableListOf<Project>()
                array.add(project)
                company.project = array
            } else {
                company.project!!.add(project)

            }




            companyRepository.save(company)


        }
    }

    override fun update(projectId: Long, dto: ProjectUpdateDto) {
        val project = projectRepository.findById(projectId).orElseThrow { Exception("Company not by id: $projectId") }
        dto.apply {
            name?.let { project.name = it }
            time?.let { project.time = it }
            cost?.let { project.cost = it }
        }
        projectRepository.save(project)


    }

    override fun getAll(): List<ProjectResponseDto> = projectRepository.findAll().map { ProjectResponseDto.toDto(it) }

    override fun getOne(id: Long) = ProjectResponseDto.toDto(projectRepository.findById(id).orElseThrow { Exception("Region not found by id: $id") })

    override fun delete(id: Long) {
        projectRepository.deleteProjectFromCPById(id);
        projectRepository.deleteById(id)

    }


}
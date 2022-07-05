package com.example.demo.services.impl

import com.example.demo.dtos.*
import com.example.demo.entities.Employee
import com.example.demo.repositories.CompanyRepository
import com.example.demo.repositories.EmployeeRepository
import com.example.demo.repositories.ProjectRepository
import com.example.demo.repositories.RoleRepository
import com.example.demo.services.EmployeeService
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class EmployeeServiceImpl(
        private val employeeRepository: EmployeeRepository,
        private val roleRepository: RoleRepository,
        private val companyRepository: CompanyRepository,
        private val projectRepository: ProjectRepository
) : EmployeeService {
    override fun create(dto: EmployeeCreateDto) {
        val role = roleRepository.findByName(dto.roleName)
        val employee = Employee(dto.name, dto.age, dto.job, role)
        employeeRepository.save(employee)


    }

    override fun getOne(id: Long): getEmployee {
        val employee = employeeRepository.findById(id).orElseThrow { Exception("Employee not found by id: $id") }
        val company = companyRepository.findEmployeeCompany(employee)

//        val c=companyRepository.findByEmployeeIn(listOf(employee))
        val project = projectRepository.findByEmployeeIn(listOf(employee))

        employee.apply {
            return getEmployee(id, name, age, job, role.name, company!!.name, project.name)
        }


    }

    override fun getAll()=employeeRepository.findAll().map { EmployeeResponseDto.toDto(it) }


    override fun addEmployeeCompany(companyId: Long, dto: addEmployeeDto) {


        val company = companyRepository.findById(companyId).orElseThrow { Exception("Company not found by id: $companyId") }
        for (employeeId in dto.employeeIds) {
            val employee = employeeRepository.findById(employeeId).orElseThrow { Exception("Employee not found by id: $employeeId") }

            if (company.employee == null) {
                val array = mutableListOf<Employee>()
                array.add(employee)
                company.employee = array
            } else {
                company.employee!!.add(employee)

            }




            companyRepository.save(company)

        }
    }

    override fun addEmployeeProject(projectId: Long, dto: addEmployeeDto) {
        val project = projectRepository.findById(projectId).orElseThrow { Exception("Project not found by id: $projectId") }
        for (employeeId in dto.employeeIds) {
            val employee = employeeRepository.findById(employeeId).orElseThrow { Exception("Employee not found by id: $employeeId") }

            if (project.employee == null) {
                val array = mutableListOf<Employee>()
                array.add(employee)
                project.employee = array
            } else {
                project.employee!!.add(employee)

            }


            projectRepository.save(project)

        }
    }

    override fun delete(id: Long) {

        val projects = projectRepository.findAllByEmployeeId(id)
        val companys=companyRepository.findAllByEmployeeId(id)
        projectRepository.deleteAll(projects)
        companyRepository.deleteAll(companys)
        employeeRepository.deleteById(id)

    }
}

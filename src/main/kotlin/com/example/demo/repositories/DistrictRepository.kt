package com.example.demo.repositories

import com.example.demo.entities.District
import org.springframework.data.jpa.repository.Query


interface DistrictRepository : BaseRepository<District> {
    @Query("select d from District d where d.region.id = ?1")
    fun findAllByRegionId(region_id: Long): List<District>

    fun findByName(districtName:String):District



}
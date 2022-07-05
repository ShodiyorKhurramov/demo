package com.example.demo.services

import org.springframework.core.io.Resource
import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun fileUpload(file: MultipartFile)
    fun fileDownload(fileName: String): Resource

}

package com.example.demo.controllers

import com.example.demo.services.FileService
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("file")
class FileController(
    private val fileService: FileService
) {
    @PostMapping("upload")
    fun uploadFile(file: MultipartFile) = fileService.fileUpload(file)

    @GetMapping("/download/{filename}")
    fun downloadFile(@PathVariable filename: String): ResponseEntity<Any> {
        val file = fileService.fileDownload(filename)
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
            .body(file);
    }

}
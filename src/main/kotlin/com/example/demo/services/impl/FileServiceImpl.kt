package com.example.demo.services.impl

import com.example.demo.entities.File
import com.example.demo.repositories.FileRepository
import com.example.demo.services.FileService
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.FileOutputStream
import java.nio.file.Paths
import java.util.*


@Service
class FileServiceImpl(
    private val fileRepository: FileRepository
) : FileService {


    override fun fileUpload(file: MultipartFile) {
        val path = "C:\\Users\\user\\Desktop\\demo\\src\\main\\resources\\static\\"
        val date = Date().time
        val savedPath = path + date + file.originalFilename?.let { getFileExtention(it) }




        file.apply {
            val fos =   FileOutputStream(path)
            fos.write(bytes)
            fileRepository.save(
                File(
                    originalFilename ?: "",
                    size,
                    contentType,
                    UUID.randomUUID().toString(),
                    savedPath
                )
            )
        }


    }


    override fun fileDownload(filename: String): Resource {
        val paths = Paths.get("C:\\Users\\user\\Desktop\\demo\\src\\main\\resources\\static")
        val file = paths.resolve(filename)
        val resource = UrlResource(file.toUri())

        if (resource.exists() || resource.isReadable) {
            return resource
        } else {
            throw RuntimeException("FAIL!")
        }
    }

}

//@Service
//class FileStorageImpl: FileStorage {
//
//    val rootLocation = Paths.get("C:\\Users\\user\\Desktop\\demo\\src\\main\\resources\\static")
//
//    override fun store(file: MultipartFile) {
//        Files.copy(file.getInputStream(), this.rootLocation.resolve(file.originalFilename))
//    }
//
//    override fun init(){
//        Files.createDirectory(rootLocation)
//    }
//
//    override fun loadFile(filename: String): Resource{
//        val file = rootLocation.resolve(filename)
//        val resource = UrlResource(file.toUri())
//
//        if(resource.exists() || resource.isReadable()) {
//            return resource
//        }else{
//            throw RuntimeException("FAIL!")
//        }
//    }
//}

fun getFileExtention(fileName: String): String {
    val split = fileName.split("\\.")
    return split[split.size - 1]
}




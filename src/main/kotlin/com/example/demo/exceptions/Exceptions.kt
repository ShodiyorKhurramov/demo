package com.example.demo.exceptions

import com.example.demo.dtos.BaseCodeMessageDto

class MyException(private val code: Int, message: String) : RuntimeException(message) {
    fun toDto() = BaseCodeMessageDto(code, message!!)
}
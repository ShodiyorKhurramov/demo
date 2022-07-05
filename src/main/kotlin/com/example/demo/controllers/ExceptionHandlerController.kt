package com.example.demo.controllers

import com.example.demo.dtos.BaseCodeMessageDto
import com.example.demo.exceptions.MyException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ExceptionHandlerController {

    @ExceptionHandler(MyException::class)
    fun myExceptionHandler(myException: MyException): ResponseEntity<BaseCodeMessageDto> {
        return ResponseEntity.badRequest().body(myException.toDto())
    }
}
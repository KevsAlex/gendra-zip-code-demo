package com.gendra.gendrazipmanager.exception

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

import org.springframework.web.context.request.WebRequest
import java.lang.Exception

@ControllerAdvice
@RestController
class DefaultErrorHandler : ResponseEntityExceptionHandler(){

    private val LOGGER: Logger = LoggerFactory.getLogger(DefaultErrorHandler::class.java)

    @Value("\${spring.application.name}")
    lateinit var  applicationName: String

    /**
     * Handles not found exception
     */
    @ExceptionHandler(value = [(Exception::class)])
    @Throws(Exception::class)
    fun handleNotFoundException(ex: NotFoundException, request: WebRequest?): ResponseEntity<Any?> {
        LOGGER.error(
            java.lang.String.format(
                "[%s][%s][%s][%s][%s][%s]", applicationName, ex.className,
                HttpStatus.CONFLICT, ex.customCode, ex.responseMessage,
                ex.message
            )
        )
        val response = ExceptionResponse(ex.customCode!!, ex.responseMessage!!)
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

}
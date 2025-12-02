package com.learnwithravi.kotlinspring.exceptionhandler

import com.learnwithravi.kotlinspring.exception.InstructorNotValidException
import mu.KLogging
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@Component
@ControllerAdvice
class GlobalHandler : ResponseEntityExceptionHandler() {

//    companion object : KLogging()
    private val logger = LoggerFactory.getLogger(GlobalHandler::class.java)



    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: org.springframework.http.HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errors = ex.bindingResult
            .allErrors
            .map { it.defaultMessage ?: "Validation error" }
            .sorted()

        val bodyString = errors.joinToString(", ")

        val responseHeaders = HttpHeaders()
        responseHeaders.contentType = MediaType.TEXT_PLAIN
            logger.error("error messages $bodyString")
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .headers(responseHeaders)
            .body(bodyString)
    }
    @ExceptionHandler(InstructorNotValidException::class)
    fun instructorNotValidExceptions(ex: InstructorNotValidException, request: WebRequest): ResponseEntity<Any> {

        logger.error("Exception caught in handling ${ex.message}")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("unexpected error occurred")
    }


    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<Any> {

        logger.error("Exception caught in handling ${ex.message}")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("unexpected error occurred")
    }
}
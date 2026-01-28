package com.learnwithravi.kotlinspring.controller

import com.learnwithravi.kotlinspring.service.GreetingService
import mu.KLogging
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings")
class GreetingController(val greetingService: GreetingService) {

    companion object  : KLogging()


    @GetMapping("/{name}")
    fun retriveGreeting(@PathVariable(value = "name") name: String): String {
//        return "Hello $name"
        logger.info { "Greeting $name" }
        return  greetingService.retriveGreeting(name)
    }
}
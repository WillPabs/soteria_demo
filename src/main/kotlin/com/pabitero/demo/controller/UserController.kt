package com.pabitero.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController("api")
class UserController {

    @GetMapping("/users")
    fun getUsers() {

    }

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: Int) {

    }
}
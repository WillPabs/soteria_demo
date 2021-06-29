package com.pabitero.demo.controller

import com.pabitero.demo.entity.User
import com.pabitero.demo.service.UserService
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.core.Ordered
import org.springframework.web.bind.annotation.*
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import java.util.*
import javax.servlet.Filter

@RestController
class UserController (private val userService: UserService) {

    @GetMapping("/api/users")
    fun getUsers(): List<User> = userService.getAllUsers()

    @GetMapping("/api/user/{id}")
    fun getUserById(@PathVariable id: Long): User = userService.getUserById(id)

    @PostMapping("/api/users")
    fun createUser(@RequestBody payload: User): User = userService.createUser(payload)

    @Bean
    fun simpleCorsFilter(): FilterRegistrationBean<*> {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        // *** URL below needs to match the Vue client URL and port ***
        config.allowedOrigins = Collections.singletonList("http://localhost:3000")
        config.allowedMethods = Collections.singletonList("*")
        config.allowedHeaders = Collections.singletonList("*")
        source.registerCorsConfiguration("/**", config)
        val bean = FilterRegistrationBean<Filter>(CorsFilter(source))
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE)
        return bean
    }

}
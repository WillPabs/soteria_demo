package com.pabitero.demo.service

import com.pabitero.demo.entity.User
import com.pabitero.demo.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService (private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUserById(userId: Long): User = userRepository.findById(userId)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User was not found") }

    fun createUser(user: User): User = userRepository.save(user)

}
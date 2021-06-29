package com.pabitero.demo.entity

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        @Column(name = "first_name", nullable = false)
        var firstName: String = "",
        @Column(name = "last_name", nullable = false)
        var lastName: String = "",
        @Column(name = "email", nullable = false)
        var email: String = ""
)
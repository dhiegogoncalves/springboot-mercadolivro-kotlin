package com.dhiego.mercadolivro.models

import com.dhiego.mercadolivro.enums.CustomerStatus
import javax.persistence.*

@Entity(name = "customer")
data class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column(unique = true)
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus? = null,
)
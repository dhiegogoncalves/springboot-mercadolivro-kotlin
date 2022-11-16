package com.dhiego.mercadolivro.repository

import com.dhiego.mercadolivro.models.Customer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Int> {
    fun findAllByNameContainingIgnoreCase(name: String, pageable: Pageable): Page<Customer>
}
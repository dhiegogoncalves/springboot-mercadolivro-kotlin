package com.dhiego.mercadolivro.repository

import com.dhiego.mercadolivro.models.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Int> {

    fun findByNameContainingIgnoreCase(name: String): List<Customer>
}
package com.dhiego.mercadolivro.repository

import com.dhiego.mercadolivro.enums.BookStatus
import com.dhiego.mercadolivro.models.Book
import com.dhiego.mercadolivro.models.Customer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Int> {
    fun findAllByNameContainingIgnoreCase(name: String, pageable: Pageable): Page<Book>
    fun findAllByStatus(status: BookStatus,  pageable: Pageable): Page<Book>
    fun findAllByCustomer(customer: Customer) : List<Book>
}
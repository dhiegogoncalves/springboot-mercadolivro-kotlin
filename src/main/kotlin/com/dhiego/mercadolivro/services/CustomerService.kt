package com.dhiego.mercadolivro.services

import com.dhiego.mercadolivro.enums.CustomerStatus
import com.dhiego.mercadolivro.models.Customer
import com.dhiego.mercadolivro.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {
    fun findAll(pageable: Pageable, name: String?): Page<Customer> {
        name?.let {
            return customerRepository.findAllByNameContainingIgnoreCase(it, pageable)
        }
        return customerRepository.findAll(pageable)
    }

    fun findById(id: Int): Customer {
        return customerRepository.findById(id).orElseThrow()
    }

    fun create(customer: Customer) {
        save(customer)
    }

    private fun save(customer: Customer) {
        customerRepository.save(customer)
    }

    fun update(customer: Customer) {
        save(customer)
    }

    fun delete(id: Int) {
        val customer = findById(id)

        bookService.deleteByCustomer(customer)
        customer.status = CustomerStatus.INATIVO
        update(customer)
    }
}
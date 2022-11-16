package com.dhiego.mercadolivro.services

import com.dhiego.mercadolivro.models.Customer
import com.dhiego.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {
    fun getAll(name: String?): List<Customer> {
        name?.let {
            return customerRepository.findByNameContainingIgnoreCase(it)
        }
        return customerRepository.findAll().toList()
    }

    fun getCustomer(id: Int): Customer {
        return customerRepository.findById(id).orElseThrow()
    }

    fun create(customer: Customer) {
        customerRepository.save(customer)
    }

    fun update(customer: Customer) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }

        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        if (!customerRepository.existsById(id)) {
            throw Exception()
        }

        customerRepository.deleteById(id)
    }
}
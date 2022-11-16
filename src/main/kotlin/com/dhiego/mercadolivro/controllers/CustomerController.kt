package com.dhiego.mercadolivro.controllers

import com.dhiego.mercadolivro.controllers.dtos.CreateCustomerRequest
import com.dhiego.mercadolivro.controllers.dtos.UpdateCustomerRequest
import com.dhiego.mercadolivro.models.Customer
import com.dhiego.mercadolivro.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<Customer> {
        return customerService.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: CreateCustomerRequest) {
        customerService.create(customer.toCustomer())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): Customer {
        return customerService.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: UpdateCustomerRequest) {
        customerService.update(customer.toCustomer(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }
}
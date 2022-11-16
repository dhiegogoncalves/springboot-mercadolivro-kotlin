package com.dhiego.mercadolivro.controllers

import com.dhiego.mercadolivro.controllers.request.CreateCustomerRequest
import com.dhiego.mercadolivro.controllers.request.UpdateCustomerRequest
import com.dhiego.mercadolivro.controllers.response.CustomerResponse
import com.dhiego.mercadolivro.extesions.toResponse
import com.dhiego.mercadolivro.services.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable : Pageable, @RequestParam name: String?):
            Page<CustomerResponse> =
        customerService.findAll(pageable, name).map {it.toResponse()}

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): CustomerResponse =
        customerService.findById(id).toResponse()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreateCustomerRequest) {
        customerService.create(request.toModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody request: UpdateCustomerRequest) {
        val customer = customerService.findById(id)
        customerService.update(request.toModel(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }
}
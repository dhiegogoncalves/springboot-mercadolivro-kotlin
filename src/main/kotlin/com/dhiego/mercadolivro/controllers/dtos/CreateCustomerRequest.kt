package com.dhiego.mercadolivro.controllers.dtos

import com.dhiego.mercadolivro.models.Customer

data class CreateCustomerRequest (
    var name: String,
    var email: String,
) {
    fun toCustomer(): Customer {
        return Customer(name = this.name, email = this.email)
    }
}
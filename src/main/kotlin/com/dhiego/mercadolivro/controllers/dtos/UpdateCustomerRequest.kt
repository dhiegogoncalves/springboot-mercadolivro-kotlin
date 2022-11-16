package com.dhiego.mercadolivro.controllers.dtos

import com.dhiego.mercadolivro.models.Customer

data class UpdateCustomerRequest (
    var name: String,
    var email: String,
) {
    fun toCustomer(id: Int): Customer {
        return Customer(id = id, name = this.name, email = this.email)
    }
}
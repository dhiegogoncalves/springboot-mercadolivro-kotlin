package com.dhiego.mercadolivro.controllers.request

import com.dhiego.mercadolivro.models.Customer

data class UpdateCustomerRequest (
    var name: String,
    var email: String,
) {
    fun toModel(previousValue: Customer): Customer {
        return Customer(
            id = previousValue.id,
            name = this.name,
            email = this.email,
            status = previousValue.status
        )
    }
}
package com.dhiego.mercadolivro.controllers.request

import com.dhiego.mercadolivro.enums.CustomerStatus
import com.dhiego.mercadolivro.models.Customer

data class CreateCustomerRequest (
    var name: String,
    var email: String,
) {
    fun toModel(): Customer {
        return Customer(
            name = this.name,
            email = this.email,
            status = CustomerStatus.ATIVO
        )
    }
}
package com.dhiego.mercadolivro.extesions

import com.dhiego.mercadolivro.controllers.response.BookResponse
import com.dhiego.mercadolivro.controllers.response.CustomerResponse
import com.dhiego.mercadolivro.models.Book
import com.dhiego.mercadolivro.models.Customer

fun Customer.toResponse() : CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}

fun Book.toResponse() : BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status
    )
}

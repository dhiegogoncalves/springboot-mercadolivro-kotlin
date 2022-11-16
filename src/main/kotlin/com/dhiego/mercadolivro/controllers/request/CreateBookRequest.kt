package com.dhiego.mercadolivro.controllers.request

import com.dhiego.mercadolivro.enums.BookStatus
import com.dhiego.mercadolivro.models.Book
import com.dhiego.mercadolivro.models.Customer
import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class CreateBookRequest (
    var name: String,
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int
) {
    fun toModel(customer: Customer): Book {
        return Book(
            name = this.name,
            price = this.price,
            status = BookStatus.ATIVO,
            customer = customer
        )
    }
}
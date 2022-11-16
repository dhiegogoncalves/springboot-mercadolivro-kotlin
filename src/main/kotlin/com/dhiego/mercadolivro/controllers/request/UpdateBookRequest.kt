package com.dhiego.mercadolivro.controllers.request

import com.dhiego.mercadolivro.models.Book
import java.math.BigDecimal

data class UpdateBookRequest (
    var name: String?,
    var price: BigDecimal?,
) {
    fun toModel(previousValue: Book): Book {
        return Book(
            id = previousValue.id,
            name = this.name ?: previousValue.name,
            price = this.price ?: previousValue.price,
            status = previousValue.status,
            customer = previousValue.customer
        )
    }
}
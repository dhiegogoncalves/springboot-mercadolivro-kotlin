package com.dhiego.mercadolivro.controllers.response

import com.dhiego.mercadolivro.enums.BookStatus
import com.dhiego.mercadolivro.models.Customer
import java.math.BigDecimal

data class BookResponse (
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var customer: Customer? = null,
    var status: BookStatus? = null
)
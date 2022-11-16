package com.dhiego.mercadolivro.controllers.response

import com.dhiego.mercadolivro.enums.CustomerStatus

data class CustomerResponse (
    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus? = null,
)
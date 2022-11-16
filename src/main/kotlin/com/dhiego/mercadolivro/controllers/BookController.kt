package com.dhiego.mercadolivro.controllers

import com.dhiego.mercadolivro.controllers.request.CreateBookRequest
import com.dhiego.mercadolivro.controllers.request.UpdateBookRequest
import com.dhiego.mercadolivro.controllers.response.BookResponse
import com.dhiego.mercadolivro.extesions.toResponse
import com.dhiego.mercadolivro.services.BookService
import com.dhiego.mercadolivro.services.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {
    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable : Pageable, @RequestParam name: String?):
            Page<BookResponse> =
        bookService.findAll(pageable, name).map {it.toResponse()}

    @GetMapping("/actives")
    fun findAllActives(@PageableDefault(page = 0, size = 10) pageable : Pageable): Page<BookResponse> =
        bookService.findAllActives(pageable).map {it.toResponse()}

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookResponse =
        bookService.findById(id).toResponse()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreateBookRequest) {
        val customer = customerService.findById(request.customerId)
        bookService.create(request.toModel(customer))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody request: UpdateBookRequest) {
        val book = bookService.findById(id)
        bookService.update(request.toModel(book))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)
    }
}
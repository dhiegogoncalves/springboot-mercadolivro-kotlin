package com.dhiego.mercadolivro.services

import com.dhiego.mercadolivro.enums.BookStatus
import com.dhiego.mercadolivro.models.Book
import com.dhiego.mercadolivro.models.Customer
import com.dhiego.mercadolivro.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun findAll(pageable: Pageable, name: String?): Page<Book> {
        name?.let {
            return bookRepository.findAllByNameContainingIgnoreCase(it, pageable)
        }
        return bookRepository.findAll(pageable)
    }

    fun findAllActives(pageable: Pageable): Page<Book> {
        return bookRepository.findAllByStatus(BookStatus.ATIVO, pageable)
    }

    fun findById(id: Int): Book {
        return bookRepository.findById(id).orElseThrow()
    }

    fun create(book: Book) {
        save(book)
    }

    private fun save(book: Book) {
        bookRepository.save(book)
    }

    fun update(book: Book) {
        save(book)
    }

    fun delete(id: Int) {
        if (!bookRepository.existsById(id)) {
            throw Exception()
        }

        val book = findById(id)
        book.status = BookStatus.CANCELADO

        update(book)
    }

    fun deleteByCustomer(customer: Customer) {
        val books = bookRepository.findAllByCustomer(customer)

        for(book in books) {
            book.status = BookStatus.DELETADO
        }

        bookRepository.saveAll(books)
    }
}
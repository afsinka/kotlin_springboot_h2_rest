package com.service

import com.exception.NotFoundException
import com.model.Book
import com.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class BookService @Autowired constructor(
    val bookRepository: BookRepository
) {

    fun getAll(): List<Book> {
        return bookRepository.findAll().map { it };
    }

    fun get(id: Long): Book {
        val book: Optional<Book> = bookRepository.findById(id).map { it }
        return if (book.isPresent) {
            book.get()
        } else {
            throw NotFoundException()
        }
    }

    fun add(book: Book): Book {
        return bookRepository.save(book)
    }
}
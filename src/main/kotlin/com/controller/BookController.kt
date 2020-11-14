package com.controller

import com.model.Book
import com.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class BookController @Autowired constructor(
    val bookService: BookService
) {

    @GetMapping("/")
    fun get(): List<Book> {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    fun get(@PathVariable(value = "id") id: Long): Book {
        return bookService.get(id)
    }

    @PostMapping("/")
    fun get(@RequestBody book: Book): Book {
        return bookService.add(book)
    }
}
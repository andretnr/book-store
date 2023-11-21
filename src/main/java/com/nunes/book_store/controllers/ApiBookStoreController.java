package com.nunes.book_store.controllers;

import com.nunes.book_store.models.BookDTO;
import com.nunes.book_store.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ApiBookStoreController {

    private final BookService bookService;

    //make a constructor for the BookService
    public ApiBookStoreController(BookService bookService) {
        this.bookService = bookService;
    }


    //make a post request to create a Book
    @PostMapping("/Book")
    public ResponseEntity<BookDTO> createBookDTO(@RequestBody BookDTO book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    //make a put request to update a Book
    @PutMapping("/Book/{id}")
    public ResponseEntity<BookDTO> updateBookDTO(@PathVariable Long id, @RequestBody BookDTO book){
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    //make a delete request to delete a Book
    @DeleteMapping("/Book/{id}")
    public ResponseEntity<String> deleteBookDTO(@PathVariable Long id){
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

    //make a get request to get all Books
    @GetMapping("/Books")
    public ResponseEntity<List<BookDTO>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

    //make a get request to get a single Book
    @GetMapping("/Book/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBook(id));
    }

}

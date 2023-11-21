package com.nunes.book_store.services;

import com.nunes.book_store.models.BookDTO;

import java.util.List;

public interface BookService {

    //make all methods used in ApiBookStoreController
    //make a method to create a Book
    BookDTO createBook(BookDTO book);

    //make a method to update a Book
    BookDTO updateBook(Long id, BookDTO book);

    //make a method to delete a Book
    String deleteBook(Long id);

    //make a method to get all Books
    List<BookDTO> getBooks();

    //make a method to get a single Book
    BookDTO getBook(Long id);

}

package com.nunes.book_store.services.impl;

import com.nunes.book_store.mapper.BookMapper;
import com.nunes.book_store.models.BookDTO;
import com.nunes.book_store.persistence.BookEntity;
import com.nunes.book_store.persistence.repository.BookRepository;
import com.nunes.book_store.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;


    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDTO createBook(BookDTO book) {
        BookEntity bookSaved = bookRepository.save(bookMapper.bookDTOToBookEntity(book));
        return bookMapper.bookEntityToBookDTO(bookSaved);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO book) {
        BookEntity referenceById = bookRepository.getReferenceById(id);
        BookEntity bookEntity = bookMapper.updateBookEntityFromBookDTO(book, referenceById);
        BookEntity bookUpdated = bookRepository.save(bookEntity);
        return bookMapper.bookEntityToBookDTO(bookUpdated);
    }

    @Override
    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }

    @Override
    public List<BookDTO> getBooks() {
        return bookMapper.bookEntityListToBookDTOList(bookRepository.findAll());
    }

    @Override
    public BookDTO getBook(Long id) {
        return bookMapper.bookEntityToBookDTO(bookRepository.getReferenceById(id));
    }
}

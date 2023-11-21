package com.nunes.book_store.services;

import com.nunes.book_store.mapper.BookMapper;
import com.nunes.book_store.models.BookDTO;
import com.nunes.book_store.persistence.BookEntity;
import com.nunes.book_store.persistence.repository.BookRepository;
import com.nunes.book_store.services.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateBookWhenValidBookGiven() {
        BookDTO bookDTO = new BookDTO();
        BookEntity bookEntity = new BookEntity();
        when(bookMapper.bookDTOToBookEntity(bookDTO)).thenReturn(bookEntity);
        when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
        when(bookMapper.bookEntityToBookDTO(bookEntity)).thenReturn(bookDTO);

        BookDTO result = bookService.createBook(bookDTO);

        verify(bookRepository, times(1)).save(bookEntity);
        assertEquals(bookDTO, result);
    }

    @Test
    void shouldUpdateBookWhenValidIdAndBookGiven() {
        BookDTO bookDTO = new BookDTO();
        BookEntity bookEntity = new BookEntity();
        when(bookRepository.getReferenceById(anyLong())).thenReturn(bookEntity);
        when(bookMapper.updateBookEntityFromBookDTO(bookDTO, bookEntity)).thenReturn(bookEntity);
        when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
        when(bookMapper.bookEntityToBookDTO(bookEntity)).thenReturn(bookDTO);

        BookDTO result = bookService.updateBook(1L, bookDTO);

        verify(bookRepository, times(1)).getReferenceById(anyLong());
        verify(bookRepository, times(1)).save(bookEntity);
        assertEquals(bookDTO, result);
    }

    @Test
    void shouldDeleteBookWhenValidIdGiven() {
        String result = bookService.deleteBook(1L);

        verify(bookRepository, times(1)).deleteById(anyLong());
        assertEquals("Book deleted", result);
    }

    @Test
    void shouldReturnAllBooksWhenGetBooksCalled() {
        List<BookEntity> bookEntities = Collections.singletonList(new BookEntity());
        List<BookDTO> bookDTOs = Collections.singletonList(new BookDTO());
        when(bookRepository.findAll()).thenReturn(bookEntities);
        when(bookMapper.bookEntityListToBookDTOList(bookEntities)).thenReturn(bookDTOs);

        List<BookDTO> result = bookService.getBooks();

        verify(bookRepository, times(1)).findAll();
        assertEquals(bookDTOs.size(), result.size());
    }

    @Test
    void shouldReturnBookWhenValidIdGiven() {
        BookEntity bookEntity = new BookEntity();
        BookDTO bookDTO = new BookDTO();
        when(bookRepository.getReferenceById(anyLong())).thenReturn(bookEntity);
        when(bookMapper.bookEntityToBookDTO(bookEntity)).thenReturn(bookDTO);

        BookDTO result = bookService.getBook(1L);

        verify(bookRepository, times(1)).getReferenceById(anyLong());
        assertEquals(bookDTO, result);
    }
}
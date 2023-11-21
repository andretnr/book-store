package com.nunes.book_store.mapper;

import com.nunes.book_store.models.BookDTO;
import com.nunes.book_store.persistence.BookEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMapper {

    public BookEntity bookDTOToBookEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            throw new IllegalArgumentException("BookDTO cannot be null");
        }
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDTO.getId());
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setAuthor(bookDTO.getAuthor());
        bookEntity.setDescription(bookDTO.getDescription());
        return bookEntity;
    }

    public BookDTO bookEntityToBookDTO(BookEntity bookEntity) {
        if (bookEntity == null) {
            throw new IllegalArgumentException("BookEntity cannot be null");
        }
        return new BookDTO(
                bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getAuthor(),
                bookEntity.getDescription());

    }


    public List<BookDTO> bookEntityListToBookDTOList(List<BookEntity> books) {
        if (books == null) {
            throw new IllegalArgumentException("BookEntity list cannot be null");
        }
        return books.stream().map(this::bookEntityToBookDTO).collect(Collectors.toList());

    }

    public BookEntity updateBookEntityFromBookDTO(BookDTO book, BookEntity referenceById) {
        if (book == null) {
            throw new IllegalArgumentException("BookDTO cannot be null");
        }
        if (referenceById == null) {
            throw new IllegalArgumentException("BookEntity cannot be null");
        }
        referenceById.setTitle(book.getTitle());
        referenceById.setAuthor(book.getAuthor());
        referenceById.setDescription(book.getDescription());
        return referenceById;
    }
}

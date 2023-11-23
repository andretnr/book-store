package com.nunes.book_store.mappers;

import com.nunes.book_store.mapper.BookMapper;
import com.nunes.book_store.models.BookDTO;
import com.nunes.book_store.persistence.BookEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class BookMapperTest {

    @InjectMocks
    private BookMapper bookMapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    // make a bookDTOToBookEntity junit test using mockito

    @Test
    void bookDTOToBookEntityTest() {
        // create a bookDTO
        BookDTO bookDTO = new BookDTO(1L, "title", "author", "description");
        // create a bookEntity
        BookEntity bookEntity = new BookEntity();
        // call bookDTOToBookEntity with bookDTO
        bookEntity = bookMapper.bookDTOToBookEntity(bookDTO);
        // assert that bookEntity is not null
        Assertions.assertThat(bookEntity).isNotNull();
        // assert that the bookEntity fields are equal to the bookDTO fields
    }

    // make a bookEntityToBookDTO junit test using mockito
    @Test
    public void bookEntityToBookDTOTest() {
        // create a bookEntity
        // create a bookDTO
        // call bookEntityToBookDTO with bookEntity
        // assert that bookDTO is not null
        // assert that the bookDTO fields are equal to the bookEntity fields
    }

    // make a bookEntityListToBookDTOList junit test using mockito
    @Test
    public void bookEntityListToBookDTOListTest() {
        // create a bookEntity list
        // create a bookDTO list
        // call bookEntityListToBookDTOList with bookEntity list
        // assert that bookDTO list is not null
        // assert that the bookDTO list length is equal to the bookEntity list length
        // assert that each bookDTO list element is equal to the respective bookEntity list element
    }

    // make a updateBookEntityFromBookDTO junit test using mockito
    @Test
    public void updateBookEntityFromBookDTOTest() {
        // create a bookDTO
        // create a bookEntity
        // call updateBookEntityFromBookDTO with bookDTO and bookEntity
        // assert that bookEntity is not null
        // assert that the bookEntity fields are equal to the bookDTO fields
    }



}

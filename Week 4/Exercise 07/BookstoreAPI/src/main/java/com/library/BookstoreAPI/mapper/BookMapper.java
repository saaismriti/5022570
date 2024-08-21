package com.library.BookstoreAPI.mapper;

import com.library.BookstoreAPI.dto.BookDTO;
import com.library.BookstoreAPI.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDTO);
}

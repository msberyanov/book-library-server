package msberyanov.mapper;

import msberyanov.dto.BookDto;
import msberyanov.model.Book;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
  BookDto toDto(Book entity);
  Book toEntity(BookDto dto);

  List<BookDto> toDtos(List<Book> entities);
  List<Book> toEntities(List<BookDto> dtos);
}

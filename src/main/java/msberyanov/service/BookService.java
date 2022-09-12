package msberyanov.service;

import msberyanov.dto.BookDto;
import msberyanov.dto.enumeration.Status;

import java.util.List;
import java.util.Optional;

public interface BookService {
  List<BookDto> get(Optional<Status> status);
  List<BookDto> save(List<BookDto> bookDtos);
  BookDto change(BookDto bookDto);
}

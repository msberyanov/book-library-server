package msberyanov.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import msberyanov.dto.BookDto;
import msberyanov.dto.enumeration.Status;
import msberyanov.mapper.BookMapper;
import msberyanov.model.Book;
import msberyanov.repository.BookRepository;
import msberyanov.service.BookService;
import msberyanov.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
  private final BookRepository bookRepository;
  private final BookMapper bookMapper;

  @Override
  public List<BookDto> get(Optional<Status> status) {
    if (status.isEmpty()) {
      return bookMapper.toDtos(bookRepository.findAll());
    }

    return bookMapper.toDtos(bookRepository.findAllByStatus(status.get()));
  }

  @Override
  public List<BookDto> save(List<BookDto> bookDtos) {
    List<Book> books = bookMapper.toEntities(bookDtos);
    List<Book> savedBooks = new ArrayList<>();

    books.forEach(book -> {
      if (bookRepository.findBookByTitleAndAuthor(book.getTitle(), book.getAuthor()) == null) {
        savedBooks.add(bookRepository.save(book));
      } else {
        log.info("The book titled '{}' written by '{}' already exists in the database", book.getTitle(), book.getAuthor());
      }
    });

    return bookMapper.toDtos(savedBooks);
  }

  @Override
  public BookDto change(BookDto bookDto) {
    Book existingBook = bookRepository.findById(bookDto.getId()).orElseThrow(()
      -> new RuntimeException(Utils.getNoBookMessage(bookDto.getId())
    ));

    Book changeBook = bookMapper.toEntity(bookDto);

    if (changeBook.getCover() == null) {
      changeBook.setCover(existingBook.getCover());
    }

    Book changedBook = bookRepository.save(changeBook);

    return bookMapper.toDto(changedBook);
  }
}

package msberyanov.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import msberyanov.dto.BookDto;
import msberyanov.dto.enumeration.Status;
import msberyanov.service.BookService;
import msberyanov.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;

  @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
  public List<BookDto> save(@RequestBody List<BookDto> bookDtos) {
    log.info(Utils.getLogMessage("/save"));

    return bookService.save(bookDtos);
  }

  @GetMapping("/get")
  public List<BookDto> get(@RequestParam Optional<Status> status) {
    log.info(Utils.getLogMessage("/get"));

    return bookService.get(status);
  }

  @PutMapping("/change")
  public BookDto change(@RequestBody BookDto bookDto) {
    log.info(Utils.getLogMessage("/change"));

    return bookService.change(bookDto);
  }
}

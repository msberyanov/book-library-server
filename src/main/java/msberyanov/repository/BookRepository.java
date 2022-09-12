package msberyanov.repository;

import msberyanov.dto.enumeration.Status;
import msberyanov.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
  Book findBookByTitleAndAuthor(String title, String author);

  List<Book> findAllByStatus(Status status);
}

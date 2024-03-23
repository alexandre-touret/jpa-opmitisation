package info.touret.query.optimizationjpa;

import info.touret.query.optimizationjpa.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooksWithAuthors() {
        return bookRepository.findAll().stream().toList();
    }
}

package info.touret.query.optimizationjpa;

import info.touret.query.optimizationjpa.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}

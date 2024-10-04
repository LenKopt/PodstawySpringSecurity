package pl.akademiaspecjalistowit.podstawyspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiaspecjalistowit.podstawyspringsecurity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}

package pl.akademiaspecjalistowit.podstawyspringsecurity.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.BookDto;
import pl.akademiaspecjalistowit.podstawyspringsecurity.repository.BookRepository;

@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<BookDto> getAllBooks(){
        return bookRepository.findAll()
            .stream()
            .map(e->new BookDto(e.getName()))
            .toList();
    }
}

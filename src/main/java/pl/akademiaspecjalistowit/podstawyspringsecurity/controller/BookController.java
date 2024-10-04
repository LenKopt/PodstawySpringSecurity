package pl.akademiaspecjalistowit.podstawyspringsecurity.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.BookDto;
import pl.akademiaspecjalistowit.podstawyspringsecurity.service.BookService;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping
    public List<BookDto> getBooks(){
        return bookService.getAllBooks();
    }
//
//    @PostMapping
//    public void createNewBook(@RequestBody BookDto bookDto){
//        boo
//    }
}

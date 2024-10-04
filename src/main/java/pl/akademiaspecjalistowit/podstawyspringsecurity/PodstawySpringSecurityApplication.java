package pl.akademiaspecjalistowit.podstawyspringsecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.akademiaspecjalistowit.podstawyspringsecurity.repository.BookRepository;

@SpringBootApplication
public class PodstawySpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(PodstawySpringSecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(BookRepository repo) {
        return args -> {
            repo.save(new BookEntity("Nad Niemnem"));
            repo.save(new BookEntity("Poradnik operatora koparki"));
        };
    }

}

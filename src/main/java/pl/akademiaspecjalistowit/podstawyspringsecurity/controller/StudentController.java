package pl.akademiaspecjalistowit.podstawyspringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @GetMapping
    public String getStudent() {
        return "I'm student";
    }
}

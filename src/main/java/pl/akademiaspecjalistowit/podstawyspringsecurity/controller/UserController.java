package pl.akademiaspecjalistowit.podstawyspringsecurity.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.UserDto;
import pl.akademiaspecjalistowit.podstawyspringsecurity.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @PostMapping
    public String addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto.getUserName(), userDto.getPassword());
        return "succesfull";
    }
}

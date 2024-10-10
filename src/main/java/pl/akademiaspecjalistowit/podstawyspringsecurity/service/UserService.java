package pl.akademiaspecjalistowit.podstawyspringsecurity.service;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserService {
    private JdbcTemplate jdbcTemplate;
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void addUser(String username, String password) {

        String encodedPassword = passwordEncoder.encode(password);

        String insertUserSql = "INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertUserSql, username, encodedPassword, true);

        String defaultRole = "ROLE_USER";

        String insertAuthoritySql = "INSERT INTO authorities (username, authority) VALUES (?, ?)";
        jdbcTemplate.update(insertAuthoritySql, username, defaultRole);
    }
}

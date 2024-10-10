package pl.akademiaspecjalistowit.podstawyspringsecurity.configuration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.akademiaspecjalistowit.podstawyspringsecurity.CustomUser;

import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetailsService implements UserDetailsService {
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String userQuery = "SELECT username, password, enabled FROM users WHERE username = ?";
        CustomUser user = jdbcTemplate.queryForObject(userQuery, new Object[]{username}, (rs, rowNum) ->
                new CustomUser(rs.getString("username"), rs.getString("password"), rs.getBoolean("enabled")));

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String authoritiesQuery = "SELECT authority FROM authorities WHERE username = ?";
        List<String> authorities = jdbcTemplate.queryForList(authoritiesQuery, new Object[]{username}, String.class);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
        );
    }
}

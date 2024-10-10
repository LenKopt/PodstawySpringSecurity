package pl.akademiaspecjalistowit.podstawyspringsecurity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomUser {
    private String username;
    private String password;
    private boolean enabled;
    public boolean isEnabled() {
        return enabled;
    }
}

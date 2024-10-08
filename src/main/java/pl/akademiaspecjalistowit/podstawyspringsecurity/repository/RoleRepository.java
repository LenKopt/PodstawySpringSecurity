package pl.akademiaspecjalistowit.podstawyspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akademiaspecjalistowit.podstawyspringsecurity.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

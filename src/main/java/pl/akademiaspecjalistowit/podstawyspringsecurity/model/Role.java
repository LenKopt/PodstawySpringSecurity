package pl.akademiaspecjalistowit.podstawyspringsecurity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="role_name")
    private String name;
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users;

}

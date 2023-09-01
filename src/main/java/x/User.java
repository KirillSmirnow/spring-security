package x;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user_")
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @ElementCollection
    private Set<Role> roles;

    public User(String name, Set<Role> roles) {
        this.name = name;
        this.roles = roles;
    }

    public enum Role {
        ZINA,
        GALYA,
    }
}

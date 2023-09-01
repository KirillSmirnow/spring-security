package x;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public User(String name) {
        this.name = name;
    }
}

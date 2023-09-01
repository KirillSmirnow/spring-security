package x;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class Session {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    private User user;

    @Column(unique = true)
    private String token;

    public Session(User user, String token) {
        this.user = user;
        this.token = token;
    }
}

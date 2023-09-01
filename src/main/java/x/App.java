package x;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class App {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        var николя = userRepository.save(new User("Николя", Set.of(User.Role.GALYA)));
        sessionRepository.save(new Session(николя, "123"));
    }
}

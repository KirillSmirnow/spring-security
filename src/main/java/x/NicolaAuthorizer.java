package x;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NicolaAuthorizer {

    private final CurrentUser currentUser;
    private final UserRepository userRepository;

    public boolean isNicola() {
        var user = userRepository.findById(currentUser.getId()).orElseThrow();
        return user.getName().equals("Николя");
    }
}

package x;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MyController {

    private final CurrentUser currentUser;
    private final UserRepository userRepository;

    @GetMapping("/app")
    public void foo() {
        if (currentUser.isAuthenticated()) {
            log.info("Current user: {}", currentUser.getId());
        } else {
            log.info("User not authenticated");
        }
    }

    @GetMapping("/protected")
    @PreAuthorize("isAuthenticated()")
    public String requiresAuthentication() {
        return userRepository.findById(currentUser.getId()).orElseThrow().getName();
    }

    @GetMapping("/nicola")
    @RequiresNicola
    public String requiredNicola() {
        return "Hi!";
    }
}

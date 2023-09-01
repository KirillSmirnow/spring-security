package x;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MyController {

    private final CurrentUser currentUser;

    @GetMapping("/app")
    public void foo() {
        if (currentUser.isAuthenticated()) {
            log.info("Current user: {}", currentUser.getId());
        } else {
            log.info("User not authenticated");
        }
    }
}

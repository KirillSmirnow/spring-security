package x;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CurrentUserImpl implements CurrentUser {

    @Override
    public UUID getId() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UserAuthentication userAuthentication) {
            return userAuthentication.getUserId();
        }
        throw new IllegalStateException("Unauthenticated");
    }

    @Override
    public boolean isAuthenticated() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication instanceof UserAuthentication;
    }
}

package x;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserAuthenticationManager implements AuthenticationManager {

    private final SessionRepository sessionRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!(authentication instanceof BearerTokenAuthenticationToken bearerToken)) {
            throw new InvalidBearerTokenException("WTF!");
        }
        var token = bearerToken.getToken();
        var user = sessionRepository.findByToken(token)
                .map(Session::getUser)
                .orElseThrow(() -> new InvalidBearerTokenException("No session"));
        return new UserAuthentication(user.getId(), new HashSet<>(user.getRoles()));
    }
}

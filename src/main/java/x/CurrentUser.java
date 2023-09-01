package x;

import java.util.UUID;

public interface CurrentUser {

    UUID getId();

    boolean isAuthenticated();
}

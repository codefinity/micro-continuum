package com.codefinity.microcontinuum.identityaccess.domain.model.identity;

import java.util.Collection;

public interface UserRepository {

    public void add(User aUser);

    public Collection<User> allSimilarlyNamedUsers(
            TenantId aTenantId,
            String aFirstNamePrefix,
            String aLastNamePrefix);

    public void remove(User aUser);

    public User userFromAuthenticCredentials(
            TenantId aTenantId,
            String aUsername,
            String anEncryptedPassword);

    public User userWithUsername(
            TenantId aTenantId,
            String aUsername);
}

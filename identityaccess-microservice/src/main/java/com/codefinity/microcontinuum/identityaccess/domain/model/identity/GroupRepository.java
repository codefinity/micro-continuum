package com.codefinity.microcontinuum.identityaccess.domain.model.identity;

import java.util.Collection;

public interface GroupRepository {

    public void add(Group aGroup);

    public Collection<Group> allGroups(TenantId aTenantId);

    public Group groupNamed(TenantId aTenantId, String aName);

    public void remove(Group aGroup);
}

package com.codefinity.microcontinuum.identityaccess.infrastructure.persistance;

import com.codefinity.microcontinuum.common.port.adapter.persistance.hibernate.EnumUserType;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.GroupMemberType;

public class GroupMemberTypeUserType extends EnumUserType<GroupMemberType> {
    public GroupMemberTypeUserType() {
        super(GroupMemberType.class);
    }
}

package com.codefinity.microcontinuum.identityaccess.domain.model.identity;

import java.util.Date;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;

public class GroupGroupAdded implements DomainEvent {

    private int eventVersion;
    private String groupName;
    private String nestedGroupName;
    private Date occurredOn;
    private TenantId tenantId;

    public GroupGroupAdded(TenantId aTenantId, String aGroupName, String aNestedGroupName) {
        super();

        this.eventVersion = 1;
        this.groupName = aGroupName;
        this.nestedGroupName = aNestedGroupName;
        this.occurredOn = new Date();
        this.tenantId = aTenantId;
    }

    @Override
    public int eventVersion() {
        return this.eventVersion;
    }

    public String groupName() {
        return this.groupName;
    }

    public String nestedGroupName() {
        return this.nestedGroupName;
    }

    @Override
    public Date occurredOn() {
        return this.occurredOn;
    }

    public TenantId tenantId() {
        return this.tenantId;
    }
}

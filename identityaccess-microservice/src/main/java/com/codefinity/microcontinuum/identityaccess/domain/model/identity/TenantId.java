package com.codefinity.microcontinuum.identityaccess.domain.model.identity;

import java.util.UUID;

import com.codefinity.microcontinuum.common.domain.model.AbstractId;

public final class TenantId extends AbstractId {

    private static final long serialVersionUID = 1L;

    public TenantId(String anId) {
        super(anId);
    }

    protected TenantId() {
        super();
    }

    @Override
    protected int hashOddValue() {
        return 83811;
    }

    @Override
    protected int hashPrimeValue() {
        return 263;
    }

    @Override
    protected void validateId(String anId) {
        try {
            UUID.fromString(anId);
        } catch (Exception e) {
            throw new IllegalArgumentException("The id has an invalid format.");
        }
    }
}

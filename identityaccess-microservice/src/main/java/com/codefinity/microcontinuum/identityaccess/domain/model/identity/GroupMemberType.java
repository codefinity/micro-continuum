package com.codefinity.microcontinuum.identityaccess.domain.model.identity;

public enum GroupMemberType {

    Group {
        public boolean isGroup() {
            return true;
        }
    },

    User {
        public boolean isUser() {
            return true;
        }
    };

    public boolean isGroup() {
        return false;
    }

    public boolean isUser() {
        return false;
    }
}

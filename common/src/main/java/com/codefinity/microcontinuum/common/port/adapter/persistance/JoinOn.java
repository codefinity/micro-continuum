package com.codefinity.microcontinuum.common.port.adapter.persistance;

import java.sql.ResultSet;

public class JoinOn {

    private Object currentLeftQualifier;
    private String leftKey;
    private String rightKey;

    public JoinOn(String aLeftKey, String aRightKey) {
        super();

        this.leftKey = aLeftKey;
        this.rightKey = aRightKey;
    }

    public JoinOn() {
        super();
    }

    public boolean hasCurrentLeftQualifier(ResultSet aResultSet) {
        try {
            Object columnValue = aResultSet.getObject(this.leftKey());

            if (columnValue == null) {
                return false;
            }

            return columnValue.equals(this.currentLeftQualifier);

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isJoinedOn(ResultSet aResultSet) {

        Object leftColumn = null;
        Object rightColumn = null;

        try {
            if (this.isSpecified()) {
                leftColumn = aResultSet.getObject(this.leftKey());
                rightColumn = aResultSet.getObject(this.rightKey());
            }

        } catch (Exception e) {
            // ignore
        }

        return leftColumn != null && rightColumn != null;
    }

    public boolean isSpecified() {
        return this.leftKey() != null && this.rightKey() != null;
    }

    public String leftKey() {
        return this.leftKey;
    }

    public String rightKey() {
        return this.rightKey;
    }

    public void saveCurrentLeftQualifier(String aColumnName, Object aColumnValue) {
        if (aColumnName.equals(this.leftKey())) {
            this.currentLeftQualifier = aColumnValue;
        }
    }
}

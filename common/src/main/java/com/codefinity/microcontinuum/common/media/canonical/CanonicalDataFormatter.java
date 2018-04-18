package com.codefinity.microcontinuum.common.media.canonical;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

// TODO: this is incomplete

public class CanonicalDataFormatter {

    public CanonicalDataFormatter() {
        super();
    }

    public byte[] format(Object anObject) {
        for (Field field : anObject.getClass().getFields()) {
            field.setAccessible(true);
            byte[] formattedField = this.formatField(field, anObject);
            if (formattedField.length > 0)
                ; // TODO
        }

        return null;
    }

    private byte[] formatField(Field aField, Object anObject) {
        byte[] formatted = null;

        if ((aField.getModifiers() & Modifier.STATIC) == 0) {
            if (aField.getType().isPrimitive()) {
                formatted = this.formatPrimitive(aField, anObject);
            } else {
                formatted = this.formatObject(aField, anObject);
            }
        }

        return formatted;
    }

    private byte[] formatObject(Field aField, Object anObject) {
//        String name = aField.getName();
//        Object value;
//
//        try {
//            value = aField.get(anObject);
//        } catch (Throwable t) {
//            throw new IllegalArgumentException("The object cannot be formatted.", t);
//        }

        return null;
    }

    private byte[] formatPrimitive(Field aField, Object anObject) {
//        String name = aField.getName();
//        Object value;
//
//        try {
//            value = aField.get(anObject);
//        } catch (Throwable t) {
//            throw new IllegalArgumentException("An object primitive cannot be formatted.", t);
//        }

        return null;
    }
}

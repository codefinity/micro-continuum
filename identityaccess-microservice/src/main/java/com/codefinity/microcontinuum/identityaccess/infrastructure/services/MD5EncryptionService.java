package com.codefinity.microcontinuum.identityaccess.infrastructure.services;

import java.math.BigInteger;
import java.security.MessageDigest;

import com.codefinity.microcontinuum.common.AssertionConcern;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.EncryptionService;

public class MD5EncryptionService extends AssertionConcern implements EncryptionService {

    public MD5EncryptionService() {
        super();
    }

    @Override
    public String encryptedValue(String aPlainTextValue) {
        this.assertArgumentNotEmpty(
                aPlainTextValue,
                "Plain text value to encrypt must be provided.");

        String encryptedValue = null;

        try {

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(aPlainTextValue.getBytes("UTF-8"));

            BigInteger bigInt = new BigInteger(1, messageDigest.digest());

            encryptedValue = bigInt.toString(16);

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        return encryptedValue;
    }
}

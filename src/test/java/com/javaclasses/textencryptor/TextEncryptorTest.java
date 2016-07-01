package com.javaclasses.textencryptor;

import com.javaclasses.textencryptor.impl.TextEncryptorImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextEncryptorTest {

    private final TextEncryptor encryptor = new TextEncryptorImpl();

    private final String textToBeEncrypted = "if man was meant to stay " +
            "on the ground god would have given us roots";

    private final String encodedMessage = "imtgdvs fearwer mayoogo anouuio" +
            " ntnnlvt wttddes aohghn sseoau";

    @Test
    public void testTextEncryption() {
        assertEquals("Encrypted message does not equal expected text.",
                encodedMessage, encryptor.encrypt(textToBeEncrypted));
    }
}

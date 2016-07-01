package com.javaclasses.textencryptor;

import com.javaclasses.textencryptor.impl.TextEncryptorImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextEncryptorTest {

    private final TextEncryptor encryptor = new TextEncryptorImpl();

    @Test
    public void testLargeTextEncryption() {

        final String textToBeEncrypted = "if man was meant to stay " +
                "on the ground god would have given us roots";

        final String encodedMessage = "imtgdvs fearwer mayoogo anouuio" +
                " ntnnlvt wttddes aohghn sseoau";

        assertEquals("Encrypted message does not equal expected text.",
                encodedMessage, encryptor.encrypt(textToBeEncrypted));
    }

    @Test
    public void testFirstExampleTextEncryption() {

        final String encodedMessage = "imtgdvs fearwer mayoogo anouuio" +
                " ntnnlvt wttddes aohghn sseoau";

        final String textToBeEncrypted = "if man was meant to stay " +
                "on the ground god would have given us roots";

        assertEquals("Encrypted message does not equal expected text.",
                encodedMessage, encryptor.encrypt(textToBeEncrypted));
    }

    @Test
    public void testSecondExampleTextEncryption() {

        final String encodedMessage = "imtgdvs fearwer mayoogo anouuio" +
                " ntnnlvt wttddes aohghn sseoau";

        final String textToBeEncrypted = "if man was meant to stay " +
                "on the ground god would have given us roots";

        assertEquals("Encrypted message does not equal expected text.",
                encodedMessage, encryptor.encrypt(textToBeEncrypted));
    }

    @Test
    public void testThirdExampleTextEncryption() {

        final String encodedMessage = "imtgdvs fearwer mayoogo anouuio" +
                " ntnnlvt wttddes aohghn sseoau";

        final String textToBeEncrypted = "if man was meant to stay " +
                "on the ground god would have given us roots";

        assertEquals("Encrypted message does not equal expected text.",
                encodedMessage, encryptor.encrypt(textToBeEncrypted));
    }
}

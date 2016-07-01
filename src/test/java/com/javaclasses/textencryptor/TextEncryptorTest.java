package com.javaclasses.textencryptor;

import com.javaclasses.textencryptor.impl.TextEncryptorImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

    @Test
    public void testNullArgumentEncryption() {

        try {
            encryptor.encrypt(null);
            fail("NullPointerException was not thrown");
        } catch (NullPointerException e) {
            assertEquals("Wrong message for null argument encryption.",
                    "Encrypted argument must not equal null.",  e.getMessage());
        }
    }

    @Test
    public void testEmptyArgumentEncryption() {

        try {
            encryptor.encrypt("");
            fail("IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong message for empty text encryption.",
                    "Encrypted text must not be empty.",  e.getMessage());
        }
    }
}

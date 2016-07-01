package com.javaclasses.textencryptor;

import com.javaclasses.textencryptor.impl.TextEncryptorImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

        final String textToBeEncrypted = "have a nice day";

        final String encodedMessage = "hae and via ecy";

        assertEquals("Encrypted message does not equal expected text.",
                encodedMessage, encryptor.encrypt(textToBeEncrypted));
    }

    @Test
    public void testSecondExampleTextEncryption() {

        final String textToBeEncrypted = "feed the dog";

        final String encodedMessage = "fto ehg ee dd";

        assertEquals("Encrypted message does not equal expected text.",
                encodedMessage, encryptor.encrypt(textToBeEncrypted));
    }

    @Test
    public void testThirdExampleTextEncryption() {

        final String textToBeEncrypted = "chillout";

        final String encodedMessage = "clu hlt io";

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

    @Test
    public void testTextEncryptorStatelessness() throws Exception {

        final String textToBeEncrypted = "if man was meant to stay " +
                "on the ground god would have given us roots";

        final String encodedMessage = "imtgdvs fearwer mayoogo anouuio" +
                " ntnnlvt wttddes aohghn sseoau";

        final int threadPoolSize = 20;

        final CountDownLatch encryptionStartLatch = new CountDownLatch(threadPoolSize);

        final ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        final List<Future<String>> futureList = new ArrayList<>();

        for (int i = 0; i < threadPoolSize; i++) {

            final Future<String> future = executorService.submit(() -> {

                encryptionStartLatch.countDown();
                encryptionStartLatch.await();

                return encryptor.encrypt(textToBeEncrypted);
            });

            futureList.add(future);

        }

        for (Future<String> future : futureList) {

            assertEquals("Encrypted message does not equal expected text.",
                    encodedMessage, future.get());
        }

    }
}

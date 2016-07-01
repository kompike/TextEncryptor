package com.javaclasses.textencryptor;

/**
 * Basic interface for text encryption
 */
public interface TextEncryptor {

    /**
     * Encrypt given text using chosen encryption scheme
     * @param text English text to be encoded
     * @return Encoded message
     */
    String encrypt(String text);
}

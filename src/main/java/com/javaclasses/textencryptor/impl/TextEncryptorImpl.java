package com.javaclasses.textencryptor.impl;

import com.javaclasses.textencryptor.TextEncryptor;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

/**
 * Implementation of {@link TextEncryptor} interface
 */
public class TextEncryptorImpl implements TextEncryptor {

    @Override
    public String encrypt(String text) {

        final String textWithoutSpaces = removeSpaces(text);

        final char[][] charactersGrid = createGrid(textWithoutSpaces);

        return createEncodedMessage(charactersGrid);
    }

    private String createEncodedMessage(char[][] charactersGrid) {

        return null;
    }

    private char[][] createGrid(String textWithoutSpaces) {

        return null;
    }

    private String removeSpaces(String textWithSpaces) {

        return textWithSpaces.replaceAll("\\s+", "");
    }

}

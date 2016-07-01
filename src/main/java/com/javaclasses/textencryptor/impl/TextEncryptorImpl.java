package com.javaclasses.textencryptor.impl;

import com.javaclasses.textencryptor.TextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.Math.*;

/**
 * Implementation of {@link TextEncryptor} interface
 */
public class TextEncryptorImpl implements TextEncryptor {

    private final Logger log = LoggerFactory.getLogger(TextEncryptorImpl.class);

    @Override
    public String encrypt(String text) {

        checkNotNull(text, "Encrypted argument must not equal null.");

        checkArgument(!text.equals(""), "Encrypted text must not be empty.");

        final String textWithoutWhitespaces = removeWhitespaces(text);

        if (log.isInfoEnabled()) {

            log.info("Text without whitespaces: " + textWithoutWhitespaces);
        }

        final char[][] charactersGrid = createGrid(textWithoutWhitespaces);

        return createEncodedMessage(charactersGrid);
    }

    /**
     * Removes whitespaces from given text
     *
     * @param textWithWhitespaces Text with whitespaces
     * @return Text without whitespaces
     */
    private String removeWhitespaces(String textWithWhitespaces) {

        if (log.isInfoEnabled()) {

            log.info("Removing spaces...");
        }

        return textWithWhitespaces.replaceAll("\\s+", "");
    }/**
     * Converts given text to the grid of characters
     *
     * @param text Text to be converted
     * @return Grid of characters
     */
    private char[][] createGrid(String text) {

        if (log.isInfoEnabled()) {

            log.info("Creating characters grid...");
        }

        final int textSize = text.length();

        int gridRowsNumber = (int) floor(sqrt(textSize));

        if (log.isInfoEnabled()) {

            log.info("Grid rows number: " + gridRowsNumber);
        }
        final int gridColumnsNumber = (int) ceil(sqrt(textSize));

        if (log.isInfoEnabled()) {

            log.info("Grid columns number: " + gridColumnsNumber);
        }

        while (gridColumnsNumber * gridRowsNumber < textSize) {
            gridRowsNumber = gridColumnsNumber;
        }

        final char[][] charactersGrid =
                new char[gridRowsNumber][gridColumnsNumber];

        for (int i = 0; i < gridRowsNumber; i++) {

            if (log.isDebugEnabled()) {

                log.debug("Current i value: " + i);
            }

            for (int j = 0; j < gridColumnsNumber; j++) {

                if (log.isDebugEnabled()) {

                    log.debug("Current j value: " + j);
                }

                if ((i * gridColumnsNumber + j) < textSize) {

                    if (log.isDebugEnabled()) {

                        log.debug("Current char position:" + i * gridColumnsNumber + j);
                    }

                    charactersGrid[i][j] =
                            text.charAt(i * gridColumnsNumber + j);

                    if (log.isDebugEnabled()) {

                        log.debug("Added element: " + charactersGrid[i][j]);
                    }
                }

            }
        }

        return charactersGrid;
    }

    private String createEncodedMessage(char[][] charactersGrid) {

        return null;
    }
}

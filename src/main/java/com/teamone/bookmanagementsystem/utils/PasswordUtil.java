package com.teamone.bookmanagementsystem.utils;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Logger;

public class PasswordUtil {

    /**
     * Encryption password with input password as parameter, use PBKDF2 to
     * encryption.
     *
     * @param password password that user input from login, sign-up form. It is
     *                 a <code>java.lang.String</code> object
     * @return
     */
    public static String generatePasswordHash(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        int iterations = 1000; //iterations for encrypt password
        char[] chars = password.toCharArray(); //convert string to char array
        byte[] salt = getSalt(); //initalize salt

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash); //convert to string hash to store to database
    }

    /**
     * Initialize salt for hashing password to get stronger password.
     */
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    /**
     * Convert salt to Hex to display and insert password to database
     *
     * @param array a sequence of bytes that get from ecryption password. It is
     *              a <code>java.lang.byte</code> object
     */
    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array); //convert bytes to BigInteger
        String hex = bi.toString(16);

        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0%dd", 0, paddingLength) + hex;
        } else {
            return hex;
        }
    }

    /**
     * Decrypt password to check validate password that user input with password
     * from database.
     *
     * @param originalPassword password that user input from login, sign-up
     *                         form. It is a <code>java.lang.String</code> object
     * @param storedPassword   password that stored in database It is a
     *                         <code>java.lang.String</code> object
     * @return
     */
    public static boolean validatePassword(String originalPassword, String storedPassword) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);

        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(),
                salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for (int i = 0; i < hash.length && i < testHash.length; i++) {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }

    /**
     * Convert Hex to salt to compare with original password
     *
     * @param hex a string that display hex is encryption password. It is a
     *            <code>java.lang.String</code> object
     */
    private static byte[] fromHex(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}

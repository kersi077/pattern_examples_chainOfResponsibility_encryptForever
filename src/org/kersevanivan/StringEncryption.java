package org.kersevanivan;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * <p>Title: StringEncryption.</p>
 * <p>Description: Encrypts a string with a random key. Forgets the key afterwards.</p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 15.09.20 17:09
 */
public class StringEncryption {
    /**
     *
     * @param message - the message to encrypt.
     * @return a bytearray of the encrypted message.
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     */
    public byte[] encrypt(String message) throws NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException {
        byte[] key = hash(randString());
        Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k = new SecretKeySpec(key, "AES");
        c.init(Cipher.ENCRYPT_MODE, k);
        return c.doFinal(message.getBytes());
    }

    /**
     *
     * @param key - the key to encrypt the message with.
     * @return the hashed 256 bits long key.
     * @throws NoSuchAlgorithmException
     */
    public byte[] hash(String key) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(key.getBytes(StandardCharsets.UTF_8));
    }

    /**
     *
     * @return a random string to act as key.
     */
    private String randString() {
        byte[] array = new byte[32];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}

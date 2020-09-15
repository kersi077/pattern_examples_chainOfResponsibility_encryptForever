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
import java.util.Objects;
import java.util.Random;

/**
 * <p>Title: MessageEncryptor</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020 ec-logic GmbH, Fuerth, germany</p>
 * <p>Company: ec-logic GmbH</p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 15.09.20 16:55
 */
public class MessageEncryptor implements MessageHandler {

    private MessageHandler nextHandler;

    @Override
    public void handleMessage(String message, Type type) {
        try {
            if (type.equals(Type.SECRET)) {
                StringEncryption encryption = new StringEncryption();
                message = new String(encryption.encrypt(message));
            }
        } catch (Exception e) {
            System.out.println("The message is secret but couldn't be encrypted. The message is discarded.");
            message = "";
        }
        // Call the next in chain.
        if( nextHandler != null )
            nextHandler.handleMessage(message, type);
    }
    @Override
    public void appendNext(MessageHandler nextHandler) {
        Objects.requireNonNull(nextHandler);
        this.nextHandler = nextHandler;
    }


}

package org.kersevanivan;

/**
 * <p>Title: MessageHandler</p>
 * <p>Description: </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 15.09.20 16:49
 */
public interface MessageHandler {
    /**
     * Handles the message somehow.
     */
    public void handleMessage(String message, Type type); // This is the "handleRequest" method in our Handout.

    /**
     *
     * @param nextHandler - the next MessageHandler to be called.
     */
    public void appendNext(MessageHandler nextHandler);
}

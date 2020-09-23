package org.kersevanivan;

import java.util.Objects;

/**
 * <p>Title: ConsoleMessageHandler</p>
 * <p>Description: </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 15.09.20 16:53
 */
public class ConsoleMessageHandler implements MessageHandler {

    private MessageHandler nextHandler;

    @Override
    public void handleMessage(String message, Type type) {
        System.out.println(message);
        if( nextHandler != null )
            nextHandler.handleMessage(message, type);
    }

    @Override
    public void appendNext(MessageHandler nextHandler) {
        Objects.requireNonNull(nextHandler);
        this.nextHandler = nextHandler;
    }
}

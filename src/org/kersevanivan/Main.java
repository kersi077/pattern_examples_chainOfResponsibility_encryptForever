package org.kersevanivan;

public class Main {

    public static void main(String[] args) {
        MessageEncryptor encryptor = new MessageEncryptor();
        encryptor.appendNext(new ConsoleMessageHandler());

        encryptor.handleMessage("My public message", Type.PUBLIC);
        encryptor.handleMessage("My secret message", Type.SECRET);
        encryptor.handleMessage("My second public message", Type.PUBLIC);
    }
}

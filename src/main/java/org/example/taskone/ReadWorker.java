package org.example.taskone;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class ReadWorker implements Runnable {
    private Socket serverSocket;
    private BufferedReader in;

    public ReadWorker(Socket serverSocket, BufferedReader in) {
        this.serverSocket = serverSocket;
        this.in = in;
    }
    @Override
    public void run(){
        System.out.println("читаю");
        try {
            System.out.println(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

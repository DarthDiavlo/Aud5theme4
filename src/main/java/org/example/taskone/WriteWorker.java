package org.example.taskone;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class WriteWorker implements Runnable{
    private Socket serverSocket;
    private BufferedWriter out;

    public WriteWorker(Socket serverSocket, BufferedWriter out) {
        this.serverSocket = serverSocket;
        this.out = out;
    }

    @Override
    public void run(){
        Scanner scanner=new Scanner(System.in);
        try {
            out.write(scanner.next());
            out.newLine();
            out.flush();
            System.out.println("вроде послал");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

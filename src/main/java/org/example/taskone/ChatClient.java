package org.example.taskone;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    Socket serversocket;

    public static void main(String[] args) throws IOException {
        Socket server = new Socket("services.tms-studio.ru", 27015);

        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));

        Scanner scanner= new Scanner(System.in);
        String nickName = scanner.next();

        out.write(nickName);
        out.newLine();
        out.flush();
        if(server.isConnected()){
             /* здесь необходимо реализовать создание и запуск потоков
            ReadWorker и WriteWorker */
            ReadWorker readWorker= new ReadWorker(server,in);
            WriteWorker writeWorker= new WriteWorker(server,out);
            Thread threadIn=new Thread(readWorker);
            Thread threadOut=new Thread(writeWorker);
            threadOut.start();
            threadIn.start();
            // цикл, который работает пока подключение к серверу активно
            while(server.isConnected()){
                Thread.onSpinWait();
            }
        }
    }
}

package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    if (str.contains("Hello")) {
                        out.write("Hello, dear friend.\n".getBytes());
                    } else if (str.contains("Exit")) {
                        out.write("Bye\n".getBytes());
                        server.close();
                    } else if (str.contains("msg=")) {
                        String[] tmp = str.split("[ |=]");
                        out.write((tmp[2] + "\n").getBytes());
                    }
                    System.out.println(str);
                }
            }
        }
    }
}

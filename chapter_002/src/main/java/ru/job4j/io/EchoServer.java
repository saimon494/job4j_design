package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String answer = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("Hello")) {
                            answer = "Hello, dear friend!";
                        } else if (str.contains("Exit")) {
                            answer = "Bye!";
                            server.close();
                        } else if (str.contains("msg=")) {
                            String[] tmp = str.split("[ |=]");
                            answer = tmp[2];
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    if (!answer.isEmpty()) {
                        out.write((answer + "\r\n").getBytes());
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("IOException", e);
        }
    }
}

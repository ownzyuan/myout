package com.zy.leet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Psvm {
    public static void main(String[] args) {
        try {
            new Socket("localhost", 9000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new ServerSocket(9000, 80);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = "";
        System.out.println(s);
    }
}

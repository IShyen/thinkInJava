package com.sigar.other.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    private static int PORT = 8379;
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("服务器端启动了....");
            //进行阻塞
            Socket socket = null;
            //启动一个线程来处理客户端请求
            HandlerExecutorPool pool = new HandlerExecutorPool(50, 1000);
            while (true) {
                socket = serverSocket.accept();
                pool.execute(new ServerHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            serverSocket = null;
        }
    }
}

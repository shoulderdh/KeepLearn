package com.study.dh.keeplearn.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by dh on 2017/3/23.
 */

public class ChatClient {
    private Socket socket = null;

    public ChatClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    /**
     * 向服务器端发送消息
     *
     * @param msg
     * @throws IOException
     */
    public void sendMsg(String msg) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(msg.replace("\n", "") + "\n");
        writer.flush();
    }

}

package newTest.NettyTest;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @program: mybatisPlusdemo
 * @description:
 * @author: hzl
 * @create: 2022-05-19 11:24
 **/

public class BIO {
    @Test
    public void mySocketServer(){
        try{
            ServerSocket serverSocket = new ServerSocket(9000);
            while(true){
                System.out.println("等待连接....");
                Socket clientSocket = serverSocket.accept();
                //开始接收数据
                byte[] bytes = new byte[1024];
                System.out.println("准备read....");
                int readLen = clientSocket.getInputStream().read(bytes);
                if (readLen != -1){
                    System.out.println("接收客户端传来的数据:" + new String(bytes, 0, readLen));
                }
                System.out.println("开始向客户端发送数据");
                clientSocket.getOutputStream().write("HelloClient".getBytes(StandardCharsets.UTF_8));
                clientSocket.getOutputStream().flush();
                System.out.println("结束向客户端发送数据");
//                new Runnable(){
//                    @Override
//                    public void run() {
//                        try{
//                            System.out.println("等待连接....");
//                            Socket clientSocket = serverSocket.accept();
//                            //开始接收数据
//                            byte[] bytes = new byte[1024];
//                            System.out.println("准备read....");
//                            int readLen = clientSocket.getInputStream().read(bytes);
//                            if (readLen != -1){
//                                System.out.println("接收客户端传来的数据:" + new String(bytes, 0, readLen));
//                            }
//                            System.out.println("开始向客户端发送数据");
//                            clientSocket.getOutputStream().write("HelloClient".getBytes(StandardCharsets.UTF_8));
//                            clientSocket.getOutputStream().flush();
//                            System.out.println("结束向客户端发送数据");
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//                    }
//                };
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void mySocketClient(){
        try{
            Socket socket = new Socket("localhost",9000);
            System.out.println("开始向服务端发送数据");
            socket.getOutputStream().write("HelloServer".getBytes());
            socket.getOutputStream().flush();

            System.out.println("向服务端发送数据结束");

            byte[] bytes = new byte[1024];

            int read = socket.getInputStream().read(bytes);
            System.out.println("接收到来自服务器的数据:" + new String(bytes,0,read));
            socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

package newTest.NettyTest;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @program: mybatisPlusdemo
 * @description:
 * @author: hzl
 * @create: 2022-05-19 12:06
 **/

public class NIO {
    //保持客户端连接
    static List<SocketChannel> channels = new ArrayList<>();

    @Test
    public void mySocketServer() throws IOException {
        //创建 NIO ServerSocketChannel, 与 BIO的 serverSocket 类似
        ServerSocketChannel serverSocket  = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        //设置ServerSocketChannel非阻塞
        serverSocket.configureBlocking(false);
        System.out.println("服务启动成功");
        while(true){
            //非阻塞模式 accept 方法不会阻塞，否则会阻塞
            //NIO 的非阻塞是由操作系统内部实现的，底层调用了 linux 内核的 accept 函数
            SocketChannel socketChannel = serverSocket.accept();
            if(socketChannel != null){
                System.out.println("连接成功");
                channels.add(socketChannel);
            }

            Iterator<SocketChannel> iterator = channels.iterator();
            while(iterator.hasNext()){
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);

                //非阻塞模式 read 方法不会阻塞，否则会阻塞
                int len = sc.read(byteBuffer);
                if(len > 0 ){
                    System.out.println("接收到的消息：" + new String(byteBuffer.array()));
                }else if(len == -1){
                    //不活跃的连接就删除
                    iterator.remove();
                    System.out.println("客户端连接断开");
                }
            }
        }

    }

    @Test
    public void mySocketSelectorServer() throws IOException{
        //创建 NIO ServerSocketChannel, 与 BIO的 serverSocket 类似
        ServerSocketChannel serverSocket  = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        //设置ServerSocketChannel非阻塞
        serverSocket.configureBlocking(false);

        //打开 Selector 处理 Channel，即创建 epoll
        Selector selector = Selector.open();
        //把 ServerSocketChannel 注册到 selector 上，并且selector 对客户端 accept 连接操作感兴趣
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务启动成功");
        while(true){
            //阻塞需要等待的事件发生
            selector.select();

            //获取selector中注册的全部事件的SelectionKey实例
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey>iterator =  selectionKeys.iterator();

            //遍历SelectionKey对事件进行处理
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                //如果是OP ACCEPT事件，则进行连接获取和事件注册
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);

                    //这里只注册了读事件，如果需要给客户端发送数据可以注册写事件
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("客户端连接成功");
                } else if (key.isReadable()) {//如果是OP_READ事件，则进行读取和打印
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int len = socketChannel.read(byteBuffer);

                    //如果有数据，把数据打印出来
                    if(len>0){
                            System.out.println("接收到消息："+new String(byteBuffer.array()));
                    }else if( len ==-1){

                        //如果客户端断开连接，关闭Socket
                        System.out.println("客户端断开连接");
                        socketChannel.close();
                    }
                    //从事件集合里删除本次处理的key,防止下次select重复处理
                    iterator.remove();
                }
            }
        }
    }

    @Test
    public void mySocketClient() throws IOException {
        Socket socket = new Socket("localhost",9000);
        System.out.println("开始向服务端发送数据");
        socket.getOutputStream().write("HelloServer".getBytes());
        socket.getOutputStream().flush();

        System.out.println("向服务端发送数据结束");
//        socket.close();
    }

}

package edu.keith.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class NIOServer {

	private Selector selector;
	
	public void initServer(int port) throws IOException{
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);
		serverChannel.socket().bind(new InetSocketAddress(port));
		selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
	}
	
	public void listen() throws IOException{
		System.out.println("nio server started!");
		while(true){
			selector.select();
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while(it.hasNext()){
				SelectionKey sk = it.next();
				it.remove();
				if(sk.isAcceptable()){
					System.out.println("witting");
					ServerSocketChannel server = (ServerSocketChannel) sk.channel();
					SocketChannel channel = server.accept();
					channel.configureBlocking(false);
					channel.write(ByteBuffer.wrap("something...".getBytes()));
					channel.register(selector, SelectionKey.OP_READ);
				}else if(sk.isReadable())
					read(sk);
			}
		}
	}
	
	public void read(SelectionKey key) throws IOException{
		System.out.println("reading");
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(100);
		channel.read(buffer);
		String msg = new String(buffer.array());
		System.out.println("server received from client at["+Calendar.getInstance().getTimeInMillis()+"]:"+msg);
	}
	
	public static void main(String[] args) throws IOException{
		NIOServer server = new NIOServer();
		server.initServer(8000);
		server.listen();
	}
}

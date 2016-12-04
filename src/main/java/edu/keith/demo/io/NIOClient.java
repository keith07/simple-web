package edu.keith.demo.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Calendar;
import java.util.Iterator;

public class NIOClient {

	private Selector selector;
	public void initClient(String ip,int port) throws IOException{
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		selector = Selector.open();
		channel.connect(new InetSocketAddress(ip,port));
		channel.register(selector, SelectionKey.OP_CONNECT);
	}
	
	public void listen() throws IOException{
		System.out.println("nio client started");
		while(true){
			selector.select();
			System.out.println(selector.keys());
			Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
			while(keys.hasNext()){
				SelectionKey key = keys.next();
				keys.remove();
				if(key.isConnectable()){
					System.out.println("writting...");
					SocketChannel channel = (SocketChannel) key.channel();
					if(channel.isConnectionPending())
						channel.finishConnect();
					channel.configureBlocking(false);
					channel.write(ByteBuffer.wrap("send something".getBytes()));
					channel.register(selector, SelectionKey.OP_READ);
				}else if(key.isReadable()){
					read(key);
				}
			}
		}
	}
	
	public void read(SelectionKey key) throws IOException{
		System.out.println("reading...");
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(100);
		channel.read(buffer);
		String msg = new String(buffer.array());
		System.out.println("cleint received from server at["+Calendar.getInstance().getTimeInMillis()+"]:"+msg);
	}
	
	public static void main(String[] args) throws IOException{
		NIOClient client = new NIOClient();
		client.initClient("localhost",8000);
		client.listen();
	}
}

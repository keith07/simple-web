package edu.keith.demo.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by keith on 2016/6/27 0027.
 */
public class AsyncTimeServerHandler implements Runnable {
	private int port;
	CountDownLatch latch;
	AsynchronousServerSocketChannel serverSocketChannel;

	public AsyncTimeServerHandler(int port) {
		this.port = port;
		try {
			serverSocketChannel = AsynchronousServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(port));
			System.out.println("The time server is start in port :" + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		latch = new CountDownLatch(1);
		doAccept();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void doAccept() {
		serverSocketChannel.accept(this, new AcceptCompletionHandler());
	}
}

package edu.keith.demo.io.nio;

/**
 * Created by keith on 2016/6/26 0026.
 */
public class TimClient {
	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			port = Integer.valueOf(args[1]);
		}
		new Thread(new TimeClientHandler("127.0.0.1",port),"TimeClient-001").start();
	}
}

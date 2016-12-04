package edu.keith.demo.io.aio;

/**
 * Created by keith on 2016/6/27 0027.
 */
public class TimeServer {
	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			port = Integer.valueOf(args[0]);
		}
		AsyncTimeServerHandler timeServerHandler = new AsyncTimeServerHandler(port);
		new Thread(timeServerHandler, "AIO-AsyncTimeServerHandler-001").start();
	}
}

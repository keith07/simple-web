package edu.keith.demo.io.aio;

/**
 * Created by keith on 2016/6/28 0028.
 */
public class TimeClient {
	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			port = Integer.valueOf(args[0]);
		}
		new Thread(new AsyncTimeClientHandler("127.0.0.1",port)).start();
	}
}

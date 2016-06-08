package edu.keith.demo.avro.rpc;

import org.apache.avro.Protocol;
import org.apache.avro.ipc.HttpServer;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.generic.GenericResponder;

import java.net.InetSocketAddress;

/**
 * Created by QiGuanYi on 2016/4/28.
 */
public class Server extends GenericResponder {
	private Protocol protocol = null;
	private int port;

	public Server(Protocol protocol, int port) {
		super(protocol);
		this.protocol = protocol;
		this.port = port;
	}

	public Object respond(Protocol.Message message, Object request) throws Exception {
		GenericRecord req = (GenericRecord) request;
		GenericRecord msg = (GenericRecord)(req.get("message"));
		// process the request
		System.out.println("req:"+req);
		//TODO
		return msg;
	}

	public void run() {
		try {
			HttpServer server = new HttpServer(this, port);
//			NettyServer nettyServer = new NettyServer(this, new InetSocketAddress("localhost", port));
//			nettyServer.start();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int port = 8080;
//		if (args.length != 1) {
//			System.out.println("Usage: Server port");
//			System.exit(0);
//		}
//		int port = Integer.parseInt(args[0]);
		new Server(Utils.getProtocol(), port).run();
	}
}
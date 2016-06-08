package edu.keith.demo.avro.rpc;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import avro.Message;
import avro.MessageProtocol;
import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.Callback;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.util.Utf8;
import org.apache.avro.Protocol;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.ipc.HttpTransceiver;
import org.apache.avro.ipc.Transceiver;
import org.apache.avro.ipc.generic.GenericRequestor;


/**
 * Created by QiGuanYi on 2016/4/28.
 */
public class Client {
	private Protocol protocol = null;
	private String host = null;
	private int port = 0;
	private int size = 0;
	private ExecutorService service;
	private int count = 0;
	private AtomicLong timeCost = new AtomicLong(0);
	private AtomicInteger liveThreads;

	public Client(Protocol protocol, String host, int port, int size, int count) {
		this.protocol = protocol;
		this.host = host;
		this.port = port;
		this.size = size;
		service = Executors.newFixedThreadPool(size+1);
		liveThreads = new AtomicInteger(size);
		this.count = count;
	}

	public long sendMessage() {
//		Message requestData = new Message();
//		requestData.setName("name");
//		requestData.setPrice((double) 2);
//		requestData.setType(1);
//		requestData.setValid(true);
		GenericRecord requestData = new GenericData.Record(
				protocol.getType("Message"));
		requestData.put("name","myname");
		requestData.put("type",1);
//		requestData.put("price",(double)2);
		requestData.put("price2",(double)2);
		requestData.put("valid",true);

		GenericRecord request = new GenericData.Record(protocol.getMessages()
				.get("sendMessage").getRequest());
		request.put("message", requestData);


		Transceiver t = null;
		long start = System.currentTimeMillis();
		try {
			t = new HttpTransceiver(new URL("http://" + host + ":"	+ port));
//			t = new NettyTransceiver(new InetSocketAddress(host, port));
			GenericRequestor requestor = new GenericRequestor(protocol, t);

			for (int i = 0; i < size; i++) {
				requestor.request("sendMessage", request);
			}
			t.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			t = null;
			System.out.print(liveThreads.decrementAndGet());
			long end = System.currentTimeMillis();
			System.out.println("time cost:"+(end - start)+"ms");
			return end - start;

		}
	}

	public void run() throws Exception {
		long start = System.currentTimeMillis();
		for(int i = 0; i<size;i++) {
			service.submit(new Runnable() {
				@Override
				public void run() {
					long thisCost = sendMessage();
					timeCost.addAndGet(thisCost);
//					System.out.println("time cost:"+thisCost+"ms total cost："+timeCost+"ms");
				}
			});
		}
		while (liveThreads.get() > 0) {
		}
		long actualCost = System.currentTimeMillis() - start;
		System.out.println("actual cost:" + actualCost + "ms total cost:" + timeCost + "ms");
		System.out.println(Thread.currentThread().getName());
		System.exit(0);
	}

	public void specialSend() {
	}

	public static void main(String[] args) throws Exception {
//		if (args.length != 4) {
//			System.out.println("Usage: Client host port dataSize count");
//			System.exit(0);
//		}
//
//		String host = args[0];
//		int port = Integer.parseInt(args[1]);
//		int size = Integer.parseInt(args[2]);
//		int count = Integer.parseInt(args[3]);
		new Client(Utils.getProtocol2(), "localhost", 8080, 20, 200).run();
	}
}

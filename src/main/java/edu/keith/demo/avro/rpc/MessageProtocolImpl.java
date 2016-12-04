package edu.keith.demo.avro.rpc;

import avro.Message;
import avro.MessageProtocol;
import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.HttpTransceiver;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.Transceiver;
import org.apache.avro.ipc.generic.GenericRequestor;
import org.apache.avro.ipc.specific.SpecificRequestor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;

/**
 * Created by QiGuanYi on 2016/5/6.
 */
public class MessageProtocolImpl implements MessageProtocol {
	private int port;
	private String host;
	@Override
	public Message sendMessage(Message message) throws AvroRemoteException {
		return null;
	}

	private void send() {

		Transceiver t = null;
		long start = System.currentTimeMillis();
		try {
			t = new NettyTransceiver(new InetSocketAddress(host, port));
			SpecificRequestor specificRequestor = new SpecificRequestor(Message.class, t);
			specificRequestor.getSpecificData();
			t.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	class MessageProtocolCallBackImpl implements MessageProtocol.Callback {
		@Override
		public void sendMessage(Message message, org.apache.avro.ipc.Callback<Message> callback) throws IOException {

		}

		@Override
		public Message sendMessage(Message message) throws AvroRemoteException {
			return null;
		}
	}

}
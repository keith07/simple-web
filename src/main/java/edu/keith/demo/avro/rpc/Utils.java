package edu.keith.demo.avro.rpc;

import org.apache.avro.Protocol;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by QiGuanYi on 2016/4/28.
 */
public class Utils {
	public static Protocol getProtocol() {
		Protocol protocol = null;
		try {
//			URL url = Utils.class.getClassLoader().getResource("src/main/avro/message.avpr");
			protocol = Protocol.parse(new File("src/main/avro/message.avpr"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return protocol;
	}
	public static Protocol getProtocol2() {
		Protocol protocol = null;
		try {
//			URL url = Utils.class.getClassLoader().getResource("src/main/avro/message.avpr");
			protocol = Protocol.parse(new File("src/main/avro/message2.avpr"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return protocol;
	}
}
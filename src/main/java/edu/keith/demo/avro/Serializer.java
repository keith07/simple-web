package edu.keith.demo.avro;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

/**
 * Created by QiGuanYi on 2016/4/26.
 */
public class Serializer {

	public static void specificSerializer() {
		User user1 = new User();
		user1.setName("Alyssa");
		user1.setFavoriteNumber(256);
		// Leave favorite color null

		// Alternate constructor
		User user2 = new User("Ben", 7, "red");

		// Construct via builder
		User user3 = User.newBuilder()
				.setName("Charlie")
				.setFavoriteColor("blue")
				.setFavoriteNumber(null)
				.build();
		// Serialize user1, user2 and user3 to disk
		DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
		DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
		try {
			dataFileWriter.create(user1.getSchema(), new File("users.avro"));
			dataFileWriter.append(user1);
			dataFileWriter.append(user2);
			dataFileWriter.append(user3);
			dataFileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			dataFileWriter = null;
		}

	}

	public static void customSerializer() throws IOException {
		Schema schema = new Schema.Parser().parse(new File("src/main/avro/user.avsc"));

		GenericRecord user1 = new GenericData.Record(schema);
		user1.put("name", "Alyssa");
		user1.put("favorite_number", 256);
		// Leave favorite color null

		GenericRecord user2 = new GenericData.Record(schema);
		user2.put("name", "Ben");
		user2.put("favorite_number", 7);
		user2.put("favorite_color", "red");
		// Serialize user1 and user2 to disk
		File file = new File("users2.avro");
		DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
		DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
		dataFileWriter.create(schema, file);
		dataFileWriter.append(user1);
		dataFileWriter.append(user2);
		dataFileWriter.close();
	}

	public void cas() {

	}

	public static void main(String[] args) throws IOException {
//		specificSerializer();
		customSerializer();
	}
}

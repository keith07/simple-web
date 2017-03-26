package edu.keith.demo.io.file;

import sun.nio.cs.UTF_32;
import sun.nio.cs.UTF_32LE;
import sun.nio.cs.ext.GB18030;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;

/**
 * Created by keith on 2017/3/11.
 */
public class FileUtils {

	private static final int DEFAULT_BUFFER_SIZE = 1024;

	private static final int BYTE_MAX_VALUE = (1 << 8) - 1;

	public static void readWithFileReader(File file) throws IOException {
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(inputStream, "gbk");
//		FileReader fileReader = new FileReader(file);
		CharBuffer chars = CharBuffer.allocate(DEFAULT_BUFFER_SIZE);
//		char[] chars = new char[DEFAULT_BUFFER_SIZE];
		int index = fileReader.read(chars);
		String line;
		while (index > -1) {
			line = new String(chars.array(),0,index);
			System.out.print(line);
			chars.clear();
			index = fileReader.read(chars);
		}
		fileReader.close();
		inputStream.close();
	}

	public static void readWithBufferedFileReader(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String s = bufferedReader.readLine();
		while (s != null) {

//			System.out.println(s);
			s = bufferedReader.readLine();
		}
		bufferedReader.close();
		fileReader.close();
	}

	public static void readWithChannel(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		FileChannel fileChannel = fis.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(DEFAULT_BUFFER_SIZE);
		fileChannel.read(byteBuffer);
		while (!byteBuffer.hasRemaining()) {
//			System.out.print(new String(byteBuffer.array()));
			byteBuffer.clear();
			fileChannel.read(byteBuffer);
		}
		byteBuffer.flip();
		byte[] bytes = new byte[byteBuffer.limit()];
		byteBuffer.get(bytes);
//		System.out.print(new String(bytes));
		fileChannel.close();
		fis.close();
	}

	public static void readWithInputStream(File file) throws IOException {
		InputStream inputStream = new FileInputStream(file);
		byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
		int index = inputStream.read(bytes);
		while (index > -1) {
			System.out.print(new String(bytes,0,index,"gbk"));
			index = inputStream.read(bytes);
		}
		inputStream.close();
	}

	public static void readWithBufferedInputStream(File file) throws IOException {
		InputStream inputStream = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
		int index = bis.read(bytes);
		while (index > -1) {
			System.out.print(new String(bytes,0,index));
			index = bis.read(bytes);
		}
		inputStream.close();
	}

	public static void fixBinary(File file) throws IOException {
		InputStream inputStream = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		int index = bis.read();
		while (index > -1) {
			System.out.print(Integer.toBinaryString(index));
			index = bis.read();
		}
		bis.close();
		inputStream.close();
	}

	public static void transfer() throws CharacterCodingException {
		String s = "了";
		ByteBuffer byteBuffer = ByteBuffer.wrap(s.getBytes());
		CharsetDecoder decoder = new UTF_32LE().newDecoder();
		CharBuffer charBuffer = decoder.decode(byteBuffer);
		char c = charBuffer.get();
		while (c != -1) {
			System.out.println(c);
			c = charBuffer.get();
		}
	}

	public static void modify(File file,File dstFile) throws IOException {
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(inputStream, "gbk");
		OutputStream outputStream = new FileOutputStream(dstFile);
		OutputStreamWriter fileWriter = new OutputStreamWriter(outputStream, "gbk");
		CharBuffer chars = CharBuffer.allocate(DEFAULT_BUFFER_SIZE);
		int num = 0;
		int size = fileReader.read(chars);
		String s;
		while (size > -1) {
//			for(int index = 0; index < size; index++) {
//				if ('淫' == chars.get(index)) {
//					chars.put(index, '￥');
//					num++;
//				}
//			}
			s = new String(chars.array());
			fileWriter.write(s);
			fileWriter.flush();
			chars.clear();
			size = fileReader.read(chars);
		}
		fileReader.close();
		inputStream.close();
		fileWriter.close();
		outputStream.close();
		System.out.println("一共"+num);
	}

	public static void modifyV2(File file, File dstFile) throws FileNotFoundException {
//		FileChannel fileChannel1 = new RandomAccessFile(file, "r").getChannel();
//		fileChannel1.re

	}

	public static void main(String[] args) throws IOException {
//		transfer();
//		File file = new File("F:\\360Downloads\\etc\\金瓶梅（崇祯本）(书本网).txt");
		File dstFile = new File("e:\\test2.txt");
		File dstFile2 = new File("e:\\test.txt");
		long startNano = System.nanoTime();
		modify(dstFile2, dstFile);
		long endNano = System.nanoTime();
		System.out.println("cost " + (endNano-startNano)/1000000.0);

//		System.out.println("readWithFileReader");
//		long startNano = System.nanoTime();
//		readWithFileReader(file);
//		long nowNano = System.nanoTime();
//		System.out.println("cost " + (nowNano-startNano)/1000000.0);
//		System.out.print("readWithBufferedFileReader");
//		startNano = System.nanoTime();
//		readWithBufferedFileReader(file);
//		nowNano = System.nanoTime();
//		System.out.println("cost " + (nowNano-startNano)/1000000.0);
//		System.out.print("readWithInputStream");
//		startNano = System.nanoTime();
//		readWithInputStream(file);
//		nowNano = System.nanoTime();
//		System.out.println("cost " + (nowNano-startNano)/1000000.0);
//		System.out.print("readWithBufferedInputStream");
//		startNano = System.nanoTime();
//		readWithBufferedInputStream(file);
//		nowNano = System.nanoTime();
//		System.out.println("cost " + (nowNano-startNano)/1000000.0);
//		System.out.print("readWithChannel");
//		startNano = System.nanoTime();
//		readWithChannel(file);
//		nowNano = System.nanoTime();
//		System.out.println("cost " + (nowNano-startNano)/1000000.0);
//		fixBinary(file);
//		System.out.println("");
//		System.out.println(Integer.valueOf("E4",16));
//		System.out.println(Integer.valueOf("BA",16));
//		System.out.println(Integer.valueOf("86",16));
//		int a1 = -28;
//		int a2 = -70;
//		int a3 = -122;
//		System.out.println(Integer.toBinaryString(a1));
//		System.out.println(Integer.toBinaryString(-7168));
//		System.out.println(Integer.toBinaryString(a2));
//		System.out.println(Integer.toBinaryString(a3));
//		int result = ((((a1 << 8) & a2) << 8) & a3) << 8;
//		int result = binaryUnion(binaryUnion(a1,a2),a3);
//		result &= ((2 << 23) - 1);
//		System.out.println(Integer.toBinaryString(result));
//		a1 &= BYTE_MAX_VALUE;
//		a2 &= BYTE_MAX_VALUE;
//		a3 &= BYTE_MAX_VALUE;
//		result = binaryUnionV2(binaryUnionV2(a1,a2),a3);
//		System.out.println(Integer.toBinaryString(result));
//		System.out.println(Integer.toBinaryString(~-1));
	}

	public static int binaryUnion(int x, int y) {
		int result = ~((~x << 8) | ~y);
		return result;
	}

	public static int binaryUnionV2(int x, int y) {
		int result = x << 8 | y;
		return result;
	}
}

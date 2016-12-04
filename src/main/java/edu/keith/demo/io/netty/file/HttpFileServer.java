package edu.keith.demo.io.netty.file;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created by keith on 2016/7/5 0005.
 */
public class HttpFileServer {
	private static final String DEFAULT_URL = "/src/";

	public void run(final int port, final String url) throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();;
		EventLoopGroup workderGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(bossGroup, workderGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast("http-decoder", new HttpRequestDecoder())
									.addLast("http-aggregator", new HttpObjectAggregator(65536))
									.addLast("http-encoder", new HttpResponseEncoder())
									.addLast("http-chunked", new ChunkedWriteHandler())
									.addLast("fileServerHandler", new HttpFileServerHandler(url));
						}
					});
			ChannelFuture future = bootstrap.bind("localhost", port).sync();
			System.out.println("HTTP 文件目录服务器启动，网址是：http://localhost:" + port + url);
			future.channel().closeFuture().sync();
		} finally {
			//先BOSS后worker
			bossGroup.shutdownGracefully();
			workderGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int port = 8080;
		String url = DEFAULT_URL;
		if (args != null && args.length > 0) {
			port = Integer.valueOf(args[0]);
			if (args.length > 1) {
				url = args[1];
			}
		}
		new HttpFileServer().run(port,url);
	}
}

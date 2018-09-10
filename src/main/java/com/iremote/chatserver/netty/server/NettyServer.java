package com.iremote.chatserver.netty.server;

import com.iremote.chatserver.netty.server.initializer.MessagePushInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.InetSocketAddress;

public class NettyServer {
    private static Log log = LogFactory.getLog(NettyServer.class);

    private int port;
    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    private ChannelInitializer<SocketChannel> channelinitializer;
    protected ChannelFuture channelfuture;

    public NettyServer(int port, ChannelInitializer<SocketChannel> channelinitializer) {
        this.port = port;
        this.channelinitializer = channelinitializer;
    }

    public void start(){
        try {
            ServerBootstrap sbs = new ServerBootstrap().group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(channelinitializer)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            channelfuture = sbs.bind(new InetSocketAddress(4399)).sync();
//            Channel channel = sbs.bind(port).channel();
            channelfuture.channel().closeFuture().sync();
        } catch (Throwable t) {
            log.info(t.getMessage(), t);
            destroy();
        }
    }

    public void destroy(){
        try{
            channelfuture.channel().close().sync();
            workerGroup.shutdownGracefully().sync();
            bossGroup.shutdownGracefully().sync();
        } catch (Throwable t){
            log.error(t.getMessage(), t);
        }
    }

    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer(4399, new MessagePushInitializer());
        nettyServer.start();
    }
}

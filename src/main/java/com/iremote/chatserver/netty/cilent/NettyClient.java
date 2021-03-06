package com.iremote.chatserver.netty.cilent;

import com.iremote.chatserver.netty.cilent.initializer.HeartBeatInitializer;
import com.iremote.chatserver.util.LogUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.InetSocketAddress;

public class NettyClient implements Runnable{
    private static Log log = LogFactory.getLog(NettyClient.class);
    private String ip ;
    private int port ;
    private ChannelInitializer<SocketChannel> channelinitializer;

    private NettyClient(String ip , int port , ChannelInitializer<SocketChannel> channelinitializer) {
        this.ip = ip ;
        this.port = port ;
        this.channelinitializer = channelinitializer;
    }

    public static void startClient(String ip , int port , ChannelInitializer<SocketChannel> channelinitializer) {
        Thread thread = new Thread(new NettyClient(ip , port , channelinitializer));
        thread.start();
    }

    @Override
    public void run()
    {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap b = new Bootstrap();
        b.group(workerGroup);
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.remoteAddress(new InetSocketAddress(ip, port));
        b.handler(channelinitializer);

        for ( ;; ){
            try{
                LogUtils.info("Connect to %s:%d", ip, port);
                ChannelFuture f = b.connect(ip, port).sync();
                f.channel().closeFuture().sync();
                f.channel().writeAndFlush("xixixixhahah");
            } catch(InterruptedException e){
                log.error(e.getMessage() , e);
                break;
            } catch(Throwable t ){
                log.error(t.getMessage());
            }

            try{
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage() , e);
                break;
            }
        }

        workerGroup.shutdownGracefully();
    }

    public static void main(String[] args) {
        NettyClient.startClient("127.0.0.1", 8921, new HeartBeatInitializer());
    }
}

package com.iremote.chatserver.netty.cilent.initializer;

import com.iremote.chatserver.netty.cilent.handler.EscapeCoder;
import com.iremote.chatserver.netty.cilent.handler.HeartBeatHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class HeartBeatInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        pipeline.addLast(new IdleStateHandler(180, 30, 30, TimeUnit.SECONDS));
//        pipeline.addLast("escapecoder", new EscapeCoder());
//        pipeline.addLast("framer", new FixedLengthFrameDecoder(1));
        pipeline.addLast("handler", new HeartBeatHandler());

        socketChannel.pipeline().channel();
    }
}

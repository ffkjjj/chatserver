package com.iremote.chatserver.netty.server.initializer;

import com.iremote.chatserver.netty.server.handler.MessagePushHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;


public class MessagePushInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new IdleStateHandler(180 , 30 , 30, TimeUnit.SECONDS));
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(32768,new ByteBuf[] {Unpooled.wrappedBuffer("\n".getBytes())})) ;
        pipeline.addLast("decoder", new StringDecoder(Charset.forName("UTF-8")));
        pipeline.addLast("encoder", new StringEncoder(Charset.forName("UTF-8")));

        pipeline.addLast("handler", new MessagePushHandler()) ;
    }
}

package com.iremote.chatserver.netty.server;

import com.iremote.chatserver.netty.server.handler.MessagePushHandler;
import io.netty.channel.Channel;

public class NettyServerPushMessage {
    public static void main(String[] args) {
        Channel channel = MessagePushHandler.channelMap.get(123);
        channel.writeAndFlush("nihaoa =================");
    }
}

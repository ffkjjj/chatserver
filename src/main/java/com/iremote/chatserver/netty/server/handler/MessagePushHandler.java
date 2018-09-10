package com.iremote.chatserver.netty.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessagePushHandler extends SimpleChannelInboundHandler<String> {
    private static Log log = LogFactory.getLog(MessagePushHandler.class);

    public static final ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        log.info(" Sever channel Read");
        log.info(s);
        channelHandlerContext.writeAndFlush("xixixixixix");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        log.info("Sever channel active");
        ctx.writeAndFlush("hello client");
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.info(" Server channel userEventTriggered");
        for (Channel channel : group) {
            channel.writeAndFlush("dadada jia hao");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("error");
        cause.printStackTrace();
        ctx.close();
    }
}

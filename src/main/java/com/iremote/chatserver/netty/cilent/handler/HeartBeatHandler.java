package com.iremote.chatserver.netty.cilent.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.AttributeKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

public class HeartBeatHandler extends SimpleChannelInboundHandler<String> {
    private static Log log = LogFactory.getLog(HeartBeatHandler.class);
    public static final AttributeKey<Integer> salt = AttributeKey.valueOf("salt");

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String o) throws Exception {
        log.info(" Client channel Read");
        log.info(o);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception
    {
        super.userEventTriggered(ctx, evt);
        ctx.writeAndFlush("ffafafaf");
        if (evt instanceof IdleStateEvent){
            log.info(" Client channel userEventTriggered");
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        log.info("client active");
        ctx.writeAndFlush("Hello netty");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("c error");
        cause.printStackTrace();
        ctx.close();
    }
}

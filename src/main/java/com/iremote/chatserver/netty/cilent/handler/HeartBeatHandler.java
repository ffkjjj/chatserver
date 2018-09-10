package com.iremote.chatserver.netty.cilent.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HeartBeatHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private static Log log = LogFactory.getLog(HeartBeatHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf o) throws Exception {
        log.info(" Client channel Read");
        log.info(ByteBufUtil.hexDump(o.readBytes(o.readableBytes())));
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception
    {
        super.userEventTriggered(ctx, evt);
        ctx.writeAndFlush("??");
        if (evt instanceof IdleStateEvent){
            log.info(" Client channel userEventTriggered");
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ctx.writeAndFlush("Hello netty");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("c error");
        cause.printStackTrace();
        ctx.close();
    }
}

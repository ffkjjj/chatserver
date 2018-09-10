package com.iremote.chatserver.netty.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessagePushHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private static Log log = LogFactory.getLog(MessagePushHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        log.info(" Sever channel Read");
        log.info(ByteBufUtil.hexDump(byteBuf.readBytes(byteBuf.readableBytes())));
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
        ctx.writeAndFlush("fsadfa");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("error");
        cause.printStackTrace();
        ctx.close();
    }
}

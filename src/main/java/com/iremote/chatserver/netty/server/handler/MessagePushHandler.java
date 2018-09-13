package com.iremote.chatserver.netty.server.handler;

import com.iremote.chatserver.netty.cilent.handler.HeartBeatHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;
import java.util.concurrent.*;

public class MessagePushHandler extends SimpleChannelInboundHandler<String> {
    private static Log log = LogFactory.getLog(MessagePushHandler.class);

    ThreadPoolExecutor executorService = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

    public static final ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static Map<Integer, Channel> channelMap = new ConcurrentHashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        log.info(" Sever channel Read");
        log.info(s);
        Integer count = channelHandlerContext.channel().attr(HeartBeatHandler.salt).get();
        if (count > 5) {
            channelHandlerContext.writeAndFlush("count > 5");
            executorService.submit(() -> {
                try {
                    Thread.sleep(8000);
                    MessagePushHandler.channelMap.get(123).writeAndFlush("wo xing le ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } else {
            channelHandlerContext.channel().attr(HeartBeatHandler.salt).set(++count);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ctx.channel().attr(HeartBeatHandler.salt).set(1);
        log.info("Sever channel active");
        ctx.writeAndFlush("hello client");
        MessagePushHandler.channelMap.put(123, ctx.channel());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.info(" Server channel userEventTriggered");
        for (Channel channel : group) {
            channel.writeAndFlush("dadada jia hao");
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        log.info("disconnection");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("error");
        cause.printStackTrace();
        ctx.close();
    }
}

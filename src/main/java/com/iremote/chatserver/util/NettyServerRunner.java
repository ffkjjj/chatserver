package com.iremote.chatserver.util;

import com.iremote.chatserver.netty.server.NettyServer;
import com.iremote.chatserver.netty.server.initializer.MessagePushInitializer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class NettyServerRunner implements ApplicationRunner, Runnable {
    private static Log log = LogFactory.getLog(NettyServerRunner.class);
    private static Thread thread;

    @Override
    public void run() {
        log.info("Netty start");
        NettyServer nettyServer = new NettyServer(8921, new MessagePushInitializer());
        nettyServer.start();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }
}

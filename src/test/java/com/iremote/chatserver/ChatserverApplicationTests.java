package com.iremote.chatserver;

import com.iremote.chatserver.netty.cilent.NettyClient;
import com.iremote.chatserver.netty.cilent.initializer.HeartBeatInitializer;
import com.iremote.chatserver.netty.server.NettyServer;
import com.iremote.chatserver.netty.server.initializer.MessagePushInitializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatserverApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void server(){
	}
}

package com.iremote.chatserver;

import com.iremote.chatserver.netty.cilent.NettyClient;
import com.iremote.chatserver.netty.cilent.initializer.HeartBeatInitializer;
import com.iremote.chatserver.netty.server.NettyServer;
import com.iremote.chatserver.netty.server.initializer.MessagePushInitializer;
import com.iremote.chatserver.service.spider.BiQuGeSpider;
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

	@Test
	public void testSpider(){
		String url = "https://www.xbiquge6.com";
		String indexPage = "/32_32006/1702597.html";
		Integer endPage = 1702598;
		BiQuGeSpider spider = new BiQuGeSpider(url, indexPage, endPage);

		spider.start();
	}
}

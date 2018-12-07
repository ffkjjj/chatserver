package com.iremote.chatserver;

import com.iremote.chatserver.spider.BiQuGeSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatServerApplicationTests {
	@Autowired
	private BiQuGeSpider spider;

	@Test
	public void contextLoads() {
	}

	@Test
	public void server(){
	}

	@Test
	public void testSpider(){
		/*String url = "https://www.xbiquge6.com";
		String indexPage = "/7_7254/8048699.html";
		Integer endPage = 8245898;
//		Integer endPage = 1702599;

		spider.setUrl(url);
		spider.setIndexPage(indexPage);
		spider.setEndIndex(endPage);

		spider.start();*/
	}
}

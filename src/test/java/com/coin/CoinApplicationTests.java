package com.coin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoinApplicationTests {

	@Autowired
	public JavaMailSender mailSender;
	@Test
	public void sendSimpleMail() throws Exception {
		//444923854@qq.com
		//String sendTo[] = {"343174147@qq.com", "785020707@qq.com" };
		String sendTo="785020707@qq.com";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("1922080078@qq.com");
		message.setTo( sendTo);
		message.setSubject("主题：简单邮件");
		message.setText("简单邮件内容");
		mailSender.send(message);
	}
}

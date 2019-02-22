package com.maimeng.authserver;

import com.maimeng.authserver.global.jwt.JwtUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthserverApplicationTests {
	@Resource
	private JwtUtils jwtUtils;

	@Test
	public void contextLoads() {
		System.out.println(jwtUtils.generateToken(46L));
	}

}

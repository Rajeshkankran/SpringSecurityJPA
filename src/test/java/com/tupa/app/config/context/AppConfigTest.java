package com.tupa.app.config.context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tupa.app.config.context.AppConfig;
import com.tupa.app.config.context.LocalDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class,LocalDataSource.class})
@WebAppConfiguration
public class AppConfigTest {

   @Test
	public void contextload() {
		// TODO Auto-generated method stub

	}
	
}

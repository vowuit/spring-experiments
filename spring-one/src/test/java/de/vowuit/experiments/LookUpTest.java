package de.vowuit.experiments;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class LookUpTest {

	private static Log log = LogFactory.getLog(LookUpTest.class);
	
	@Test
	public void firstTest() {
		log.info("hello world");
	}
	
	@Configuration
	static class Config {
		
	}
}

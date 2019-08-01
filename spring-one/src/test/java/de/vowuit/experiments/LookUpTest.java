package de.vowuit.experiments;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class LookUpTest {

	private static Log log = LogFactory.getLog(LookUpTest.class);
	
	@Autowired
	SampleRecordLOF sampleRecordLOF;
	
	@Test
	public void firstTest() {
		
		log.info("firstTest() ==> ");
		
		LookUpOperator lu1 = sampleRecordLOF.getLookUp("first");
		
		log.info("lu1: ");
		lu1.doLookUp();
		
		LookUpOperator lu2 = sampleRecordLOF.getLookUp("second");
		
		log.info("lu2: ");
		lu2.doLookUp();

		LookUpOperator lu3 = sampleRecordLOF.getLookUp("first");
		
		log.info("lu3: ");
		lu3.doLookUp();

		
	}
	
	@Configuration
	@ComponentScan
	static class Config {
		
	}
	
	@Component
	static class RepoConfig {
		
		private static int counter;
		
		@Bean
		@Scope("prototype")
		public LookUpRepository lookUpRepository(String name) {
			log.info("LookUpRepositoryImpl[]: " + counter++);
			return new LookUpRepository() {};
		}
	}
	
	@Component
	public static class SampleRecordSource implements RecordSource {
		
		public final String FIELD_ONE = "FIELD_ONE";
		
	}
	
	@Component
	public static class SampleRecordLOF extends SampleRecordSource implements LookUpOperatorFactory {
		
	}
	
	@Component
	public static class Processor implements BeanPostProcessor {

		@Override
		public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
			log.info("before: " + beanName);
			return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
		}

		@Override
		public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
			// TODO Auto-generated method stub
			return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
		}
		
	}
}


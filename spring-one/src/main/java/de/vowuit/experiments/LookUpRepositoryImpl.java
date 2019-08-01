package de.vowuit.experiments;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class LookUpRepositoryImpl implements FactoryBean<LookUpRepository> {

	private static Log log = LogFactory.getLog(LookUpRepositoryImpl.class);
	private static int counter;
	
	@Override
	public LookUpRepository getObject() throws Exception {
		log.info("LookUpRepositoryImpl: " + counter++);
		return new LookUpRepository() {};
	}

	@Override
	public Class<?> getObjectType() {
		return LookUpRepository.class;
	}

	
}

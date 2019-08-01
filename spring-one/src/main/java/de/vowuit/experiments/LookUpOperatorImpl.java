package de.vowuit.experiments;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LookUpOperatorImpl implements LookUpOperator {

	private static Log log = LogFactory.getLog(LookUpOperatorImpl.class);
	private static int counter;
	
	private final int id;
	private final String name;
	private final LookUpOperatorFactory factory;
	private final LookUpRepository repository;
	
	public LookUpOperatorImpl(LookUpOperatorFactory factory, String name) {
		this.id = counter++;
		this.name = name;
		this.factory = factory;
		this.repository = factory.getRepository(name);
	}
	
	@Override
	public void doLookUp() {
		log.info("[id=" + id + ",name=" + name + "]");
	}
}

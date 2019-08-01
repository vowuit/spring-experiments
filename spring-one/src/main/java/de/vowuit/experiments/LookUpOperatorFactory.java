package de.vowuit.experiments;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Lookup;

public interface LookUpOperatorFactory {

	static Log log = LogFactory.getLog(LookUpOperatorFactory.class);

	@Lookup
	default LookUpRepository getRepository(String name) {
		return null;
	};
	
	@Lookup
	default LookUpOperator getLookUp(LookUpOperatorFactory factory, String name) {
		return null;
	};

	default LookUpOperator getLookUp(String name) {
		return getLookUp(this, name);
	};

}

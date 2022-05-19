package net.hibiznet.comm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

public class ComOthersExcepHndlr implements ErrorHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComOthersExcepHndlr.class);

    public void occur(Exception exception, String packageName) {
    	//log.debug(" EgovServiceExceptionHandler run...............");
    	LOGGER.error(packageName, exception);
    }

	@Override
	public void handleError(Throwable t) {
		// TODO Auto-generated method stub		
	}
}

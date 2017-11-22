package fbcmd4j;

import java.util.logging.LogManager;

public abstract class RequestConn {

	static {
	    try {
	      LogManager.getLogManager().readConfiguration(RequestConn.class.getResourceAsStream("logging.properties"));
	    } catch (Exception e) {
	      throw new IllegalStateException("Could not read in logging configuration", e);
	    }
	}

}

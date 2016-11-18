package slf4j.log;
	
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
	public static void main(String[] args) {
		//Logger logger = LoggerFactory.getLogger("HelloWorld");
		Logger logger = LoggerFactory.getLogger(HelloWorld.class);
		logger.debug("Nguyen Thien Thuat");
		logger.info("Nguyen Thien Thuat");
		System.out.println("Finish Example");
	}
}

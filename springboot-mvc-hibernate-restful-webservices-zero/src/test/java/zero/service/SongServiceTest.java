package zero.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SongServiceTest {

	@Before
	private void before(){
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-locations-using-hibernate");
	}
	
    @Autowired
    private SongService songService;

    @Test
    public void testFindByShortName() {
    	
    }
}

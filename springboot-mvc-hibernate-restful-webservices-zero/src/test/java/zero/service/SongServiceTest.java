package zero.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zero.model.Song;

/**
 * @author Thuat T Nguyen
 * @version 08/01/2017
 */
public class SongServiceTest {

	private ClassPathXmlApplicationContext appContext;
	private SongService songService;
	
	@Before
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-datasource-using-hibernate.xml");
		songService = (SongService) appContext.getBean("songService");
	}
	
	/*Chưa làm được chỗ autowired này*/
    /*@Autowired
    private SongService songService;*/

    @Test
    public void testFindByShortName() {
    	for(Song song : songService.findByShortName("thefatrat_monody")) {
			System.out.println("Id: " + song.getArtist());
			System.out.println("=====================");
		}
    	System.out.println("Thuat");
    }
}

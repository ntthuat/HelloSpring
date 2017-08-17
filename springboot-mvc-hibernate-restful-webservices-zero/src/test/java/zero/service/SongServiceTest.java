package zero.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

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
    
    @Test
    public void testListBean() {
    	getInstantiatedSigletons(appContext);
    }
    
    /**
     * @author Thuat T Nguyen
     * @version 08/03/2017
     * 
     * Hàm check các bean được tạo ra
     */
    public static List<Object> getInstantiatedSigletons(ApplicationContext ctx) {
		List<Object> singletons = new ArrayList<Object>();

		String[] all = ctx.getBeanDefinitionNames();

		ConfigurableListableBeanFactory clbf = ((AbstractApplicationContext) ctx).getBeanFactory();
		for (String name : all) {
			Object s = clbf.getSingleton(name);
			if (s != null)
				singletons.add(s);
		}
		return singletons;
	}
}

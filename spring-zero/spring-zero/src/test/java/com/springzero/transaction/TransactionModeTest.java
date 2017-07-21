package com.springzero.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springzero.dataaccess.config.DataAccessConfig;

/**
 * Class này để test TransactionMode
 * 
 * @author Thuat T Nguyen
 * @version 04/19/2017
 */
@ContextConfiguration({ "classpath:/META-INF/spring/bean-dataaccess-application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext 
// DirtiesContext: Test annotation which indicates that the ApplicationContext associated with a test is dirty 
// and should therefore be closed and removed from the context cache. Nghĩa là cái context này sẽ được đóng và remove ra khỏi cache after finish.
public class TransactionModeTest implements ApplicationContextAware{
	
	public ApplicationContext getContext() {
        return applicationContext;
    }
	
	/**
	 * spring application context
	 */
	private ApplicationContext applicationContext;
	
	@Test
	public void testTransactionModeEnum(){
		final TransactionMode savedMode = DataAccessConfig.getTransactionMode();
		DataAccessConfig.getInstance().setTransactionMode(TransactionMode.NONE);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext){
		this.applicationContext = applicationContext;
	}
}

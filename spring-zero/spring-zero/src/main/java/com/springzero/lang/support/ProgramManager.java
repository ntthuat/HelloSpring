package com.springzero.lang.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/*import org.springframework.core.io.support.PropertiesLoaderSupport;*/

/**
 * This class is designed to manipulate how a transformed program can be loaded, called or unloaded. In short, it's like
 * a lifecycle manager of transformed program.<br>
 * Nói chung class này dùng để support mở 1 program.<br>
 * Class này là class chuẩn của bean.
 * 
 * @author Thuat T Nguyen
 * @version 05/17/2017
 *
 */
// comment extends PropertiesLoaderSupport vì cái này không phù hợp với spring 4.6 mình đã tải
public class ProgramManager /*extends PropertiesLoaderSupport*/ implements InitializingBean, DisposableBean, ApplicationContextAware {

	/**
	 * Logger declaration
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProgramManager.class);
	
	/**
	 * Static instance to allow static access. This is initialized when Spring configuration is loaded.
	 */
	private static ProgramManager sInstance;
	
	/**
	 * Spring context to be used to load {@link ProgramInitializer} and {@link ProgramFinalizer} automatically
	 */
	private ApplicationContext applicationContext; // cái này chưa biết ProgramInitializer và ProgramFinalizer là gì
	
	/**
	 * Get the instance of ProgramManager configured in Spring ApplicationContext
	 *
	 * @return bean instance configured in Spring Application Context
	 */
	public static ProgramManager getInstance() {
		return sInstance;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

}

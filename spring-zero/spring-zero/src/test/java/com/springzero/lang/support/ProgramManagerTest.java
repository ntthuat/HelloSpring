package com.springzero.lang.support;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Class này thực hiện test việc tạo bean.<br>
 * Tuy nhiên hiện giờ báo lỗi "java.lang.IllegalStateException: Failed to load ApplicationContext"
 * 
 * @author Thuat T Nguyen
 * @version 05/17/2017
 *
 */
@ContextConfiguration({ "classpath:spring/qre-test-context-program.xml" })
//@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
public class ProgramManagerTest {
	
	/**
     * logger definition
     */
    private static final Logger logger = LoggerFactory.getLogger(ProgramManagerTest.class);

	/**
	 * EXPECTED_RETURN_CODE expected return code in many tests
	 */
	private static final int EXPECTED_RETURN_CODE = 500;

	/**
	 * Declare String "TEST" as a constant
	 */
	private static final String TEST = "TEST";

	/**
	 * Declare String "testLoadClassOfT" as a constant
	 */
	private static final String TEST_LOAD_CLASS_OF_T = "testLoadClassOfT";

	/**
	 * Declare String "dummy" as a constant
	 */
	private static final String DUMMY = "dummy";
	/**
	 * programManager instance will be run in tests
	 */
	@Autowired
	private ProgramManager programManager;
	
	/**
	 * Test method for {@link com.springzero.lang.support.ProgramManager#getInstance())} .
	 */
	@Test
	public final void testGetInstance() {
		ProgramManager testInstance = ProgramManager.getInstance();
		Assert.assertNotNull(testInstance);
		// check whether it is get in Spring context
		Assert.assertEquals(programManager, testInstance);

/*		// check set program iniatilizer
		Assert.assertTrue(programManager.programInitializers.size() == 2);
		// run afterPropertiesSet again
		programManager.afterPropertiesSet();
		// list increased 2 more
		Assert.assertTrue(programManager.programInitializers.size() == 4);

		programManager.setProgramInitializer(test1ProgramInitializer);
		Assert.assertEquals(1, programManager.programInitializers.size());
		// set program initializer by afterPropertiesSet
		programManager.programInitializers = null;
		programManager.afterPropertiesSet();
		Assert.assertEquals(2, programManager.programInitializers.size());*/
	}
}

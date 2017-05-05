package com.jdbczero.core.support;

import org.junit.Test;
import org.slf4j.Logger;

import com.jdbczero.core.loggers.Statistics;

/**
 * This class test for StatisticUltils
 * 
 * @author tnguyen443
 * @version 05/05/2017
 */
public class StatisticUtilsTest {
	
	/**
	 * logger
	 */
	private static final Logger STATISTIC_LOGGER = Statistics.LOGGER;
	
	@Test
	public void testStartStatistic(){
		System.out.println(STATISTIC_LOGGER.isDebugEnabled());
		System.out.println(STATISTIC_LOGGER.isErrorEnabled());
		System.out.println(STATISTIC_LOGGER.isInfoEnabled());
		System.out.println(STATISTIC_LOGGER.isWarnEnabled());
		//final boolean isStatisticEnable = STATISTIC_LOGGER.isDebugEnabled();
	}
}

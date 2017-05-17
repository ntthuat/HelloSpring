package com.springzero.core.support;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;

import com.springzero.core.constant.StatisticLevel;
import com.springzero.core.loggers.Statistics;
import com.springzero.core.support.StatisticUtils;

/**
 * This class test for StatisticUltils
 * 
 * @author Thuat T Nguyen
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
		final boolean isStatisticEnable = STATISTIC_LOGGER.isDebugEnabled();
		assertTrue(isStatisticEnable); // vì log4j.rootLogger=DEBUG, A1 nên cả 4 cái đều là true
		final long start = StatisticUtils.startStatistic(StatisticLevel.COMPONENT);
		System.out.println(start);
		Date date = new Date(start);
		DateFormat formatter = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss:SSS");
		String dateFormatted = formatter.format(date);
		System.out.println(dateFormatted);
	}
}

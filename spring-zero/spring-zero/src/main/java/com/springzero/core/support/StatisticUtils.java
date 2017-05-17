package com.springzero.core.support;

import org.slf4j.Logger;

import com.springzero.core.constant.StatisticLevel;
import com.springzero.core.loggers.Statistics;

/**
 * @author Thuat T Nguyen
 * @version 05/05/2017
 *
 */
public class StatisticUtils {
	
	/**
	 * logger
	 */
	private static final Logger STATISTIC_LOGGER = Statistics.LOGGER;
	
	/**
	 * Indicates statistic level
	 */
	//private static final StatisticLevel STATISTIC_LEVEL = QreConfig.getStatisticLevel();
	
	public static boolean isStatisticEnabled(final StatisticLevel level) {
		return (STATISTIC_LOGGER.isInfoEnabled()/* && STATISTIC_LEVEL.isEnabled(level)*/);
	}
	
	public static long startStatistic(final StatisticLevel level) {
		final boolean isStatisticEnable = STATISTIC_LOGGER.isDebugEnabled();
		
		final long startTimeMillis;
		if (isStatisticEnable) { 
			startTimeMillis = System.currentTimeMillis();
		} else {
			startTimeMillis = 0;
		}
		
		return startTimeMillis;
	}
}

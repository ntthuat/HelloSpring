package com.jdbczero.core.support;

import org.slf4j.Logger;

import com.jdbczero.core.constant.StatisticLevel;
import com.jdbczero.core.loggers.Statistics;

/**
 * @author tnguyen443
 * @version 05/05/2017
 *
 */
public class StatisticUtils {
	
	/**
	 * logger
	 */
	private static final Logger STATISTIC_LOGGER = Statistics.LOGGER;
	
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

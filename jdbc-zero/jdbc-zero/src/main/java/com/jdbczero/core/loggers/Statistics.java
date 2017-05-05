package com.jdbczero.core.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jdbczero.core.constant.StatisticLevel;

/**
 * Statistic helper to print out static information if certain statistic level is enabled. <br>
 * refer to {@link StatisticLevel} for details of level setting<br>
 * To log statistic information, need to enable INFO level messages for {@link Statistics} logger in logback
 * configuration
 * 
 * @author tnguyen443
 * @version 05/05/2017
 */
public final class Statistics {
	/**
	 * logger
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger(Statistics.class);
}

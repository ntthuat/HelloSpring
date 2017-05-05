package com.jdbczero.core.constant;

/**
 * Enumeration created to indicate statistic level, which is used to help
 * determine what level of statistic will be turned on.
 * 
 * @author tnguyen443
 * @version 05/05/2017
 *
 */
public enum StatisticLevel {
	/**
	 * Statistic is off.
	 */
	OFF(Integer.MAX_VALUE), 
	/**
     * statistic is only generated at service level, which including web requests, batch service
     * request, interfaces handling. <br>
     * Functionalities such as file operations, data access operations statistic are not enabled at this
     * level
     */
	SERVICE(50000), 
	/**
     * statistic for services details, which means all steps of service will have statistic enabled
     */
	SERVICE_DETAILS(45000), 
	/**
	 * statistic is turned on for all components, such as file
	 * access, data access, sql execution etc
	 */
	COMPONENT(30000), 
	/**
	 * statistic is turned on for all components at detail level
	 */
	COMPONENT_DETAIL(25000), 
	/**
	 * statistic is all on
	 */
	ALL(0);

	/**
	 * Integer represents level, which is larger indicates lower level, similar to logging level
	 */
	private final int level;

	/**
	 * private constructor with level
	 * @param level - level
	 */
	private StatisticLevel(final int level) {
		this.level = level;
	}

	/**
	 * Indicates if a provided level is enabled comparing to this one
	 * @param level - the level
	 * @return true if given level integer is less than the the current one
	 */
	public boolean isEnabled(StatisticLevel level) {
		return this.level <= level.level;
	}
}

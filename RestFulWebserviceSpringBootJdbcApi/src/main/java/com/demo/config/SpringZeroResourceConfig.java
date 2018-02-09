package com.demo.config;

/*import codix.eu.soa_ws.common.config.properties.AppProperties;*/
/*import codix.eu.soa_ws.common.config.properties.DBProperties;
import codix.eu.soa_ws.common.exception.ConfigurationException;
import codix.eu.soa_ws.common.util.BasicDatasourceManager;
import codix.eu.soa_ws.common.util.JdbcTemplateLog;
import imx.util.prm;*/
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.demo.config.properties.DBProperties;

import javax.sql.DataSource;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/08/2018
 * 
 */
@Configuration
@ComponentScan(basePackages = { "com.demo" })
class SpringZeroResourceConfig extends WebMvcConfigurerAdapter {
	/*
	private static Logger logger = Logger.getLogger(SpringZeroResourceConfig.class);

	@Autowired
	private AppProperties appProperties;

	@Value("${spring.datasource.url:}")
	private String springDatasource;

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource(DBProperties dbProperties) throws ConfigurationException {
		DataSource ds = null;

		if (!prm.isEmpty(dbProperties.isUse_wallet())) {
			logger.debug("Use custom data source -> " + dbProperties);
			ds = new BasicDatasourceManager(dbProperties).getBasicDataSource();
		} else if (!prm.isEmpty(springDatasource)) {
			logger.debug("Use spring.datasource");
			ds = DataSourceBuilder.create()
					// .username("") //got from "spring.datasource"
					// .password("") //~
					// .url("") //~
					// .driverClassName("") //~
					.build();
		}

		logger.debug("got dataSource -> " + ds);
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplateLog(dataSource);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		logger.info("services properties -> " + appProperties.getServices());
		registry.addInterceptor(new EnableServiceHandler(appProperties.getServices()));
	}

	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
		loggingFilter.setIncludeClientInfo(false);
		loggingFilter.setIncludeQueryString(true);
		loggingFilter.setIncludePayload(true);
		loggingFilter.setIncludeHeaders(true);
		loggingFilter.setMaxPayloadLength(2048);
		loggingFilter.setBeforeMessagePrefix("REQUEST INFO BEFORE PROCESSED: ");
		loggingFilter.setAfterMessagePrefix("REQUEST INFO AFTER PROCESSED: ");
		return loggingFilter;
	}*/
}

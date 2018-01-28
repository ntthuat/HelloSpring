package com.demo.dao;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.demo.dao.impl.MessageDaoImpl;
import com.demo.dao.impl.StudentDaoImpl;
import com.demo.entity.Student;
import com.demo.model.MessageRequest;

/**
 * 
 * @author Thuat T Nguyen
 * @version 01/28/2018
 *
 */
public class StudentDaoTest {
	
	private ApplicationContext appContext;
	private StudentDao studentDao;
	
	@Autowired
	private DataSource datasource;
	
	public DataSource getDataSource() {
		return datasource;
	}
	
	@Before
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dataaccess-application.xml");
		studentDao = (StudentDaoImpl)appContext.getBean("studentDao");
	}
	
	@Test
	public void testGetStudent() {
		Student student1 = studentDao.getStudent("THUAT");
		assertEquals("MATH", student1.getSubject());
		
		Student student2 = studentDao.getStudent("HIEN");
		assertEquals("BIOGRAPHY", student2.getSubject());
	}
	
	@Test
	public void testMapSqlParameterSource() {
		
	}
	
	/*@Override
	public List<DataAreaDom> query(final String name, final String library, final boolean isTemporaryOnly) {
		final boolean nameSpecified = !StringUtils.isEmpty(name);
		final boolean librarySpecified = !StringUtils.isEmpty(library);
		if (!nameSpecified && !librarySpecified) {
			throw new IseriesGenericException("At least one of data queue name and library must be specified");
		}
		
		final String dataAreaSchema = getDataAreaSchema(isTemporaryOnly);
		if (StringUtils.isEmpty(dataAreaSchema)) {
			return null;
		}
		
		final String libraryName = resolveLibrary(name, library);
		
		StringBuffer selectSQL = new StringBuffer();
		selectSQL.append("SELECT * FROM ");
		selectSQL.append(dataAreaSchema + "." + DataAreaDom.DATA_AREA_TABLE);
		selectSQL.append(" WHERE 1=1 ");
		
		if (nameSpecified) {
			// A generic name?
			selectSQL.append(" AND " + DataAreaDom.DATA_AREA_NAME_COLUMN + (name.endsWith(StringConstants.AST) ? " LIKE " : " = ") + ":" + DataAreaDom.DATA_AREA_NAME_PARAM);
		}
		
		if (librarySpecified && !library.equals(StringConstants.AST)) {
			selectSQL.append(" " + (nameSpecified ? "AND " : " ") + DataAreaDom.DATA_AREA_LIBRARY_COLUMN + " = :" + DataAreaDom.DATA_AREA_LIBRARY_PARAM);
		}
		
		Map<String, Object> paramMap = new HashMap<>();
		if (nameSpecified) {
			paramMap.put(DataAreaDom.DATA_AREA_NAME_PARAM, name.endsWith(StringConstants.AST) ? name.substring(0, name.length() - 1) + "%" : name); // Add filter for queue name, which could be generic name like QU* or a specific name
		}
		
		if (librarySpecified && !library.equals(StringConstants.AST)) {
			paramMap.put(DataAreaDom.DATA_AREA_LIBRARY_PARAM, libraryName);
		}
		
		return getJdbcTemplate(dataAreaSchema, false).query(selectSQL.toString(), paramMap, DATA_AREA_ROW_MAPPER);
	}*/
}

package com.springzero.lang;

import org.junit.Test;

import com.springzero.springjdbc.EmployeeDao;
import com.springzero.springjdbc.EmployeeDaoImpl;
import com.springzero.springjdbc.EmployeeDto;

import junit.framework.Assert;

import static com.springzero.lang.jdbczeroFunction.linkFields;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/**
 * @author Thuat T Nguyen
 * @version 04/13/2017
 */
public class JdbczeroFunctionTest {
	final int abc = 3;
	/**
     * Hiện thời chỉ dùng để chạy linkFields, chưa dùng làm gì cả.
     */
	@Test
	public void testLinkFields() {
		EmployeeDto dto1 = new EmployeeDto();
		EmployeeDto dto2 = new EmployeeDto();
		linkFields(dto1, dto2);
	}
	
	/**
     * 1. Dùng để test hàm "final Class<?> t = EmployeeDto.getClass()"
     * với EmployeeDto là class nằm ở package com.jdbczero.entity;
     * 2. Dùng để test hàm "final Field[] fields = t.getDeclaredFields()"
     * với t ở scenario 1
     * 3. Dùng để test method getModifiers() với
     * <pre>
     * 0: default - sẽ không in ra gì cả
     * 1: public
     * 2: private
     * 4: protected
     * 8: static
     * 16: final
     * 32: synchronized
     * 64: volatile
     * 128: transient
     * 256: native
     * 512: interface
     * 1024: abstract
     * 2048: strictfp - đây là kiểu STRICT
     * </pre>
     * 
     * 4. Dùng để test method Class<?>.isAssignableFrom(Class<?>):
     * Method này trả lại true khi thằng bên ngoài là cha (superclass hoặc superinterface) của thằng bên trong
     */
	@Test
	public void testGetClass() {
		// Scenario 1: "final Class<?> t = EmployeeDto.getClass()"
		final EmployeeDto dto = new EmployeeDto();
		final Class<?> t = dto.getClass();

		Assert.assertEquals("com.jdbczero.entity.EmployeeDto", t.getName());
		Assert.assertEquals("EmployeeDto", t.getSimpleName());
		Assert.assertEquals("com.jdbczero.entity.EmployeeDto", t.getCanonicalName());
		
		// Scenario 2: "final Field[] fields = t.getDeclaredFields()"
		final Field[] fields = t.getDeclaredFields();
		Assert.assertEquals(2, fields.length);
		Assert.assertEquals(int.class, fields[0].getType());
		Assert.assertEquals(String.class, fields[1].getType());
		
		// Scenario 3: test method getModifiers()
		for (Field f1 : fields) {
			Assert.assertEquals(2, f1.getModifiers());
			Assert.assertEquals("private", Modifier.toString(f1.getModifiers()));
		}
		
		// Scenario 4: test method Class<?>.isAssignableFrom(Class<?>)
		assertTrue(EmployeeDao.class.isAssignableFrom(EmployeeDaoImpl.class));
		assertFalse(EmployeeDaoImpl.class.isAssignableFrom(EmployeeDao.class));
		
		// Scenario 5:
		for (Field f1 : fields) {
			f1.setAccessible(true);
		}
	}
	
	/**
     * 4. Dùng để test method setAccessible(true)
     * nếu field này được set lên true, thì bên ngoài có thể truy cập vào được dù nó có là private
     * 
	 * @throws Exception
     */
	@Test
	public void testSetAccessibleTrue() throws Exception{
		TestClass testClass = new TestClass();
		final Class<?> c = testClass.getClass();
		Field field = c.getDeclaredField("theField");
		field.setAccessible(true);
		Assert.assertEquals("abcXYZ", field.get(testClass));
	}
	
	/**
     * 4. Dùng để test method setAccessible(true)
     * nếu field này được set lên true, thì bên ngoài có thể truy cập vào được dù nó có là private.
     * 
     * Message Expectation: Class com.jdbczero.lang.JdbczeroFunctionTest can not access a member of 
     * class com.jdbczero.lang.JdbczeroFunctionTest$TestClass with modifiers "private final".
     * 
	 * @throws Exception
     */
	@Test(expected = java.lang.IllegalAccessException.class)
	public void testSetAccessibleFalse() throws Exception{
		TestClass testClass = new TestClass();
		final Class<?> c = testClass.getClass();
		Field field = c.getDeclaredField("theField");
		Assert.assertEquals("abcXYZ", field.get(testClass));
	}
	
	public static class TestClass {
        final private String theField = "abcXYZ";
    }
}

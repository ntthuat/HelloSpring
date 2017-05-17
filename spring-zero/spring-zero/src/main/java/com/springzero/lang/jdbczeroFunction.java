package com.springzero.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Contains common functions for jdbcZero project.
 * 
 * @author Thuat T Nguyen
 * @version 04/13/2017
 */
public class jdbczeroFunction {
	/**
	 * TO-DO: EDIT, NAME AND CODE.
	 * The method is created to resolve the issue of a variable can be defined in multiple sources, with/without same
	 * name and with/without same type<br>
	 * Given objects that contain fields to be linked can be CodeModel, CopyModel or IseriesDto.<br>
	 * Fields to be linked are LegacyData will be replaced with an instance of LegacyDataProxy. This assumes fields are
	 * public or accessible and not final. For CodeModel and CopyModel, link field must be annotated with
	 * {@link LinkedVariable}).<br>
	 *
	 * @param o1 - the object carrying field 1 to be linked
	 * @param o2 - the object carrying field 2 to be linked
	 */
	public static void linkFields(final Object o1, final Object o2) {
		final Class<?> t2 = o2.getClass(); // nếu o1 là EmployeeDto thì t2 sẽ là "class com.jdbczero.entity.EmployeeDto"
		final Field[] fields = o1.getClass().getDeclaredFields();
		final boolean checkLinkedVariable = true;
		final boolean skipStructure = false;
		
		for (Field f1 : fields) {
			// only process legacy data types
			if (Modifier.isFinal(f1.getModifiers())) {
				continue;
			}

			/*if (checkLinkedVariable) {
				final LinkedVariable link = f1.getAnnotation(LinkedVariable.class);
				if (link == null) {
					continue;
				}
			}*/

			f1.setAccessible(true);
			// Observe only on the variables carried in code
			/*linkFields(o1, f1, true, o2, t2, true, skipStructure);*/
		}
	}
}

package com.rohimchou.consoleapp1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionLab {

	public void run() {
		this.getFields();
	}
	
	private void getFields() {
		try {
			User u = new User(1, "Amy");
			Field[] fields = u.getClass().getDeclaredFields();
			// orField[] fields = User.class.getDeclaredFields();
			for (Field f : fields) {
				// get field name
				String fieldName = f.getName();
				
				// get field modifiers
				String modifiersName = "";
				int modifiers = f.getModifiers();
				modifiersName = this.getAccessModifierNames(modifiers);
				
				// get field value
				Object fieldValue = null;
				f.setAccessible(true);
				fieldValue = f.get(u);
				System.out.format(
						"field: %-10s, value: %-30s, modifier: %-3d (%s)%n"
						, fieldName, fieldValue, modifiers, modifiersName);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getAccessModifierNames(int modifier) {
//		if (Modifier.isPublic(modifier)) {
//			return "Public";
//		} else if (Modifier.isProtected(modifier)) {
//			return "Protected";
//		} else if (Modifier.isPrivate(modifier)) {
//			return "Private";
//		} else if (Modifier.isXXXX(modifier)) {
//			return "Private";
//		} 
		
		return Modifier.toString(modifier);

//		List of Modifier	
//		Modifier.PUBLIC 		==    1
//		Modifier.PRIVATE 		==    2
//		Modifier.PROTECTED 		==    4
//		Modifier.STATIC    		==    8
//		Modifier.FINAL      	==   16
//		Modifier.SYNCHRONIZED	==   32
//		Modifier.VOLATILE		==   64
//		Modifier.TRANSIENT		==  128
//		Modifier.NATIVE			==  256
//		Modifier.INTERFACE		==  512
//		Modifier.ABSTRACT		== 1024
//		Modifier.STRICT			== 2048
	}

}

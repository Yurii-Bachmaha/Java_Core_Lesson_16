package task01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Class pc = Person.class;
		
		String name = pc.getName();
		System.out.println("Class name = " + name);
		
		String simpleName = pc.getSimpleName();
		System.out.println("Simple name of class = "+simpleName);
		
		int modifiers = pc.getModifiers();
		String modifiersText = Modifier.toString(modifiers);
		System.out.println("\nClass modifier = " + modifiersText + " | int = "+ modifiers);
		
		System.out.println("Is private = " + Modifier.isPrivate(modifiers));
		System.out.println("Is abstract = " + Modifier.isAbstract(modifiers));
		System.out.println("Is protected = " + Modifier.isProtected(modifiers));
		System.out.println("Is static = " + Modifier.isStatic(modifiers));
		
		Package getPackage = pc.getPackage();
		System.out.println("\nPackage of current class = " + getPackage);
		
		Class superClass = pc.getSuperclass();
		System.out.println("\nSuper class = " + superClass);
		
		Class[] interfaces = pc.getInterfaces();
		System.out.println("\nInterfaces = " + Arrays.toString(interfaces));
		System.out.println();
		
		Constructor<Person>[] personConstructor = pc.getConstructors();
		for (int i = 0; i < personConstructor.length; i++) {
			Constructor<Person> constructor = personConstructor[i];
			System.out.println("Constructors = "+ constructor);
		}
		System.out.println("Constructor size = " +personConstructor.length);
		
		System.out.println();
		Method[] methods = pc.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println("Method = "+method);
		}
		System.out.println("Number of methods = "+methods.length);
		
		System.out.println("\nPerson constructor with int and double parameters:");
		Constructor<Person> constructor = personConstructor[2];
		Class<?>[] parameterTypes = constructor.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			Class<?> class1 = parameterTypes[i];
			System.out.println(class1);
		}
		
		Constructor<Person> singleConstructor = pc.getConstructor(String.class, int.class);
		System.out.println("\nSingle constructor = " +singleConstructor);
		Person newInstancePerson = singleConstructor.newInstance("John", 34);
		System.out.println("\nReflection person = "+newInstancePerson);
		
		System.out.println("\nPublic fields:");
		Field[] fields = pc.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}
		System.out.println("\nAll available fields:");
		fields = pc.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}
		
		System.out.println("\nChange the name of the person using reflection:");
		Field fieldName = pc.getField("name");
		fieldName.set(newInstancePerson, "Peter");
		System.out.println(newInstancePerson);
		
		System.out.println("\nChange the age of the person using reflection:");
		Method fieldAge = pc.getMethod("setAge", int.class);
		fieldAge.invoke(newInstancePerson, 59);
		System.out.println(newInstancePerson);
		
		System.out.println("\nChange the surname of the person using reflection:");
		Method fieldSurname = pc.getMethod("setSurname", String.class);
		fieldSurname.invoke(newInstancePerson, "Pan");
		System.out.println(newInstancePerson);
		
		System.out.println("\nChange the weight of the person using reflection:");
		Method fieldWeight = pc.getMethod("setWeight", double.class);
		fieldWeight.invoke(newInstancePerson, 44.4);
		System.out.println(newInstancePerson);
	}
}
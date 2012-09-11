package interpret;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch10.ex10_05.Char;

public class Classoperator {

	public static  Object getObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> c = Class.forName(className);
		Object object = c.newInstance();
		return object;
	}

	public static Map getFieldsAndValues(Object o) {
		Map<Field, Object> map = new HashMap<Field, Object>();

		Field[] fields = o.getClass().getDeclaredFields();
		for(Field f : fields) {
			f.setAccessible(true);
			try {
				map.put(f, f.get(o));
			} catch (IllegalArgumentException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		return map;
	}

	public static List getFields(Object o){
		Field[] fields = o.getClass().getDeclaredFields();
		List list = new ArrayList();

		for(Field f : fields) {
			list.add(f);
		}

		return list;
	}

	public static Object setField(Object o, Field f, String v) throws IllegalArgumentException, IllegalAccessException {
		if(f.getType().equals(boolean.class)) {
			f.setBoolean(o, Boolean.parseBoolean(v));
		} else if (f.getType().equals(byte.class)) {
			f.setByte(o, Byte.parseByte(v));
		} else if (f.getType().equals(char.class)) {
			f.setChar(o, v.charAt(0));
		} else if (f.getType().equals(short.class)) {
			f.setShort(o, Short.parseShort(v));
		} else if (f.getType().equals(int.class)) {
			f.setInt(o, Integer.parseInt(v));
		} else if (f.getType().equals(long.class)) {
			f.setLong(o, Long.parseLong(v));
		} else if (f.getType().equals(float.class)) {
			f.setFloat(o, Float.parseFloat(v));
		} else if (f.getType().equals(double.class)) {
			f.setDouble(o, Double.parseDouble(v));
		} else {
			f.set(o, v);
		}

		return o;
	}


	public static List<Method> getMethods(Object o) {
		List list = new ArrayList<Method>();

		Method[] m1 = o.getClass().getDeclaredMethods();
		Method[] m2 = o.getClass().getMethods();

		for(Method m: m2) {
			list.add(m);
		}

		for(Method m: m1) {
			if(!m.toString().startsWith("public")){
				list.add(m);
			}
		}
		return list;
	}

	public static Object runMethod(Object o, Method m, Object... args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		return m.invoke(o, args);
	}

	public static List<Constructor> getConstructor(Class cl){
		List list = new ArrayList<Constructor>();

		Constructor[] cs = cl.getConstructors();

		for(Constructor c : cs) {
			list.add(c);
		}
		return list;
	}

}

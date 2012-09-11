package ch16.ex16_05;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class ClassContents {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembers(c.getFields());
			printExceptPublicMembers(c.getDeclaredFields());

			printMembers(c.getConstructors());
			printExceptPublicMembers(c.getDeclaredConstructors());

			printMembers(c.getMethods());
			printExceptPublicMembers(c.getDeclaredMethods());

		} catch (ClassNotFoundException e) {
			System.out.println("");
		}
	}

	private static void printMembers(Member[] mems){
		for (Member m : mems) {
			Annotation[] annotations = new Annotation[0];

			if (m instanceof Field) {
				annotations = ((Field)m).getAnnotations();
			}
			if (m instanceof Constructor) {
				annotations = ((Constructor<?>)m).getAnnotations();
			}
			if (m instanceof Method) {
				annotations = ((Method)m).getAnnotations();
			}

			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(decl);

			for (Annotation ano : annotations)
				System.out.println(ano.toString());
		}
	}


	private static void printExceptPublicMembers(Member[] mems){
		for (Member m : mems) {
			Annotation[] annotations = new Annotation[0];

			if (m instanceof Field) {
				annotations = ((Field)m).getAnnotations();
			}
			if (m instanceof Constructor) {
				annotations = ((Constructor<?>)m).getAnnotations();
			}
			if (m instanceof Method) {
				annotations = ((Method)m).getAnnotations();
			}


			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			if(!decl.startsWith("public")){
				System.out.print(" ");
				System.out.println(decl);
			}
			for (Annotation ano : annotations)
				System.out.println(ano.toString());

		}
	}

	private static String strip(String str, String stripChars){
		return str;
	}
}

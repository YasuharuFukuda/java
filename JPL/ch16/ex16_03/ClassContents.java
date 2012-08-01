package ch16.ex16_03;

import java.lang.reflect.Member;

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
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl, "java.lang."));
		}
	}


	private static void printExceptPublicMembers(Member[] mems){
		for (Member m : mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			if(!decl.startsWith("public")){
				System.out.print(" ");
				System.out.println(strip(decl, "java.lang."));
			}
		}
	}

	private static String strip(String str, String stripChars){
		return str;
	}
}

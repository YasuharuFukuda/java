package ch16.ex16_04;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class AnnotationAnalysis {


	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName(args[0]);
			AnnotationAnalysis.printAnnotations(cls);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void printAnnotations(Class<?> cls){
		Annotation[] ano = cls.getAnnotations();
		for(Annotation an : ano) {
			System.out.println(an.toString());;
		}
	}
}


@BugsFixed({"45678", "43246"})
class Foo {}

@Retention(RetentionPolicy.RUNTIME)
@interface BugsFixed {
    String[] value();
}

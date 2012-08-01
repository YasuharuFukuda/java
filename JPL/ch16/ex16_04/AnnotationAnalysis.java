package ch16.ex16_04;

import java.lang.annotation.Annotation;


public class AnnotationAnalysis {


	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("ch16.ex16_04.AnnotationAnalysis");
			AnnotationAnalysis.printAnnotations(cls, ClassInfo.class);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@ClassInfo(value="hoge")
	public static void printAnnotations(Class<?> cls, Class anotation){
		 ano = cls.getAnnotation(annotation);
		System.out.println(ans[0]);
		for(Annotation an : ans) {
			ClassInfo clsinfo = (ClassInfo)an;
			System.out.println(clsinfo.toString());
			System.out.println(clsinfo.hoge());
		}
	}
}



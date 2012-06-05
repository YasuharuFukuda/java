package ch10.ex10_03;

public class Work {
	public boolean isWorkForIfElse(Week w){
		if(w == Week.SATURDAY || w == Week.SUNDAY)
			return false;
		else
			return true;
	}

	public boolean isWorkForSwitch(Week w){
		switch(w) {
		case SUNDAY:
			return false;
		case SATURDAY:
			return false;
		default:
			return true;
		}
	}

	public static void main(String[] args) {
		Work w = new Work();

		System.out.println(w.isWorkForIfElse(Week.MONDAY));
		System.out.println(w.isWorkForIfElse(Week.SUNDAY));

		System.out.println(w.isWorkForSwitch(Week.MONDAY));
		System.out.println(w.isWorkForSwitch(Week.SUNDAY));

	}
}

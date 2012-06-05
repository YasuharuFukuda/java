package ch06.ex06_05;

public enum Color {
	GREEN("GREEN") {
		Color getColor() { return this;}
	},
	YELLOW("YELLOW") {
		Color getColor() { return this;}
	},
	RED("RED") {
		Color getColor() { return this;}
	};

	String name;
	Color(String name){ this.name = name; }
	abstract Color getColor();
}

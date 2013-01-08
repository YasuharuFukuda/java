package ch02.ex02_04;

import java.awt.Color;

public enum FontSizeList {
	TWENFIVE("25", 25),
	THIR("30", 30),
	THIRFIVE("35", 35),
	FOUR("40", 40),
	FOURFIVE("45", 45),
	FIF("50", 50);

	String name;
	int size;

	FontSizeList(String name, int size) {
		this.name = name;
		this.size = size;
	}

}

package ch02.ex02_01;

import java.awt.Color;

public enum ColorList {
	RED("RED", Color.RED),
	BLUE("BLUE", Color.BLUE),
	BLACK("BLACK", Color.BLACK),
	WHITE("WHITE", Color.WHITE);

	String name;
	Color color;

	ColorList(String name, Color color) {
		this.name = name;
		this.color = color;
	}

}
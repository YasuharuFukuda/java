package ch02.ex02_04;
import java.awt.Font;


public 	enum FontList {
	SERIF("SERIF", Font.SERIF),
	SANSERIF("SANS_SERIF", Font.SANS_SERIF),
	MONOSPACED("MONOSPACED", Font.MONOSPACED);

	String name;
	String fontName;
	FontList(String name, String fontName) {
		this.name = name;
		this.fontName = fontName;
	}
}

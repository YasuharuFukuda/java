package ch02.ex02_04;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorLabel {
	String text;
	Color panel;

	ColorLabel(String text, Color icon){
		this.text = text;
		this.panel = icon;
	}

	public String getText(){
		return text;
	}

	public Color getIcon(){
		return panel;
	}
}

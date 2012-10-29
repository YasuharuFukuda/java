package ch02.ex02_01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JPanel;

import clock.Pref;


class MyPanel extends JPanel {

	private int fontStyle = Font.PLAIN;
	private String fontName = Font.SERIF;
	private String sColor = "BLACK";
	private int fontSize = 30;
	private int xLayout = 100;
	private int yLayout = 100;
	private String bColor = "WHITE";

	public MyPanel(){
		setSize(xLayout, yLayout);
		setBackColor(bColor);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(getColor(sColor));
		g.setFont(new Font(fontName, fontStyle, fontSize));
		g.drawString(getTime(), 20, 50);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        repaint();
	}

	public String getTime() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		return hour + ":" + minute + ":" + second;
	}

	public void setColor(String color) {
		for (ColorList c : ColorList.values()){
			if(c.name.equals(color)){
				this.sColor = c.name;
				break;
			}
		}
	}
	public String getColor() {
		String co = null;
		for (ColorList c : ColorList.values()){
			if(c.name.equals(sColor)){
				co = c.name;
				break;
			}
		}
		return co;
	}

	public Color getColor(String cname){
		Color cn = null;
		for (ColorList c : ColorList.values()){
			if(c.name.equals(cname)){
				cn = c.color;
				break;
			}
		}
		return cn;
	}

	public int getFontSize(){
		return fontSize;
	}

	public void setFontSize(int size) {
		this.fontSize = size;
	}

	public void setFont(String fontName) {
		this.fontName = fontName;
	}

	public void setBackColor(String color){
		for (ColorList c : ColorList.values()){
			if(c.name.equals(color)){
				this.bColor = color;
				setBackground(c.color);
				break;
			}
		}
	}

}
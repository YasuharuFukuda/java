package ch02.ex02_03;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.util.Calendar;

import javax.swing.JPanel;

import clock.Pref;


class TimePanel extends JPanel {

	private int fontStyle = Font.PLAIN;
	private String fontName = Font.SERIF;
	private String sColor = "WHITE";
	private int fontSize = 30;
	private int xLayout = 200;
	private int yLayout = 120;
	private Color bColor = Color.black;

	private boolean flag = true;

	public TimePanel(){
		setSize(xLayout, yLayout);
		setOpaque(false);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		super.paintComponent(g2);

		if (flag == true) {
			g2.setPaint(bColor);
			RoundRectangle2D.Double rec2 =
					new RoundRectangle2D.Double(0, 0, xLayout, yLayout, 30.0d, 30.0d);
			g2.fill(rec2);
		}

		g.setColor(getColor(sColor));
		g.setFont(new Font(fontName, fontStyle, fontSize));
		g.drawString(getTime(), 30, 70);
		g.drawRoundRect(100, 150, 200, 300, 40, 80);
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
				//this.bColor = color;
				this.bColor = c.color;
				//setBackground(c.color);
				break;
			}
		}
	}

	public void setFlag(boolean b) {
		this.flag = b;
	}

}
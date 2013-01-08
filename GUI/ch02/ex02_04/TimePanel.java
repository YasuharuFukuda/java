package ch02.ex02_04;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Calendar;
import javax.swing.JPanel;


class TimePanel extends JPanel {

	private int fontStyle = Font.PLAIN;
	private String fontName = Pref.getCanvasFont();
	private String sColor = Pref.getCanvasColor();
	private int fontSize = Integer.parseInt(Pref.getCanvasFontSize());
	private int xLayout = 200;
	private int yLayout = 200;
	private Color bColor = TimePanel.getBackColor(Pref.getFlameColor());

	private boolean flag = true;

	private boolean isDigital = true;

	public TimePanel(){
		setSize(xLayout, yLayout);
		setOpaque(false);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		super.paintComponent(g2);

		if(isDigital == true) {
			if (flag == true) {
				g2.setPaint(bColor);
				RoundRectangle2D.Double rec2 =
						new RoundRectangle2D.Double(0, 0, xLayout, yLayout, 30.0d, 30.0d);
				g2.fill(rec2);
			}
			g2.setColor(getColor(sColor));
			g2.setFont(new Font(fontName, fontStyle, fontSize));
			g2.drawString(getTime(), 30, 110);
		} else {

			if (flag == true) {
				g2.setPaint(bColor);
				RoundRectangle2D.Double rec2 =
						new RoundRectangle2D.Double(0, 0, xLayout, yLayout, 200.0d, 200.0d);
				g2.fill(rec2);
			}

			int hour = getHour();
			int min = getMinute();
			int sec = getSecond();

			double hexDegrees = (hour % 12) * 30 + min * 0.5;
			double hexRadians = Math.toRadians(hexDegrees);
			double hx = 100.0 + 40.0 * Math.sin(hexRadians);
			double hy = 100.0 - 40.0 * Math.cos(hexRadians);
			g2.setStroke(new BasicStroke(6.0f));
			g2.setColor(getColor(sColor));
			Line2D hline = new Line2D.Double(100.0, 100.0, hx, hy);
			g2.draw(hline);

			double mexDegrees = min * 6.0;
			double mexRadians = Math.toRadians(mexDegrees);
			double mx = 100.0 + 50.0 * Math.sin(mexRadians);
			double my = 100.0 - 50.0 * Math.cos(mexRadians);

			g2.setStroke(new BasicStroke(4.0f));
			g2.setColor(getColor(sColor));
			Line2D mline = new Line2D.Double(100.0, 100.0, mx, my);
			g2.draw(mline);

			double sexDegrees = sec * 6.0;
			double sexRadians = Math.toRadians(sexDegrees);
			double sx = 100.0 + 80.0 * Math.sin(sexRadians);
			double sy = 100.0 - 80.0 * Math.cos(sexRadians);

			g2.setStroke(new BasicStroke(2.0f));
			g2.setColor(getColor(sColor));
			Line2D sline = new Line2D.Double(100.0, 100.0, sx, sy);
			g2.draw(sline);
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

	public int getSecond() {
		return Calendar.getInstance().get(Calendar.SECOND);
	}

	public int getMinute() {
		return Calendar.getInstance().get(Calendar.MINUTE);
	}


	public int getHour() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}

	public void setColor(String color) {
		for (ColorList c : ColorList.values()){
			if(c.name.equals(color)){
				this.sColor = c.name;
				break;
			}
		}
	}
	public String getSColor() {
		String co = null;
		for (ColorList c : ColorList.values()){
			if(c.name.equals(sColor)){
				co = c.name;
				break;
			}
		}
		return co;
	}

	public String getBColor() {
		String co = null;
		for (ColorList c : ColorList.values()){
			if(c.color.equals(bColor)){
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

	public static Color getBackColor(String cname){
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

	public String getFontName() {
		return fontName;
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
				this.bColor = c.color;
				break;
			}
		}
	}

	public void setFlag(boolean b) {
		this.flag = b;
	}

	public void setDigitalFlag(boolean b) {
		this.isDigital = b;
	}

	public boolean getsDigitalFlag() {
		return isDigital;
	}


}
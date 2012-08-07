package clock;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;


class MyCanvas extends Canvas implements Runnable{

	private String sColor = Pref.getCanvasColor();
	private String fontName = Pref.getCanvasFont();
	private int fontSize = Integer.parseInt(Pref.getCanvasFontSize());
	private int fontStyle = Font.PLAIN;
	private int xLayout = 30;
	private int yLayout = 40;

    private int timing = 1000;
    private Image imgBuffer;
    private Graphics gBuffer;

    /* スレッド本体 */
    public void run(){
        while(true){
            /* 指定時間待機します。*/
            try{
                Thread.sleep(timing);
            }catch(Exception e){}

            /* 再描画の要求 */
            repaint();
        }
    }

    public MyCanvas(){
     	setSize(getFontSize() * 6, getFontSize() * 4);
    }


	public void paint(Graphics g) {
		Dimension d = getSize();

		imgBuffer = createImage(d.width, d.height);
		gBuffer = null;

		if( gBuffer == null ){
            gBuffer = imgBuffer.getGraphics();
        }

		gBuffer.clearRect(0, 0, d.width, d.height);

		gBuffer.setColor(getColor(sColor));
		gBuffer.setFont(new Font(fontName, fontStyle, getFontSize()));
		gBuffer.drawString(getTime(), 30, yLayout);

		g.drawImage( imgBuffer, 0, 0, this);

		repaint();
	}

	 public void update(Graphics g){
	        paint(g);
	    }

	public String getTime() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		return hour + ":" + minute + ":" + second;
	}

	public void setFontSize(int size) {
		this.fontSize = size;
	}

	public void setFont(String fontName) {
		this.fontName = fontName;
	}

	public String getFontName() {
		return fontName;
	}

	public int getFontSizeString(){
		return fontSize;
	}

	public void setLayout(int x, int y){
		this.xLayout = x;
		this.yLayout = y;
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

}
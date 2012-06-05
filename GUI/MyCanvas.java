import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Calendar;


class MyCanvas extends Canvas implements Runnable {

	private Color sColor = Color.WHITE;
	private String fontName = Font.SERIF;
	private int fontStyle = Font.PLAIN;
	private int fontSize = 30;
	private int xLayout = 30;
	private int yLayout = 40;
	private Image buf;

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


	public void paint(Graphics g) {
		Dimension d = getSize();

		if( imgBuffer == null || imgBuffer.getWidth(this) != d.width || imgBuffer.getHeight(this) != d.height ){
            imgBuffer = createImage(d.width, d.height);
            gBuffer = null;
        }

		if( gBuffer == null ){
            gBuffer = imgBuffer.getGraphics();
        }
		gBuffer.clearRect(0, 0, d.width, d.height);

		Dimension size = getSize();

		gBuffer.setColor(sColor);
		gBuffer.setFont(new Font(fontName, fontStyle, fontSize));
		gBuffer.drawString(getTime(), xLayout, yLayout);

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
		updateFont();
	}

	public void setFont(String fontName) {
		this.fontName = fontName;
		updateFont();
	}

	public void updateFont() {
		setFont(new Font(fontName, fontStyle, fontSize));
	}

	public void setLayout(int x, int y){
		this.xLayout = x;
		this.yLayout = y;
	}

	public void setColor(String color) {
		if (color.equals(ColorList.RED.name())) {
			this.sColor = Color.red;
		} else if (color.equals(ColorList.BLUE.name())){
			this.sColor = Color.blue;
		} else if (color.equals(ColorList.BLACK.name())){
			this.sColor = Color.black;
		} else if (color.equals(ColorList.WHITE.name())){
			this.sColor = Color.white;
		}
	}
}
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;


public class Clock extends Frame {

	public static void main(String [] args) {
        new Clock();
    }
	Clock() {
        super("CanvasTest");
        setBackground(Color.BLACK);
        setSize(200, 100);
        setLayout(new BorderLayout());
        setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        MyCanvas mc = new MyCanvas();
        add(mc, BorderLayout.CENTER);
        //show();
        setVisible(true);
        addWindowListener(new MyWindowAdapter());
    }
}

class MyCanvas extends Canvas {

    public void paint(Graphics g) {
    	g.setColor(Color.WHITE);
        g.drawString(getTime(), 20, 40);
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
}

class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
       System.exit(0);
    }
}
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;


public class WindowClock extends Window  implements ActionListener, ItemListener , MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;

	//背景
	private Color bColor = Color.BLACK;

	//windowのサイズ
	private int width = 180;
	private int height = 100;

	private MyCanvas mc;

	PopupMenu popup = new PopupMenu("Property");

	WindowClock() {
		super(new Frame());
		defaultClock();
		setPupup(popup);
		add(popup);
		this.toFront();
	}

	public void defaultClock() {
		setBackground(bColor);
		setSize(width, height);
		mc = new MyCanvas();
		add(mc, BorderLayout.CENTER);
		setVisible(true);
		mc.addMouseListener(this);
        mc.addMouseMotionListener(this);
	}

	public void repaint(MyCanvas mc){
		setBackground(bColor);
		setSize(width, height);
		add(mc, BorderLayout.CENTER);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String selected = e.getActionCommand();
		if (selected.indexOf("Font:") != -1) {
			mc.setFont(selected.split("Font:")[1]);
		} else if(selected.indexOf("FontSize:") !=  -1) {
			mc.setFontSize(Integer.parseInt(selected.split("FontSize:")[1]));;
		} else if(selected.indexOf("文字色:") !=  -1) {
			mc.setColor(selected.split("文字色:")[1]);
		} else if(selected.indexOf("背景色:") !=  -1) {
			setBackColor(selected.split("背景色:")[1]);
		} else if(selected == "exit") {
			System.exit(0);
		}else
			System.out.println(e.getActionCommand());
		repaint(mc);
	}

	public void setMenuItem(PopupMenu popup, String item) {
		MenuItem menuItem = new MenuItem(item);
		menuItem.addActionListener(this);
		popup.add(menuItem);
	}

	public void setPupup(PopupMenu popup) {
		// font
		setMenuItem(popup, "Font:SERIF");
		setMenuItem(popup, "Font:SANSERIF");
		setMenuItem(popup, "Font:MONOSPACED");

		// fontsize
		setMenuItem(popup, "FontSize:20");
		setMenuItem(popup, "FontSize:25");
		setMenuItem(popup, "FontSize:30");
		setMenuItem(popup, "FontSize:35");

		// 文字カラー
		setMenuItem(popup, "文字色:RED");
		setMenuItem(popup, "文字色:BLUE");
		setMenuItem(popup, "文字色:BLACK");
		setMenuItem(popup, "文字色:WHITE");

//		// 背景
//		setMenuItem(popup, "背景色:RED");
//		setMenuItem(popup, "背景色:BLUE");
//		setMenuItem(popup, "背景色:BLACK");
//		setMenuItem(popup, "背景色:WHITE");

		//exit
		setMenuItem(popup, "exit");
	}

	public void setBackColor(String color){
		if (color.equals(ColorList.RED.name())) {
			this.bColor = Color.red;
		} else if (color.equals(ColorList.BLUE.name())){
			this.bColor = Color.blue;
		} else if (color.equals(ColorList.BLACK.name())){
			this.bColor = Color.black;
		} else if (color.equals(ColorList.WHITE.name())){
			this.bColor = Color.white;
		}
	}

	private MouseEvent start;

	public void mouseDragged(MouseEvent e) {
		Point eventLocationOnScreen = e.getLocationOnScreen();
   	    setLocation(eventLocationOnScreen.x - start.getX(),	eventLocationOnScreen.y - start.getY());
	}

	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseClicked(MouseEvent e) {
		int btn = e.getButton();
    	if (btn == MouseEvent.BUTTON3) {
    		popup.show(this , e.getX() , e.getY());
    	}
	}

	public void mousePressed(MouseEvent e) {
		start = e;
	}

	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void itemStateChanged(ItemEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void run() {
		// TODO 自動生成されたメソッド・スタブ

	}
	public static void main(String args[]) {
		new WindowClock();
	}
}

package ch02.ex02_03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;


public class Clock extends JWindow  implements ActionListener, MouseListener, MouseMotionListener, ItemListener {

	public static void main(String [] args) {
		new Clock();
	}

	private int width = 200;
	private int hight = 200;
	private String fontName = Font.SERIF;
	private int fontStyle = Font.PLAIN;
	private int fontSize = 15;
	private TimePanel tp = new TimePanel();
	//private BasePanel bp = new BasePanel();
	private MouseEvent start;

	MyPopupMenu popup = new MyPopupMenu("Property");

	Clock() {
		super(new JFrame());
		com.sun.awt.AWTUtilities.setWindowOpaque(this, false);

		setFont(new Font(fontName, fontStyle, fontSize));
		add(tp, BorderLayout.CENTER);

		setSize(width, hight);
		setVisible(true);

		setPupup();
		add(popup);

		tp.addMouseListener(this);
		tp.addMouseMotionListener(this);

		addWindowListener(new MyWindowAdapter());
	}

	public void actionPerformed(ActionEvent e) {
		String selected = e.getActionCommand();
		if (selected.indexOf("Font:") != -1) {
			tp.setFont(selected.split("Font:")[1]);
		} else if(selected.indexOf("FontSize:") !=  -1) {
			tp.setFontSize(Integer.parseInt(selected.split("FontSize:")[1]));;
		} else if(selected.indexOf("文字色:") !=  -1) {
			tp.setColor(selected.split("文字色:")[1]);
		} else if(selected.equals("背景色:透明")) {
			tp.setFlag(false);
		} else if(selected.indexOf("背景色:") !=  -1) {
			tp.setFlag(true);
			tp.setBackColor(selected.split("背景色:")[1]);
		} else if(selected == "exit") {
			System.exit(0);
		} else if(selected == "アナログ") {
			tp.setDigitalFlag(false);
		} else if(selected == "デジタル") {
			tp.setDigitalFlag(true);
		} else
			System.out.println(e.getActionCommand());
	}


	public void setMenuItem(String item) {
		JMenuItem menuItem = new JMenuItem(item);
		menuItem.addActionListener(this);
		popup.add(menuItem);
	}


	public void setPupup() {

		// digital
		setMenuItem("デジタル");
		setMenuItem("アナログ");

		// font
		setMenuItem("Font:SERIF");
		setMenuItem("Font:SANSERIF");
		setMenuItem("Font:MONOSPACED");

		// fontsize
		setMenuItem("FontSize:20");
		setMenuItem("FontSize:25");
		setMenuItem("FontSize:30");
		setMenuItem("FontSize:35");

		// 文字カラー
		setMenuItem("文字色:RED");
		setMenuItem("文字色:BLUE");
		setMenuItem("文字色:BLACK");
		setMenuItem("文字色:WHITE");

		// 背景
		setMenuItem("背景色:RED");
		setMenuItem("背景色:BLUE");
		setMenuItem("背景色:BLACK");
		setMenuItem("背景色:WHITE");
		setMenuItem("背景色:透明");

		//exit
		setMenuItem("exit");
	}

	public TimePanel getMyCanvas(){
		return tp;
	}

	public void setSize(int x, int y){
		this.width = x;
		this.hight = y;
		super.setSize(width, hight);

	}

	public void mouseDragged(MouseEvent e) {
		Point eventLocationOnScreen = e.getLocationOnScreen();
   	    setLocation(eventLocationOnScreen.x - start.getX(),	eventLocationOnScreen.y - start.getY());
	}

	public void mouseMoved(MouseEvent e) {
		showPopup(e);
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
		showPopup(e);
	}

	public void mouseEntered(MouseEvent e) {
		showPopup(e);
	}

	public void mouseExited(MouseEvent e) {
		showPopup(e);
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void showPopup(MouseEvent e){
		if (e.isPopupTrigger()) {
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}

class MyWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

package ch02.ex02_01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Clock extends JFrame  implements ActionListener{

	public static void main(String [] args) {
		new Clock();
	}

	private int width = 180;
	private int hight = 120;
	private String fontName = Font.SERIF;
	private int fontStyle = Font.PLAIN;
	private int fontSize = 15;
	private MyPanel mp = new MyPanel();

	Clock() {
		super("Clock");
		setFont(new Font(fontName, fontStyle, fontSize));
		add(mp, BorderLayout.CENTER);
		setSize(width, hight);
		setResizable(false);
		setVisible(true);
		createMenu();
		addWindowListener(new MyWindowAdapter());
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getActionCommand() == "RED") {
			mp.setColor("RED");
		} else if (e.getActionCommand() == "BLUE") {
			mp.setColor("BLUE");
		} else if (e.getActionCommand() == "BLACK") {
			mp.setColor("BLACK");
		} else if (e.getActionCommand() == "WHITE") {
			mp.setColor("WHITE");
		} else if (e.getActionCommand() == "BRED") {
			mp.setBackColor("RED");
		} else if (e.getActionCommand() == "BBLUE") {
			mp.setBackColor("BLUE");
		} else if (e.getActionCommand() == "BWHITE") {
			mp.setBackColor("WHITE");
		} else if (e.getActionCommand() == "BBLACK") {
			mp.setBackColor("BLACK");
		} else if (e.getActionCommand() == "25") {
			mp.setFontSize(25);
			setSize(25 * 6, 25 * 4);
		} else if (e.getActionCommand() == "30") {
			mp.setFontSize(30);
			setSize(30 * 6, 30 * 4);
		} else if (e.getActionCommand() == "35") {
			mp.setFontSize(35);
			setSize(35 * 6, 35 * 4);
		} else if (e.getActionCommand() == "40") {
			mp.setFontSize(40);
			setSize(40 * 6, 40 * 4);
		} else if (e.getActionCommand() == "45") {
			mp.setFontSize(45);
			setSize(45 * 6, 45 * 4);
		} else if (e.getActionCommand() == "50") {
			mp.setFontSize(50);
			setSize(50 * 6, 50 * 4);
		} else if (e.getActionCommand() == "SERIF") {
			mp.setFont("SERIF");
		} else if (e.getActionCommand() == "SANS_SERIF") {
			mp.setFont("SANS_SERIF");
		} else if (e.getActionCommand() == "MONOSPACED") {
			mp.setFont("MONOSPACED");
		} else
			System.out.println(e.getActionCommand());
	}

	public void createMenu(){
		JMenuBar mb = setMenuBar();

		JMenu m = setMenu(mb, "menu");

		setColor(m);
		setBackColor(m);
		setFont(m);
		setFontSize(m);
	}

	public void setColor(JMenu m) {
		JMenu color = new JMenu("文字色");

		JMenuItem red = new JMenuItem("RED");
		JMenuItem blue = new JMenuItem("BLUE");
		JMenuItem white = new JMenuItem("WHITE");
		JMenuItem black = new JMenuItem("BLACK");

		color.add(red);
		color.add(blue);
		color.add(white);
		color.add(black);

		m.add(color);

		red.addActionListener(this);
		blue.addActionListener(this);
		white.addActionListener(this);
		black.addActionListener(this);

	}

	public void setBackColor(JMenu m) {
		JMenu color = new JMenu("背景色");

		JMenuItem red = new JMenuItem("RED");
		JMenuItem blue = new JMenuItem("BLUE");
		JMenuItem white = new JMenuItem("WHITE");
		JMenuItem black = new JMenuItem("BLACK");

		color.add(red);
		color.add(blue);
		color.add(white);
		color.add(black);

		m.add(color);

		red.setActionCommand("BRED");
		red.addActionListener(this);
		blue.setActionCommand("BBLUE");
		blue.addActionListener(this);
		white.setActionCommand("BWHITE");
		white.addActionListener(this);
		black.setActionCommand("BBLACK");
		black.addActionListener(this);

	}

	public void setFont(JMenu m) {
		JMenu font = new JMenu("フォント");

		JMenuItem serif = new JMenuItem("SERIF");
		JMenuItem sans = new JMenuItem("SANS_SERIF");
		JMenuItem mono = new JMenuItem("MONOSPACED");

		font.add(serif);
		font.add(sans);
		font.add(mono);

		m.add(font);

		serif.addActionListener(this);
		sans.addActionListener(this);
		mono.addActionListener(this);
	}

	public void setFontSize(JMenu m) {
		JMenu fsize = new JMenu("フォントサイズ");

		JMenuItem _25 = new JMenuItem("25");
		JMenuItem _30 = new JMenuItem("30");
		JMenuItem _35 = new JMenuItem("35");
		JMenuItem _40 = new JMenuItem("40");
		JMenuItem _45 = new JMenuItem("45");
		JMenuItem _50 = new JMenuItem("50");

		fsize.add(_25);
		fsize.add(_30);
		fsize.add(_35);
		fsize.add(_40);
		fsize.add(_45);
		fsize.add(_50);

		m.add(fsize);

		_25.addActionListener(this);
		_30.addActionListener(this);
		_35.addActionListener(this);
		_40.addActionListener(this);
		_45.addActionListener(this);
		_50.addActionListener(this);
	}

	public MyPanel getMyCanvas(){
		return mp;
	}

	public JMenuBar setMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		return menuBar;
	}

	public JMenu setMenu(JMenuBar menuBar, String item) {
		JMenu menu = new JMenu(item);
		menu.addActionListener(this);
		menuBar.add(menu);
		return menu;
	}

	public JMenu setMenu(JMenu menuBar, String item) {
		JMenu menu = new JMenu(item);
		menu.addActionListener(this);
		menuBar.add(menu);
		return menu;
	}

	public JMenuItem setMenuItem(JMenu menu, String item) {
		JMenuItem menuItem = new JMenuItem(item);
		menuItem.addActionListener(this);
		menu.add(menuItem);
		return menuItem;
	}

	public void setSize(int x, int y){
		this.width = x;
		this.hight = y;
		super.setSize(width, hight);

	}

}

class MyWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
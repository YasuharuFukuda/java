import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.text.Style;


public class Clock extends Frame  implements ActionListener{

	public static void main(String [] args) {
		new Clock();
	}

	//背景
	private Color bColor = Color.BLACK;

	//windowのサイズ
	private int width = 180;
	private int hight = 120;

	//menuのフォント設定
	private String fontName = Font.SERIF;
	private int fontStyle = Font.PLAIN;
	private int fontSize = 15;

	private MyCanvas mc;

	// ダイアログの構成
	private MyDialog dlg;
	private Button b1;

	Clock() {
		super("Clock");
		defaultClock();
		MenuBar menuBar = setMenuBar();
		Menu menu = setMenu(menuBar, "menu");
		setResizable(false);
		setProperty(menu);
	}

	public void defaultClock() {
		setBackground(bColor);
		setSize(width, hight);
		setLayout(new BorderLayout());
		setFont(new Font(fontName, fontStyle, fontSize));
		mc = new MyCanvas();
		add(mc, BorderLayout.CENTER);
		setVisible(true);
		addWindowListener(new MyWindowAdapter());
	}

	public void repaint(MyCanvas mc){
		setBackground(bColor);
		setSize(width, hight);
		setLayout(new BorderLayout());
		setFont(new Font(fontName, fontStyle, fontSize));
		add(mc, BorderLayout.CENTER);
		setVisible(true);
		addWindowListener(new MyWindowAdapter());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Dialog") {
			displayDialog();
		} else if (e.getActionCommand() == "OK") {
			mc.setFontSize(dlg.getFontSize());
			mc.setFont(dlg.getCFont());
			mc.setColor(dlg.getCColor());
			mc.setLayout(dlg.getFontSize(), dlg.getFontSize() * 2);
			setBackColor(dlg.getBackColor());
			this.width = dlg.getFontSize() * 6;
			this.hight = dlg.getFontSize() * 4;
			repaint(mc);
		} else
			System.out.println(e.getActionCommand());
	}

	public MenuBar setMenuBar() {
		//menubar
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);
		return menuBar;
	}

	public Menu setMenu(MenuBar menuBar, String item) {
		Menu menu = new Menu(item);
		menu.addActionListener(this);
		menuBar.add(menu);
		return menu;
	}

	public Menu setMenu(Menu menuBar, String item) {
		Menu menu = new Menu(item);
		menu.addActionListener(this);
		menuBar.add(menu);
		return menu;
	}

	public MenuItem setMenuItem(Menu menu, String item) {
		MenuItem menuItem = new MenuItem(item);
		menuItem.addActionListener(this);
		menu.add(menuItem);
		return menuItem;
	}

	public void setFont(Menu menu) {
		Menu menuFont = setMenu(menu, "Font");
		setMenuItem(menuFont, FontList.SERIF.name);
		setMenuItem(menuFont, FontList.SANSERIF.name);
		setMenuItem(menuFont, FontList.MONOSPACED.name);
	}

	public void setProperty(Menu menu) {
		Menu menuProperty = setMenu(menu, "Property");
		setMenuItem(menuProperty, "Dialog");
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

	public void displayDialog() {
		dlg = new MyDialog(this);
		b1 = new Button("OK");

		b1.addActionListener(this);
		dlg.add(b1);

        dlg.setVisible(true);
	}
}

class MyWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
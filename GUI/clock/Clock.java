package clock;
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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

	private String bColor = Pref.getFlameColor();
	private int width = 180;
	private int hight = 120;
	private String fontName = Font.SERIF;
	private int fontStyle = Font.PLAIN;
	private int fontSize = 15;
	private MyCanvas mc = new MyCanvas();
	private MyDialog dlg;

	Clock() {
		super("Clock");
		setLocation(Pref.getFinishX(), Pref.getFinishY());

		setFont(new Font(fontName, fontStyle, fontSize));
		add(mc, BorderLayout.CENTER);

		MenuBar menuBar = setMenuBar();
		Menu menu = setMenu(menuBar, "menu");
		setProperty(menu);

		ok(null);

		setResizable(false);
		setVisible(true);
		addWindowListener(new MyWindowAdapter());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Dialog") {
			displayDialog();
		} else if (e.getActionCommand() == "OK") {
			ok(dlg);
			Pref.save(dlg.getBackColor(), dlg.getCColor(), dlg.getCFont(), String.valueOf(dlg.getFontSize()));
		} else if (e.getActionCommand() == "Cancel") {
			dlg.paint(this);
		} else
			System.out.println(e.getActionCommand());
	}

	public void ok(MyDialog d){
		if( d != null){
			mc.setFontSize(Integer.parseInt(d.getFontSize()));
			mc.setFont(d.getCFont());
			mc.setColor(d.getCColor());
			setBackColor(d.getBackColor());
		} else {
			setBackColor(bColor);
		}
		setSize(mc.getFontSize() * 6, mc.getFontSize() * 4);
		mc.setLayout(mc.getFontSize() * 6, mc.getFontSize() * 2);
	}

	public MenuBar setMenuBar() {
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
		for (ColorList c : ColorList.values()){
			if(c.name.equals(color)){
				this.bColor = color;
				setBackground(c.color);
				break;
			}
		}
	}

	public void setSize(int x, int y){
		this.width = x;
		this.hight = y;
		super.setSize(width, hight);

	}

	public String getBackGroundColor() {
		return bColor;
	}

	public void displayDialog() {
		dlg = new MyDialog(this);
        dlg.setVisible(true);
	}

	public MyCanvas getMyCanvas(){
		return mc;
	}
}

class MyWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		Pref.saveLayout(e.getComponent().getX(), e.getComponent().getY());
		System.exit(0);
	}
}
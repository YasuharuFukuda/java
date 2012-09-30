package ch02.ex02_01;
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

import javax.swing.JFrame;
import javax.swing.text.Style;


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
		addWindowListener(new MyWindowAdapter());
	}

	public void actionPerformed(ActionEvent e) {
	}


	public MyPanel getMyCanvas(){
		return mp;
	}
}

class MyWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
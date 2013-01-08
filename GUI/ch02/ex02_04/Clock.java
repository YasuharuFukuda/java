package ch02.ex02_04;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JWindow;

public class Clock extends JWindow  implements ActionListener, MouseListener, MouseMotionListener, ItemListener {

	public static void main(String [] args) {
		new Clock();
	}

	private int width = 300;
	private int hight = 300;
	private TimePanel tp = new TimePanel();
	private MouseEvent start;

	MyPopupMenu popup = new MyPopupMenu("Property");
	MyDialog dlg = new MyDialog(this);

	Clock() {
		super(new JFrame());
		com.sun.awt.AWTUtilities.setWindowOpaque(this, false);

		setLocation(Pref.getFinishX(), Pref.getFinishY());

		add(tp, BorderLayout.CENTER);

		setSize(width, hight);
		setVisible(true);

		setPupup();
		add(popup);

		tp.addMouseListener(this);
		tp.addMouseMotionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String selected = e.getActionCommand();
		if (selected == "ダイアログ") {
			displayDialog();
		} else if(selected == "exit") {
			Pref.saveLayout(getX(), getY());
			Pref.save(tp.getBColor(), tp.getSColor(), tp.getFontName(), String.valueOf(tp.getFontSize()));
			System.exit(0);
		} else if(selected == "アナログ") {
			tp.setDigitalFlag(false);
		} else if(selected == "デジタル") {
			tp.setDigitalFlag(true);
		} else if (e.getActionCommand() == "OK") {
			ok(dlg);
			dlg.setVisible(false);
		} else if (e.getActionCommand() == "Cancel") {
			dlg.setVisible(false);
		} else
			System.out.println(e.getActionCommand());
	}

	public void ok(MyDialog d){
		if( d != null){
			tp.setFontSize(Integer.parseInt(d.getFontSize()));
			tp.setFont(d.getCFont());
			tp.setColor(d.getCColor());

			if(d.getBackColor().equals("透明"))
				tp.setFlag(false);
			else {
				tp.setFlag(true);
				tp.setBackColor(d.getBackColor());
			}

			if(d.isDigital())
				tp.setDigitalFlag(true);
			else
				tp.setDigitalFlag(false);

		}
	}

	public void setMenuItem(String item) {
		JMenuItem menuItem = new JMenuItem(item);
		menuItem.addActionListener(this);
		popup.add(menuItem);
	}


	public void setPupup() {

		// dialog
		setMenuItem("ダイアログ");

		//exit
		setMenuItem("exit");
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
		//showPopup(e);
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
		int btn = e.getButton();
    	if (btn == MouseEvent.BUTTON3) {
    		popup.show(this , e.getX() , e.getY());
    	}

	}

	public void mouseEntered(MouseEvent e) {
		int btn = e.getButton();
    	if (btn == MouseEvent.BUTTON3) {
    		popup.show(this , e.getX() , e.getY());
    	}

	}

	public void mouseExited(MouseEvent e) {
		int btn = e.getButton();
    	if (btn == MouseEvent.BUTTON3) {
    		popup.show(this , e.getX() , e.getY());
    	}
	}
	public void itemStateChanged(ItemEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void showPopup(MouseEvent e){
		if (e.isPopupTrigger()) {
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	public String getBackGroundColor() {
		return tp.getBColor();
	}

	public String getColor() {
		return tp.getSColor();
	}

	public int getFontSize() {
		return tp.getFontSize();
	}

	public String getFontName() {
		return tp.getFontName();
	}

	public void displayDialog() {
		dlg = new MyDialog(this);
        dlg.setVisible(true);
	}

	public boolean isDigital() {
		return tp.getsDigitalFlag();
	}

}

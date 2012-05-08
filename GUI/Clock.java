import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
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

	enum FontList {
		SERIF("SERIF", Font.SERIF),
		SANSERIF("SANS_SERIF", Font.SANS_SERIF),
		MONOSPACED("MONOSPACED", Font.MONOSPACED);

		String name;
		String fontName;
		FontList(String name, String fontName) {
			this.name = name;
			this.fontName = fontName;
		}
	}

	enum FontSizeList {
		TEN("10", 10),
		FIFTEEN("15", 15),
		TWENTY("20", 20),
		TWENTYFIVE("25", 25),
		THIRTY("30", 30);

		int size;
		String name;

		FontSizeList(String name, int size){
			this.size = size;
			this.name = name;
		}
	}

	//背景
	private Color color = Color.BLACK;

	//windowのサイズ
	private int width = 200;
	private int hight = 100;

	//menuのフォント設定
	private String fontName = Font.SERIF;
	private int fontStyle = Font.PLAIN;
	private int fontSize = 15;

	private MyCanvas mc;

	Clock() {
        super("Clock");

        defaultClock();

        MenuBar menuBar = setMenuBar();
        Menu menu = setMenu(menuBar, "property");
        setFont(menu);
        setFontSize(menu);
    }

	public void defaultClock() {
		setBackground(color);
        setSize(width, hight);
        setLayout(new BorderLayout());
        setFont(new Font(fontName, fontStyle, fontSize));
        mc = new MyCanvas();
        add(mc, BorderLayout.CENTER);
        //show();
        setVisible(true);
        addWindowListener(new MyWindowAdapter());
	}

    public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand() == FontSizeList.TEN.name) {
    		mc.setFontSize(FontSizeList.TEN.size);
    	} else if (e.getActionCommand() == FontSizeList.FIFTEEN.name) {
    		mc.setFontSize(FontSizeList.FIFTEEN.size);
    	} else if (e.getActionCommand() == FontSizeList.TWENTY.name) {
    		mc.setFontSize(FontSizeList.TWENTY.size);
    	} else if (e.getActionCommand() == FontSizeList.TWENTYFIVE.name) {
    		mc.setFontSize(FontSizeList.TWENTYFIVE.size);
    	} else if (e.getActionCommand() == FontSizeList.THIRTY.name) {
        		mc.setFontSize(FontSizeList.THIRTY.size);
    	} else if (e.getActionCommand() == FontList.SERIF.name) {
    		mc.setFont(FontList.SERIF.fontName);
    	} else if (e.getActionCommand() == FontList.SANSERIF.name) {
    		mc.setFont(FontList.SANSERIF.fontName);
    	} else if (e.getActionCommand() == FontList.MONOSPACED.name) {
    		mc.setFont(FontList.MONOSPACED.fontName);
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

    public void setFontSize(Menu menu) {
    	Menu menuFontSize = setMenu(menu, "FontSize");
        setMenuItem(menuFontSize, FontSizeList.TEN.name);
        setMenuItem(menuFontSize, FontSizeList.FIFTEEN.name);
        setMenuItem(menuFontSize, FontSizeList.TWENTY.name);
        setMenuItem(menuFontSize, FontSizeList.TWENTYFIVE.name);
        setMenuItem(menuFontSize, FontSizeList.THIRTY.name);
    }

}

class MyCanvas extends Canvas {

	private Color color = Color.WHITE;
	private String fontName = Font.SERIF;
	private int fontStyle = Font.PLAIN;
	private int fontSize = 20;

    public void paint(Graphics g) {
    	g.setColor(Color.WHITE);
    	g.setFont(new Font(fontName, fontStyle, fontSize));
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
}

class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
       System.exit(0);
    }
}
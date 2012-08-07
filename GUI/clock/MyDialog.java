package clock;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class MyDialog extends Dialog implements ActionListener {
	private Choice cSize;
	private Choice cFont;
	private Choice cColor;
	private Choice cBackColor;
	private Button bo;
	private Button bc;
	private GridBagLayout gbl = new GridBagLayout();


	MyDialog(Frame owner) {
		super(owner);
		setLocation(owner.getX() + 500, owner.getY());
		paint((Clock)owner);
		addWindowListener(new MyWindowAdapter2());
	}

	void paint(Clock owner) {
		setLayout(gbl);

		Label l1 = new Label("サイズ");
		Label l2 = new Label("フォント");
		Label l3 = new Label("文字色");
		Label l4 = new Label("背景色");

		addComponent(l1, 0, 0, 1, 1, GridBagConstraints.NORTHEAST);
		addComponent(l2, 0, 1, 1, 1, GridBagConstraints.NORTHEAST);
		addComponent(l3, 0, 2, 1, 1, GridBagConstraints.NORTHEAST);
		addComponent(l4, 0, 3, 1, 1, GridBagConstraints.NORTHEAST);

		cSize      = new Choice();
		cColor = new Choice();
		cBackColor = new Choice();
		cFont = new Choice();

		for(FontSizeList fs : FontSizeList.values()) {
			cSize.add(fs.name);
		}

		for(FontList f : FontList.values()) {
			cFont.add(f.name);
		}

		for(ColorList clist : ColorList.values()) {
			cColor.add(clist.name());
			cBackColor.add(clist.name());
		}

		cSize.select(String.valueOf(owner.getMyCanvas().getFontSize()));
		cFont.select(owner.getMyCanvas().getFontName());
		cColor.select(owner.getMyCanvas().getColor());
		cBackColor.select(owner.getBackGroundColor());

		addComponent(cSize,      1, 0, 1, 1, GridBagConstraints.NORTHWEST);
		addComponent(cFont,      1, 1, 1, 1, GridBagConstraints.NORTHWEST);
		addComponent(cColor,     1, 2, 1, 1, GridBagConstraints.NORTHWEST);
		addComponent(cBackColor, 1, 3, 1, 1, GridBagConstraints.NORTHWEST);

		bo = new Button("OK");
		bc = new Button("Cancel");
		bo.setSize(50,30);
		bc.setSize(50,30);
		addComponent(bo, 3, 5, 1, 1, GridBagConstraints.NORTHEAST);
		addComponent(bc, 4, 5, 1, 1, GridBagConstraints.NORTHEAST);
		bo.addActionListener((Clock)owner);
		bc.addActionListener((Clock)owner);
		setSize(400,200);
		setResizable(false);
	}

	void addComponent(Component c, int x, int y, int w, int h, int pos) {
        GridBagConstraints gbc = new GridBagConstraints();
        //gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = pos;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        gbl.setConstraints(c, gbc);
        add(c);

	}

    void addTextArea(TextField t, int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbl.setConstraints(t, gbc);
        add(t);
    }


    void addButton(Button b, int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbl.setConstraints(b, gbc);
        add(b);
    }

    void addLabel(Label l, int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.EAST;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbl.setConstraints(l, gbc);
        add(l);
    }

    public void actionPerformed(ActionEvent e) {
        hide();
    }

    public String getCFont(){
    	return cFont.getSelectedItem();
    }

    public String getCColor(){
    	return cColor.getSelectedItem();
    }

    public String getBackColor(){
    	return cBackColor.getSelectedItem();
    }

    public String getFontSize(){
    	return cSize.getSelectedItem();
    }
}

class MyWindowAdapter2 extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		e.getWindow().dispose();
	}
}
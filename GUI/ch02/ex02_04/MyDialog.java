package ch02.ex02_04;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JWindow;

public class MyDialog extends JDialog implements ActionListener  {
	private JComboBox cSize;
	private JComboBox cFont;
	private JComboBox cColor;
	private JComboBox cBackColor;
	private Button bo;
	private Button bc;

	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton an = new JRadioButton("アナログ");
	private JRadioButton di = new JRadioButton("デジタル");

	private GridBagLayout gbl = new GridBagLayout();
	private String[] fonts = {"SERIF","SANS_SERIF", "MONOSPACED" };
	private String[] fontSizes = {"25", "30", "35" };
	private ColorLabel clRed = new ColorLabel("RED", Color.RED);
	private ColorLabel clBlue = new ColorLabel("BLUE", Color.BLUE);
	private ColorLabel clBlack = new ColorLabel("BLACK", Color.BLACK);
	private ColorLabel clWhite = new ColorLabel("WHITE", Color.WHITE);
	private ColorLabel none = new ColorLabel("透明", Color.WHITE);

	MyDialog(JWindow owner) {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocation(owner.getX() + 330, owner.getY());
		bg.add(an);
		bg.add(di);
		paint((Clock)owner);
	}

	private DefaultComboBoxModel createColorModel() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement(clRed);
		model.addElement(clBlue);
		model.addElement(clBlack);
		model.addElement(clWhite);
		return model;
	}

	private DefaultComboBoxModel createColorModelB() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement(clRed);
		model.addElement(clBlue);
		model.addElement(clBlack);
		model.addElement(clWhite);
		model.addElement(none);
		return model;
	}

	private ColorLabel getColorLabel(String c) {
		if(c.equals("RED"))
			return clRed;
		else if(c.equals("BLUE"))
			return clBlue;
		else if(c.equals("BLACK"))
			return clBlack;
		else
			return clWhite;
	}

	void paint(Clock owner) {
		setLayout(gbl);

		addComponent(an, 0, 0, 1, 1, GridBagConstraints.NORTHEAST);
		addComponent(di, 1, 0, 1, 1, GridBagConstraints.NORTHEAST);

		if (owner.isDigital() == true)
			di.setSelected(true);
		else
			an.setSelected(true);

		Label l1 = new Label("サイズ");
		Label l2 = new Label("フォント");
		Label l3 = new Label("文字色");
		Label l4 = new Label("背景色");

		addComponent(l1, 0, 1, 1, 1, GridBagConstraints.NORTHEAST);
		addComponent(l2, 0, 2, 1, 1, GridBagConstraints.NORTHEAST);
		addComponent(l3, 0, 3, 1, 1, GridBagConstraints.NORTHEAST);
		addComponent(l4, 0, 4, 1, 1, GridBagConstraints.NORTHEAST);

		cSize      = new JComboBox(fontSizes);
		cFont = new JComboBox(fonts);
		cColor = new JComboBox(createColorModel());
		cBackColor = new JComboBox(createColorModelB());

		MyCellRenderer renderer = new MyCellRenderer();
		cBackColor.setRenderer(renderer);
		cColor.setRenderer(renderer);

		cSize.setSelectedItem(String.valueOf(owner.getFontSize()));
		cFont.setSelectedItem(owner.getFontName());
		cColor.setSelectedItem(getColorLabel(owner.getColor()));
		cBackColor.setSelectedItem(getColorLabel(owner.getBackGroundColor()));

		addComponent(cSize,      1, 1, 1, 1, GridBagConstraints.NORTHWEST);
		addComponent(cFont,      1, 2, 1, 1, GridBagConstraints.NORTHWEST);
		addComponent(cColor,     1, 3, 1, 1, GridBagConstraints.NORTHWEST);
		addComponent(cBackColor, 1, 4, 1, 1, GridBagConstraints.NORTHWEST);

		bo = new Button("OK");
		bc = new Button("Cancel");
		bo.setSize(50,30);
		bc.setSize(50,30);
		addComponent(bo, 3, 6, 1, 1, GridBagConstraints.NORTHEAST);
		addComponent(bc, 4, 6, 1, 1, GridBagConstraints.NORTHEAST);
		bo.addActionListener((Clock)owner);
		bc.addActionListener((Clock)owner);
		setSize(400,200);
		setResizable(false);
	}

	void addComponent(Component c, int x, int y, int w, int h, int pos) {
		GridBagConstraints gbc = new GridBagConstraints();
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

	public String getCFont(){
		return (String)cFont.getSelectedItem();
	}

	public String getCColor(){
		ColorLabel cl = (ColorLabel)cColor.getSelectedItem();
		return cl.getText();
	}

	public String getBackColor(){
		ColorLabel cl = (ColorLabel)cBackColor.getSelectedItem();
		return cl.getText();
	}

	public String getFontSize(){
		return (String)cSize.getSelectedItem();
	}

	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}

	public boolean isDigital(){
		if(di.isSelected())
			return true;
		else
			return false;
	}
}

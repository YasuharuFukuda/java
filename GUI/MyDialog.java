import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MyDialog extends Dialog implements ActionListener {
	private TextField tSize;
	private Label lSize;
	private Label lFont;
	private Label lColor;
	private Label lBackColor;
	private Choice cFont;
	private Choice cColor;
	private Choice cBackColor;
	private Button b1;

    MyDialog(Frame owner) {
        super(owner);

		tSize      = new TextField("30", 10);
		lSize      = new Label("Size                                                  ");
		lFont      = new Label("Font                                                  ");
		lColor     = new Label("Color                                                 ");
		lBackColor = new Label("BC                                                    ");
		cColor = new Choice();
		cColor.setSize(50, 50);
		cBackColor = new Choice();
		cFont = new Choice();

		for(FontList f : FontList.values()) {
			cFont.add(f.name);
		}

		for(ColorList clist : ColorList.values()) {
			cColor.add(clist.name());
			cBackColor.add(clist.name());
		}

		setSize(250, 300);
		add(lSize, BorderLayout.WEST);
		add(tSize, BorderLayout.EAST);

		add(lFont);
		add(cFont);


		add(lColor);
		add(cColor);

		add(lBackColor);
		add(cBackColor);

		setResizable(false);

        setLayout(new FlowLayout());
        setTitle("Property");

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

    public int getFontSize(){
    	return Integer.parseInt(tSize.getText());
    }


}
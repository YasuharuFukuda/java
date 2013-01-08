package ch02.ex02_04;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class MyCellRenderer implements ListCellRenderer {

	JLabel label;

	public MyCellRenderer() {
		label = new JLabel();
		label.setOpaque(true);
	}

	public Component getListCellRendererComponent(
			JList list,
			Object value,
			int index,
			boolean isSelected,
			boolean cellHasFocus){

		ColorLabel data = (ColorLabel)value;

		label.setText(data.getText());
		label.setBackground(data.getIcon());

		return label;
	}
}

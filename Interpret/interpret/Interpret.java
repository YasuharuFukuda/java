package interpret;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Interpret extends Frame  implements ActionListener{

	private static final long serialVersionUID = 1L;

	public static void main(String [] args) {
		new Interpret();
	}

	//背景
	private Color bColor = Color.WHITE;

	//windowのサイズ
	private int width = 1000;
	private int hight = 800;

	//menuのフォント設定
	private String fontName = Font.SERIF;
	private int fontStyle = Font.PLAIN;
	private int fontSize = 15;
	private TextField tcl = new TextField();

	private Label lcl = new Label("class");
	private Label lo = new Label("object");
	private Label lf = new Label("field");
	private Label lm = new Label("method");
	private Label lc = new Label("constructor");
	private Label le = new Label("Error occured");

	private Label lobjName;
	private Label lerrorName;

	private Button bcreate = new Button("create!");
	private Button bf = new Button("fields");
	//private Button bc = new Button("constructors");
	private Button bm = new Button("methods");

	private Object createdObject;
	private List<Field> fields;

	private List<Method> methods;
	private List<Object> results = new ArrayList<Object>();

	private String status = "beforeCreate";

	private TextArea[] tas;

	private int page = 1;

	private int items = 5;

	Interpret() {
		super("Interpret");
		setLayout(null);
		setResizable(false);
		setVisible(true);

		defaultInterpret();

		addWindowListener(new MyWindowAdapter());
	}

	public void defaultInterpret(){
		removeAll();
		setBackground(bColor);
		setSize(width, hight);
		setFont(new Font(fontName, fontStyle, fontSize));

		add(lcl);
		add(tcl);
		add(bcreate);

		lcl.setBounds(20,40,30,20);
		tcl.setBounds(20,80,200,30);
		bcreate.setBounds(20, 120, 100, 30);

		bcreate.addActionListener(this);

	}

	public void createObject() {
		removeAll();

		lobjName = new Label(createdObject.toString());

		add(lo);
		add(lobjName);

		add(bf);
		add(bm);
//		add(bc);

		lo.setBounds(20,40, 200, 20);
		lobjName.setBounds(20,80,500,30);
		bf.setBounds(20, 120, 200, 30);
		bm.setBounds(20, 160, 200, 30);
//		bc.setBounds(20, 200, 200, 30);

		bf.addActionListener(this);
		bm.addActionListener(this);
//		bc.addActionListener(this);

		status = "created";

	}

	public void paintFields(){
		removeAll();
		fields = Classoperator.getFields(createdObject);
		add(lf);
		lf.setBounds(20, 40, 200, 30);

		Button bb = new Button("back");
		add(bb);
		bb.setBounds(210, 40, 200, 30);
		bb.addActionListener(this);

		tas = new TextArea[fields.size()];

		int count = 1;

		int max;
		if(fields.size() > items * page) {
			max = items * page;
		} else {
			max = fields.size();
		}

		for(int j = (page - 1) * items; j < max; j++){
			Field f = fields.get(j);
			f.setAccessible(true);

			String[] fs = f.toString().split(" ");
			String typeName = spliteLast(fs[fs.length - 2], "\\.");

			Object value = null;

			try {
				value = f.get(createdObject);
			} catch (IllegalArgumentException e) {
				paintError(e.getMessage());
			} catch (IllegalAccessException e) {
				paintError(e.getMessage());
			}

			Label lvalue = null;
			if(value == null) {
				lvalue = new Label("value: = null");
			} else {
				lvalue = new Label("value: = " + value.toString());
			}
			add(lvalue);
			lvalue.setBounds(20, 40 + 90 * count, 100, 30);

			Label label = new Label(f.toString());
			add(label);
			label.setBounds(lvalue.getX() + lvalue.getWidth() + 30, 40 + 90 * count, 500, 30);

			if(typeName.equals("String") || typeName.equals("boolean") || typeName.equals("byte") || typeName.equals("char") ||
					typeName.equals("short") || typeName.equals("int") || typeName.equals("long") || typeName.equals("float") || typeName.equals("double")){

				tas[j] = new TextArea();
				add(tas[j]);
				tas[j].setBounds(20,  90 + 90 * count, 200, 30 );


				Button b = new Button("modify");
				b.setActionCommand("modify" + (j));
				b.addActionListener(this);
				add(b);
				b.setBounds(250, 90 + 90 * count, 50, 30);
			}

			count++;
		}

		if(fields.size() > page * items){
			Button bn = new Button("next");
			bn.setActionCommand("nextField");
			add(bn);
			bn.setBounds(100, 590, 50, 30);
			bn.addActionListener(this);
		}

		if(page > 1){
			Button bp = new Button("prev");
			bp.setActionCommand("prevField");
			add(bp);
			bp.setBounds(20, 590, 50, 30);
			bp.addActionListener(this);
		}

		Label p = new Label(page + "/" + (fields.size() / items + 1));
		add(p);
		p.setBounds(180, 590, 50, 30);

		status = "field";
	}

	public void paintMethods(){
		removeAll();
		methods = Classoperator.getMethods(createdObject);

		add(lm);
		lm.setBounds(20, 40, 200, 30);

		Button bb = new Button("back");
		add(bb);
		bb.setBounds(210, 40, 200, 30);
		bb.addActionListener(this);

		tas = new TextArea[methods.size()];

		int count = 1;

		int max;
		if(methods.size() > items * page) {
			max = items * page;
		} else {
			max = methods.size();
		}

		for(int j = (page - 1) * items; j < max; j++){
			Method m = methods.get(j);
			results.add(null);

			Label label = new Label(m.toString());
			add(label);
			label.setBounds(20, 40 + 90 * count, 500, 30);

			Button b = new Button("run");
			b.setActionCommand("run" + (j));
			add(b);
			b.setBounds(20, 90 + 90 * count, 50, 30);
			b.addActionListener(this);

			tas[j] = new TextArea();
			add(tas[j]);
			tas[j].setBounds(b.getX() + b.getWidth() + 20,  90 + 90 * count, 200, 30 );


			if (results.get(j) != null) {
				Label lresult = new Label(results.get(j).toString());
				add(lresult);
				lresult.setBounds(tas[j].getX() + tas[j].getWidth() + 20, 90 + 90 * count, 200, 30);
			}
			count++;
		}
		if(methods.size() > page * items){
			Button bn = new Button("next");
			bn.setActionCommand("nextMethod");
			add(bn);
			bn.setBounds(100, 590, 50, 30);
			bn.addActionListener(this);
		}

		if(page > 1){
			Button bp = new Button("prev");
			bp.setActionCommand("prevMethod");
			add(bp);
			bp.setBounds(20, 590, 50, 30);
			bp.addActionListener(this);
		}

		Label p = new Label(page + "/" + (methods.size() / items + 1));
		add(p);
		p.setBounds(180, 590, 50, 30);

		status = "method";
	}

	public String spliteLast(String str, String split){
		String[] strs = str.split(split);
		return strs[strs.length - 1];
	}

	public void paintError(String cause){
		removeAll();

		lerrorName = new Label(cause);

		add(le);
		add(lerrorName);

		Button bb = new Button("back");
		add(bb);

		le.setBounds(20,40,900,20);
		lerrorName.setBounds(20,80,900,30);
		bb.setBounds(20,120,200,30);

		bb.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "create!") {
			try {
				createdObject = Classoperator.getObject(tcl.getText());
				createObject();
			} catch (ClassNotFoundException e1) {
				paintError(e1.getMessage());
			} catch (InstantiationException e1) {
				paintError(e1.getMessage());
			} catch (IllegalAccessException e1) {
				paintError(e1.getMessage());
			}
		} else if (e.getActionCommand() == "back") {
			if(status.equals("beforeCreate")) {
				defaultInterpret();
			} else if(status.equals("field")) {
				page = 1;
				createObject();
			} else if(status.equals("method")) {
				page = 1;
				createObject();
			}
		} else if (e.getActionCommand() == "fields") {
			paintFields();
		} else if (e.getActionCommand() == "methods") {
			paintMethods();
		} else if (e.getActionCommand().indexOf("modify") == 0) {
			int num = Integer.parseInt(e.getActionCommand().split("modify")[1]);
			if(tas[num].getText() != null){
				try {
					fields.get(num).setAccessible(true);
					Classoperator.setField(createdObject, fields.get(num), tas[num].getText());
					paintFields();
				} catch (IllegalArgumentException e1) {
					paintError(e1.getMessage());
				} catch (IllegalAccessException e1) {
					paintError(e1.getMessage());
				}
			}
		} else if(e.getActionCommand().indexOf("run") == 0) {
			int num = Integer.parseInt(e.getActionCommand().split("run")[1]);
			Method m = methods.get(num);
			m.setAccessible(true);

			String text = tas[num].getText();
			String[] textParams = text.split(",");

			Class[] cs = m.getParameterTypes();
			Object[] params = new Object[cs.length];

			try {
				for(int i = 0; i < cs.length; i++) {
					String tos = cs[i].toString();
					if(tos.matches(".*String.*")) {
						params[i] = textParams[i];
					} else if(tos.matches(".*boolean.*")) {
						params[i] = new Boolean(textParams[i]);
					} else if(tos.matches(".*int.*")) {
						params[i] = new Integer(textParams[i]);
					} else if(tos.matches(".*byte.*")) {
						params[i] = new Byte(textParams[i]);
					} else if(tos.matches(".*char.*")) {
						params[i] = new Character(textParams[i].charAt(0));
					} else if(tos.matches(".*short.*")) {
						params[i] = new Short(textParams[i]);
					} else if(tos.matches(".*long.*")) {
						params[i] = new Long(textParams[i]);
					} else if(tos.matches(".*float.*")) {
						params[i] = new Float(textParams[i]);
					} else if(tos.matches(".*double.*")) {
						params[i] = new Double(textParams[i]);
					} else if(textParams[i].matches(".*\\:.*")){
						String clasType = textParams[i].split("\\:")[0];
						String f = textParams[i].split("\\:")[1];
						params[i] = Class.forName(clasType).getDeclaredField(f).get(null);
					}
				}
			} catch(Exception ee) {
				paintError(ee.getMessage());
			}

			try {
				results.set(num, Classoperator.runMethod(createdObject, m, params));
				paintMethods();
			} catch (IllegalArgumentException e1) {
				paintError(e1.getMessage());
			} catch (IllegalAccessException e1) {
				paintError(e1.getMessage());
			} catch (InvocationTargetException e1) {
				paintError(e1.getMessage());
			}
		} else if (e.getActionCommand() == "nextMethod") {
			page++;
			paintMethods();
		} else if (e.getActionCommand() == "prevMethod") {
			page--;
			paintMethods();
		} else if (e.getActionCommand() == "nextField") {
			page++;
			paintFields();
		} else if (e.getActionCommand() == "prevField") {
			page--;
			paintFields();
		}
	}

	public String toString() {
		return "interpretだよ";
	}

}

class MyWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class Interpret extends Frame  implements ActionListener{

	private static final long serialVersionUID = 1L;

	public static void main(String [] args) {
		new Interpret();
	}

////////////////// 共通設定 ///////////////////////////
	////背景
	private Color backColor = Color.WHITE;
	//windowのサイズ
	private int width = 1000;
	private int hight = 650;

	//フォント設定
	private String fontName = Font.SERIF;
	private int fontStyle = Font.PLAIN;
	private int fontSize = 15;

	private int page = 1;
	private int items = 5;

	private Class<?> cls = null;
	private Object selectedObject = null;

/////////////////// paintTop //////////////////////////
	private Label labelClass = new Label("class");
	private TextField tclassname = new TextField();
	private Button bconst = new Button("constructors");
	private Button bobjs = new Button("objects");
	private Button bcobj = new Button("current object");

////////////////// paintConstructors ///////////////////////
	private Label lcons = new Label("constructor");
	Button bConsToTop = new Button("top");
	private List<Constructor> constructors = new ArrayList<Constructor>();

	private TextArea[] tobjNames;
	private TextArea[] tobjParams;
	private TextArea[] tobjSize;

///////////////// paintObjects ///////////////////////////
	private Label lobjs = new Label("objects");
	private Label[] objectsName = null;
	private Label[] objectsSize = null;
	private Button[] objectsSelect = null;

///////////////// paintObject ///////////////////////////
	private Label lobj = new Label("object");
	private Label[] lobjName;
	private Button[] bf = null;
	private Button[] bm = null;
	private Map<String, Object> objects = new LinkedHashMap<String, Object>();
	private String selectedObjectName = null;
	private Object[] objectList = null;

////////////////  fields  ////////////////////////////
	private Label lfield = new Label("field");
	private List<Field> fields;
	private TextArea[] tasForFields;

///////////////// methods ////////////////////////////
	private Label lmethod = new Label("method");
	private List<Method> methods;
	private List<Object> results = new ArrayList<Object>();
	private TextArea[] tasForMethods;

////////////////// errors //////////////////////////////
	private Label lerror = new Label("Error occured");
	private Label lerrorName;
	private Label lerrorMsg;

	public Interpret() {
		super("Interpret");
		setFont(new Font(fontName, fontStyle, fontSize));
		setBackground(backColor);
		setSize(width, hight);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		paintTop();
		addWindowListener(new MyWindowAdapter());
	}

	public void paintTop(){
		removeAll();

		labelClass.setFont(new Font(Font.SERIF, Font.PLAIN, 25));

		add(labelClass);
		add(tclassname);
		add(bconst);
		add(bobjs);
		add(bcobj);

		labelClass.setBounds(20,40,100,40);
		tclassname.setBounds(20,90,200,30);
		bconst.setBounds(20, 130, 100, 30);
		bobjs.setBounds(20, 180, 100, 30);
		bcobj.setBounds(20, 220, 100, 30);

		bconst.addActionListener(this);
		bobjs.addActionListener(this);
		bcobj.addActionListener(this);

	}

	public void paintConstructors(Class c) {
		removeAll();

		constructors = Classoperator.getConstructor(c);

		Button bb = new Button("top");
		tobjNames = new TextArea[constructors.size()];
		tobjParams = new TextArea[constructors.size()];
		tobjSize = new TextArea[constructors.size()];
		Label name = new Label("Object Name");
		Label arg = new Label("Arguments");
		Label size = new Label("Size");

		lcons.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
		name.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		arg.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		size.setFont(new Font(Font.SERIF, Font.PLAIN, 20));

		add(lcons);
		add(bb);
		add(name);
		add(arg);
		add(size);

		lcons.setBounds(20, 40, 200, 40);
		bb.setBounds(210, 40, 100, 30);
		name.setBounds(90, 90, 150, 30);
		arg.setBounds(310,  90, 150, 30 );
		size.setBounds(530,  90, 150, 30 );

		bb.addActionListener(this);

		int count = 1;
		int max;
		if(constructors.size() > items * page) {
			max = items * page;
		} else {
			max = constructors.size();
		}

		for(int j = (page - 1) * items; j < max; j++){
			Constructor cos = constructors.get(j);

			Label label = new Label(cos.toString());
			Button b = new Button("make");
			tobjNames[j] = new TextArea();
			tobjParams[j] = new TextArea();
			tobjSize[j] = new TextArea();

			add(label);
			add(b);
			add(tobjNames[j]);
			add(tobjParams[j]);
			add(tobjSize[j]);

			label.setBounds(20, 40 + 90 * count, 500, 30);
			b.setBounds(20, 90 + 90 * count, 50, 30);
			tobjNames[j].setBounds(b.getX() + b.getWidth() + 20,  90 + 90 * count, 200, 30 );
			tobjParams[j].setBounds(tobjNames[j].getX() + tobjNames[j].getWidth() + 20,  90 + 90 * count, 200, 30 );
			tobjSize[j].setBounds(tobjParams[j].getX() + tobjParams[j].getWidth() + 20,  90 + 90 * count, 200, 30 );

			b.setActionCommand("make" + (j));
			b.addActionListener(this);

			count++;
		}

		if(constructors.size() > page * items){
			Button bn = new Button("next");
			bn.setActionCommand("nextConstructor");
			add(bn);
			bn.setBounds(100, 590, 50, 30);
			bn.addActionListener(this);
		}

		if(page > 1){
			Button bp = new Button("prev");
			bp.setActionCommand("prevConstructor");
			add(bp);
			bp.setBounds(20, 590, 50, 30);
			bp.addActionListener(this);
		}

		Label p = new Label(page + "/" + ((constructors.size() - 1) / items + 1));
		add(p);
		p.setBounds(180, 590, 50, 30);

	}

	public void paintObjects() {
		removeAll();

		Button btop = new Button("top");
		objectsName = new Label[objects.size()];
		objectsSize = new Label[objects.size()];
		objectsSelect =  new Button[objects.size()];

		lobjs.setFont(new Font(Font.SERIF, Font.PLAIN, 25));

		add(lobjs);
		add(btop);

		lobjs.setBounds(20,40, 100, 20);
		btop.setBounds(210, 40, 200, 30);

		btop.addActionListener(this);

		int count = 1;

		int max;
		if(objects.size() > items * page) {
			max = items * page;
		} else {
			max = objects.size();
		}
		int j = 0;

		for(Map.Entry<String, Object> e : objects.entrySet()) {

			if(j >=  (page -1) * items && j < max){
				Object[] value = (Object[])e.getValue();
				int size = value.length;

				objectsName[count - 1] = new Label(e.getKey());
				objectsSize[count - 1] = new Label(String.valueOf(size));
				objectsSelect[count - 1] = new Button("select");

				add(objectsName[count - 1]);
				add(objectsSize[count - 1]);
				add(objectsSelect[count - 1]);

				objectsName[count - 1].setBounds(20,40 + 90 * count,200,30);
				objectsSize[count - 1].setBounds(objectsName[count - 1].getX() + objectsName[count - 1].getWidth() + 20,40 + 90 * count,30,30);
				objectsSelect[count - 1].setBounds(objectsSize[count - 1].getX() + objectsSize[count - 1].getWidth() + 20 , 40 + 90 * count, 100, 30);

				objectsSelect[count - 1].setActionCommand("select" + e.getKey());

				objectsSelect[count - 1].addActionListener(this);

				count++;
			}
			j++;
		}

		if(objects.size() > page * items){
			Button bn = new Button("next");
			bn.setActionCommand("nextObjects");
			add(bn);
			bn.setBounds(100, 590, 50, 30);
			bn.addActionListener(this);
		}

		if(page > 1){
			Button bp = new Button("prev");
			bp.setActionCommand("nextObjects");
			add(bp);
			bp.setBounds(20, 590, 50, 30);
			bp.addActionListener(this);
		}

		Label p = new Label(page + "/" + ((objects.size() - 1) / items + 1));
		add(p);
		p.setBounds(180, 590, 50, 30);

	}

	public void paintObject() {
		removeAll();

		objectList = (Object[])objects.get(selectedObjectName);

		lobj = new Label(selectedObjectName);
		Button btop = new Button("top");
		lobjName = new Label[objectList.length];
		bf = new Button[objectList.length];
		bm =  new Button[objectList.length];

		add(lobj);
		add(btop);

		lobj.setBounds(20, 40, 200, 40);
		btop.setBounds(210, 40, 200, 30);

		lobj.setFont(new Font(Font.SERIF, Font.PLAIN, 25));

		btop.addActionListener(this);

		int count = 1;

		int max;
		if(objectList.length > items * page) {
			max = items * page;
		} else {
			max = objectList.length;
		}

		for(int i = 0; i < objectList.length; i++) {
			lobjName[count - 1] = new Label(String.valueOf(i));
			add(lobjName[count - 1]);
			lobjName[count - 1].setBounds(20,40 + 90 * count,500,30);

			// fields
			bf[count - 1] = new Button("field");
			bf[count - 1].setActionCommand("field" + String.valueOf(i));
			add(bf[count - 1]);
			bf[count - 1].setBounds(20, 90 + 90 * count, 50, 30);
			bf[count - 1].addActionListener(this);

			// methods
			bm[count - 1] = new Button("method");
			bm[count - 1].setActionCommand("method" +String.valueOf(i));
			add(bm[count - 1]);
			bm[count - 1].setBounds(bf[count - 1].getX() + bf[count - 1].getWidth() + 20 , 90 + 90 * count, 50, 30);
			bm[count - 1].addActionListener(this);

			count++;

		}

		if(objectList.length > page * items){
			Button bn = new Button("next");
			bn.setActionCommand("nextObject");
			add(bn);
			bn.setBounds(100, 590, 50, 30);
			bn.addActionListener(this);
		}

		if(page > 1){
			Button bp = new Button("prev");
			bp.setActionCommand("nextObject");
			add(bp);
			bp.setBounds(20, 590, 50, 30);
			bp.addActionListener(this);
		}

		Label p = new Label(page + "/" + ((objectList.length - 1) / items + 1));
		add(p);
		p.setBounds(180, 590, 50, 30);

	}

	public void paintFields(){
		removeAll();
		fields = Classoperator.getFields(selectedObject);
		add(lfield);
		lfield.setBounds(20, 40, 200, 30);

		Button bb = new Button("top");
		add(bb);
		bb.setBounds(210, 40, 100, 30);
		bb.addActionListener(this);

		Button bo = new Button("objects");
		add(bo);
		bo.setBounds(330, 40, 100, 30);
		bo.addActionListener(this);


		tasForFields = new TextArea[fields.size()];

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
				value = f.get(selectedObject);
			} catch (IllegalArgumentException e) {
				paintError(e);
			} catch (IllegalAccessException e) {
				paintError(e);
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

				tasForFields[j] = new TextArea();
				add(tasForFields[j]);
				tasForFields[j].setBounds(20,  90 + 90 * count, 200, 30 );


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

		Label p = new Label(page + "/" + ((fields.size() - 1) / items + 1));
		add(p);
		p.setBounds(180, 590, 50, 30);
	}

	public void paintMethods(){
		removeAll();
		methods = Classoperator.getMethods(selectedObject);

		add(lmethod);
		lmethod.setBounds(20, 40, 200, 30);

		Button bb = new Button("top");
		add(bb);
		bb.setBounds(210, 40, 100, 30);
		bb.addActionListener(this);

		Button bo = new Button("objects");
		add(bo);
		bo.setBounds(330, 40, 100, 30);
		bo.addActionListener(this);

		tasForMethods = new TextArea[methods.size()];

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

			tasForMethods[j] = new TextArea();
			add(tasForMethods[j]);
			tasForMethods[j].setBounds(b.getX() + b.getWidth() + 20,  90 + 90 * count, 200, 30 );


			if (results.get(j) != null) {
				Label lresult = new Label(results.get(j).toString());
				add(lresult);
				lresult.setBounds(tasForMethods[j].getX() + tasForMethods[j].getWidth() + 20, 90 + 90 * count, 200, 30);
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

		Label p = new Label(page + "/" + ((methods.size() - 1) / items + 1));
		add(p);
		p.setBounds(180, 590, 50, 30);
	}

	public String spliteLast(String str, String split){
		String[] strs = str.split(split);
		return strs[strs.length - 1];
	}

	public void paintError(Throwable e){
		removeAll();

		lerrorName = new Label(e.getClass().toString());
		lerrorMsg = new Label(e.getMessage());
		//lerror = new Label(e.getMessage());

		add(lerror);
		lerror.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
		add(lerrorName);
		add(lerrorMsg);

		Button bb = new Button("top");
		add(bb);

		lerror.setBounds(20,40,900,20);
		lerrorName.setBounds(20,80,900,30);
		lerrorMsg.setBounds(20, 120, 900, 30);
		bb.setBounds(20,160,200,30);

		bb.addActionListener(this);
	}

	public void actionConstructors(){
		try {
			cls = Class.forName(tclassname.getText());
			paintConstructors(cls);
		} catch (ClassNotFoundException e1) {
			paintError(e1);
		}
	}

	public void actionMake(ActionEvent e){
		int num = Integer.parseInt(e.getActionCommand().split("make")[1]);
		Constructor c = constructors.get(num);
		c.setAccessible(true);

		String oname = tobjNames[num].getText();
		String[] oparams = tobjParams[num].getText().split(",");
		int osize = 0;

		try {
			osize = Integer.parseInt(tobjSize[num].getText());
			if(osize < 1)
				return;
		} catch(Exception ee)  {
			paintError(ee);
			return;
		}

		Class[] cs = c.getParameterTypes();
		Object[] params = new Object[cs.length];

		try {
			for(int i = 0; i < cs.length; i++) {
				String tos = cs[i].toString();
				if(tos.matches(".*String.*")) {
					params[i] = oparams[i];
				} else if(tos.matches(".*boolean.*")) {
					params[i] = new Boolean(oparams[i]);
				} else if(tos.matches(".*int.*")) {
					params[i] = new Integer(oparams[i]);
				} else if(tos.matches(".*byte.*")) {
					params[i] = new Byte(oparams[i]);
				} else if(tos.matches(".*char.*")) {
					params[i] = new Character(oparams[i].charAt(0));
				} else if(tos.matches(".*short.*")) {
					params[i] = new Short(oparams[i]);
				} else if(tos.matches(".*long.*")) {
					params[i] = new Long(oparams[i]);
				} else if(tos.matches(".*float.*")) {
					params[i] = new Float(oparams[i]);
				} else if(tos.matches(".*double.*")) {
					params[i] = new Double(oparams[i]);
				} else if(oparams[i].matches(".*\\:.*")){
					String clasType = oparams[i].split("\\:")[0];
					String f = oparams[i].split("\\:")[1];
					params[i] = Class.forName(clasType).getDeclaredField(f).get(null);
				} else if (oparams[i].matches(".*@.*")) {
					String objName =  oparams[i].split("@")[0];
					int n = Integer.parseInt(oparams[i].split("@")[1]);
					Object[] objs = (Object[])objects.get(objName);
					params[i] = objs[n];
				}
			}
		} catch(Exception ee) {
			paintError(ee);
		}

		try {
			Object[] objs = new Object[osize];

			for (int i = 0; i < osize; i++) {
				objs[i] = c.newInstance(params);
			}

			objects.put(oname, objs);
			paintObjects();
		} catch (IllegalArgumentException e1) {
			paintError(e1);
		} catch (InstantiationException e1) {
			paintError(e1);
		} catch (IllegalAccessException e1) {
			paintError(e1);
		} catch (InvocationTargetException e1) {
			paintError(e1.getTargetException());
		}
	}

	public void actionModify(ActionEvent e) {
		int num = Integer.parseInt(e.getActionCommand().split("modify")[1]);
		if(tasForFields[num].getText() != null){
			try {
				fields.get(num).setAccessible(true);
				Classoperator.setField(selectedObject, fields.get(num), tasForFields[num].getText());
				paintFields();
			} catch (IllegalArgumentException e1) {
				paintError(e1);
			} catch (IllegalAccessException e1) {
				paintError(e1);
			}
		}

	}

	public void actionRun(ActionEvent e) {
		int num = Integer.parseInt(e.getActionCommand().split("run")[1]);
		Method m = methods.get(num);
		m.setAccessible(true);

		String text = tasForMethods[num].getText();
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
				} else if (textParams[i].matches(".*@.*")) {
					String objName =  textParams[i].split("@")[0];
					int n = Integer.parseInt(textParams[i].split("@")[1]);
					Object[] objs = (Object[])objects.get(objName);
					params[i] = objs[n];
				}
			}
		} catch(Exception ee) {
			paintError(ee);
		}

		try {
			results.set(num, Classoperator.runMethod(selectedObject, m, params));
			paintMethods();
		} catch (IllegalArgumentException e1) {
			paintError(e1);
		} catch (IllegalAccessException e1) {
			paintError(e1);
		} catch (InvocationTargetException e1) {
			paintError(e1.getTargetException());
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "constructors") {
			page = 1;
			actionConstructors();
		} else if(e.getActionCommand() == "objects") {
			page = 1;
			paintObjects();
		} else if(e.getActionCommand() == "current object") {
			page = 1;
			paintObject();
		} else if(e.getActionCommand() == "object field") {
			page = 1;
			paintFields();
		} else if(e.getActionCommand() == "object method") {
			page = 1;
			paintMethods();
		} else if (e.getActionCommand().indexOf("make") == 0) { //
			page = 1;
			actionMake(e);
		} else if (e.getActionCommand() == "top") {
			page = 1;
			paintTop();
		} else if (e.getActionCommand().indexOf("select") == 0) { //
			page = 1;
			selectedObjectName = e.getActionCommand().split("select")[1];
			paintObject();
		} else if (e.getActionCommand() == "objects") {
			page = 1;
			paintObjects();
		} else if(e.getActionCommand().indexOf("field") == 0) {
			page = 1;
			int num = Integer.parseInt(e.getActionCommand().split("field")[1]);
			selectedObject = objectList[num];
			paintFields();
		} else if(e.getActionCommand().indexOf("method") == 0) {
			page = 1;
			int num = Integer.parseInt(e.getActionCommand().split("method")[1]);
			selectedObject = objectList[num];
			paintMethods();
		} else if (e.getActionCommand().indexOf("modify") == 0) {
			page = 1;
			actionModify(e);
		} else if(e.getActionCommand().indexOf("run") == 0) {
			page = 1;
			actionRun(e);
		} else if (e.getActionCommand() == "nextConstructor") {
			page++;
			paintConstructors(cls);
		} else if (e.getActionCommand() == "prevConstructor") {
			page--;
			paintConstructors(cls);
		} else if (e.getActionCommand() == "nextObjects") {
			page++;
			paintObjects();
		} else if (e.getActionCommand() == "prevObjects") {
			page--;
			paintObjects();
		}  else if (e.getActionCommand() == "nextObject") {
			page++;
			paintObject();
		} else if (e.getActionCommand() == "prevObject") {
			page--;
			paintObject();
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
package reflection.fields;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.*;

@SuppressWarnings("serial")
public class Program extends JFrame {
	public static void main(String[] args) throws Exception {
		Program gui = new Program();
		gui.pack();
		gui.setVisible(true);
	}
	public Program() throws Exception {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		create();
		arrange();
		events();
		reflect();
	}
	private void reflect() throws Exception {
		Class<? extends Program> klass = getClass();
		for(Field f : klass.getDeclaredFields()) {
			if(JComponent.class.isAssignableFrom(f.getType())) {
				JComponent c = (JComponent)f.get(this);
				c.setName(f.getName());
			}
		}
	}
	private void events() {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = ((JComponent)e.getSource()).getName();
				textField.setText("My name is: " + name);
			}
		};
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		button3.addActionListener(listener);
	}
	private void arrange() {
		add(textField,BorderLayout.NORTH);
		JPanel p = new JPanel();
		p.add(button1);
		p.add(button2);
		p.add(button3);
		add(p,BorderLayout.CENTER);
	}
	private void create() {
		button1 = new JButton("BT1");
		button2 = new JButton("BT2");
		button3 = new JButton("BT3");
		textField = new JTextField(20);
	}
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JTextField textField;
}

package functional.guis;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyGui extends JFrame {
    private class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField1.setText("Pushed Via Inner Class");
        }
    }
    public MyGui() {
        super("My First Swing GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupTextfields();
        setupButtons();
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new GridLayout(3,2));
        add(button1);
        add(textField1);
        add(button2);
        add(textField2);
        add(button3);
        add(textField3);
    }

    private void setupButtons() {
        button1 = new JButton("Push Me");
        button1.addActionListener(new MyListener());

        button2 = new JButton("Push Me");
        button2.addActionListener(e -> textField2.setText("Pushed Via Lambda"));

        button3 = new JButton("Push Me");
        button3.addActionListener(this::handleButtonPush);
    }

    private void setupTextfields() {
        textField1 = new JTextField(20);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
    }

    private void handleButtonPush(ActionEvent e) {
    	textField3.setText("Pushed Via Method Ref");
    }
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
}

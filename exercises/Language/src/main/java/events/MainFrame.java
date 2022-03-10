package events;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private JLabel topLabel;
	private JPanel drawingPanel;
	public class MyPanel extends JPanel {
		@Override
		public void paintComponent(Graphics param) {
			super.paintComponent(param);
			
		}	
	}
	public MainFrame() {
		super("Event Handling Program");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		drawingPanel = new MyPanel();
		topLabel = new JLabel("Messages Here...");
		topLabel.setFont(new Font("", Font.BOLD, 16));
		add(topLabel, BorderLayout.NORTH);
		add(drawingPanel, BorderLayout.CENTER);
	}
}

package events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
    private JLabel topLabel;
    private JPanel drawingPanel;
    private int chosenX;
    private int chosenY;

    public class MyPanel extends JPanel {
        @Override
        public void paintComponent(Graphics param) {
            super.paintComponent(param);

            final int startX = chosenX - 10;
            final int startY = chosenY - 10;

            if (startX > 0 || startY > 0) {
                Graphics2D g = (Graphics2D) param;
                g.drawOval(startX, startY, 20, 20);
                g.setColor(Color.BLUE);
                g.fillOval(startX, startY, 20, 20);
                g.setColor(Color.BLACK);
            }
        }
    }

    public class MyMouseListener implements MouseListener, MouseMotionListener {
        public void mouseClicked(MouseEvent e) {
            topLabel.setText("Mouse clicked in panel");
            chosenX = e.getX();
            chosenY = e.getY();
            repaint();
        }

        public void mouseEntered(MouseEvent e) {
            topLabel.setText("Mouse entered panel");
        }

        public void mouseExited(MouseEvent e) {
            topLabel.setText("Mouse exited panel");
        }

        public void mousePressed(MouseEvent e) {
            topLabel.setText("Mouse pressed in panel");
        }

        public void mouseReleased(MouseEvent e) {
            topLabel.setText("Mouse released in panel");
        }

        public void mouseDragged(MouseEvent e) {
            topLabel.setText("Mouse dragged...");
            chosenX = e.getX();
            chosenY = e.getY();
            repaint();
        }

        public void mouseMoved(MouseEvent e) {
        }
    }

    public MainFrame() {
        super("Event Handling Solution");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 250);
        drawingPanel = new MyPanel();
        MyMouseListener listener = new MyMouseListener();
        drawingPanel.addMouseListener(listener);
        drawingPanel.addMouseMotionListener(listener);
        topLabel = new JLabel("Messages Here...");
        topLabel.setFont(new Font("", Font.BOLD, 16));
        add(topLabel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
    }
}

package events;

import javax.swing.*;

public class Program {
    public static void main(String[] args) {
        final MainFrame mf = new MainFrame();
        Runnable r = new Runnable() {
            public void run() {
                mf.setSize(250, 250);
                mf.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }

}

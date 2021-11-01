package GUI;

import javax.swing.*;

public class Welcome {

    private final int WIDTH = 350;
    private final int HEIGHT = 600;

    //Empty Constructor
    public Welcome() {

    }

    //Main Constructor
    public Welcome(String title) {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("https://raw.githubusercontent.com/ionutnoje/oop-project-3/branch_toni/autocheck/images/icon.png");
        frame.setTitle("AutoCheck " + title);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(WIDTH, HEIGHT);

        frame.setVisible(true);
    }
}

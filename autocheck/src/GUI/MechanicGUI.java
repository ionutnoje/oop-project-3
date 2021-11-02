package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MechanicGUI implements ActionListener {


    private final int WIDTH = 1280;
    private final int HEIGHT = 720;

    public String title = "Mechanic";

    Font fontBig = new Font("Eras Bold ITC", Font.BOLD, 28);
    Font fontNormal = new Font("Eras Bold ITC", Font.PLAIN, 20);
    Font fontSmall = new Font("Eras Bold ITC", Font.PLAIN, 18);

    Color darkGreen = new Color(38, 70, 83);
    Color lightGreen = new Color(42, 157, 143);
    Color white = new Color(255, 255, 255);
    Color yellowColor = new Color(233, 196, 106);
    Color labelBg = new Color(244, 162, 97);
    Color buttonBg = new Color(231, 111, 81);

    public JButton checkButton;
    public JButton changeStatusButton;
    public JButton seeAllCarsButton;
    public JButton refreshButton;
    public JButton exitButton;

    //Empty constructor
    public MechanicGUI(){

    }

    //Main constructor
    public MechanicGUI(String mechanicUsername) {
        JFrame frame = new JFrame();

        //GUI Icon
        URL url = null;
        try {
            url = new URL("https://raw.githubusercontent.com/ionutnoje/oop-project-3/branch_toni/autocheck/images/icon.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        BufferedImage img = null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon icon = new ImageIcon(img);
        frame.setIconImage(icon.getImage());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("AutoCheck | " + title);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(WIDTH, HEIGHT);
        frame.getContentPane().setBackground(new Color(38, 70, 83));

        //Labels
        JLabel titleLabel = new JLabel("Hello, " + mechanicUsername + "!");
        titleLabel.setFont(fontBig);
        titleLabel.setForeground(yellowColor);
        titleLabel.setBounds(10, 10, 700, 40);

        JLabel allCars = new JLabel("All Cars: "); //add variable
        allCars.setFont(fontNormal);
        allCars.setForeground(yellowColor);
        allCars.setBounds(10, 80, 200, 40);

        JLabel inOrder = new JLabel("In Order: "); //add variable
        inOrder.setFont(fontNormal);
        inOrder.setForeground(yellowColor);
        inOrder.setBounds(300, 80, 200, 40);

        JLabel inProgress = new JLabel("In Progress: "); //add variable
        inProgress.setFont(fontNormal);
        inProgress.setForeground(yellowColor);
        inProgress.setBounds(600, 80, 200, 40);

        JLabel finished = new JLabel("Finished: "); //add variable
        finished.setFont(fontNormal);
        finished.setForeground(yellowColor);
        finished.setBounds(900, 80, 200, 40);

        //Creating JPanel
        JPanel displayPanel = new JPanel();



        //Adding to frame
        frame.add(titleLabel);
        frame.add(allCars);
        frame.add(inOrder);
        frame.add(inProgress);
        frame.add(finished);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

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

    public int carIdToCheck;

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

        //Buttons
        refreshButton = new JButton();
        refreshButton.setText("REFRESH");
        refreshButton.setFont(fontNormal);
        refreshButton.setBackground(buttonBg);
        refreshButton.setForeground(white);
        refreshButton.setBounds(30, 600, 250, 60);
        refreshButton.setFocusable(false);
        refreshButton.addActionListener(this);

        seeAllCarsButton = new JButton();
        seeAllCarsButton.setText("See all cars");
        seeAllCarsButton.setFont(fontNormal);
        seeAllCarsButton.setBackground(buttonBg);
        seeAllCarsButton.setForeground(white);
        seeAllCarsButton.setBounds(330, 600, 250, 60);
        seeAllCarsButton.setFocusable(false);
        seeAllCarsButton.addActionListener(this);

        exitButton = new JButton();
        exitButton.setText("EXIT");
        exitButton.setFont(fontNormal);
        exitButton.setBackground(buttonBg);
        exitButton.setForeground(white);
        exitButton.setBounds(1080, 600, 150, 60);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        checkButton = new JButton();
        checkButton.setText("CHECK");
        checkButton.setFont(fontNormal);
        checkButton.setBackground(buttonBg);
        checkButton.setForeground(white);
        checkButton.setBounds(400, 10, 150, 60);
        checkButton.setFocusable(false);
        checkButton.addActionListener(this);

        changeStatusButton = new JButton();
        changeStatusButton.setText("CHANGE STATUS");
        changeStatusButton.setFont(fontNormal);
        changeStatusButton.setBackground(buttonBg);
        changeStatusButton.setForeground(white);
        changeStatusButton.setBounds(800, 10, 300, 60);
        changeStatusButton.setFocusable(false);
        changeStatusButton.addActionListener(this);

        //Creating JPanel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(null);
        displayPanel.setBounds(30, 140, 1200,400);
        displayPanel.setBackground(lightGreen);

        //Input text
        JTextField carId = new JTextField();
        carId.setBackground(labelBg);
        carId.setForeground(white);
        carId.setHorizontalAlignment(JTextField.CENTER);
        carId.setFont(fontNormal);
        carId.setBounds(40, 10, 350, 60);
        carId.setBorder(null);

        //Adding to frame
        displayPanel.add(checkButton);
        displayPanel.add(changeStatusButton);
        displayPanel.add(carId);

        frame.add(refreshButton);
        frame.add(seeAllCarsButton);
        frame.add(exitButton);
        frame.add(titleLabel);
        frame.add(allCars);
        frame.add(inOrder);
        frame.add(inProgress);
        frame.add(finished);
        frame.add(displayPanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Refresh button
        if (e.getSource() == refreshButton) {
            System.out.println("refresh");
        }

        //See all cars button
        if (e.getSource() == seeAllCarsButton) {
            System.out.println("see cars");
        }

        //Exit button
        if (e.getSource() == exitButton) {
            System.out.println("exit");
        }

        //Check button
        if (e.getSource() == checkButton) {
            System.out.println("check car");
        }

        //Change status
        if (e.getSource() == changeStatusButton) {
            System.out.println("change status");
        }
    }
}

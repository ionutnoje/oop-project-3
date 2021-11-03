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

public class ClientGUI implements ActionListener {


    private final int WIDTH = 800;
    private final int HEIGHT = 500;

    public String title = "Client";
    public int cars = 0;

    Font fontBig = new Font("Eras Bold ITC", Font.BOLD, 28);
    Font fontNormal = new Font("Eras Bold ITC", Font.PLAIN, 20);
    Font fontSmall = new Font("Eras Bold ITC", Font.PLAIN, 18);

    Color darkGreen = new Color(38, 70, 83);
    Color lightGreen = new Color(42, 157, 143);
    Color white = new Color(255, 255, 255);
    Color yellowColor = new Color(233, 196, 106);
    Color labelBg = new Color(244, 162, 97);
    Color buttonBg = new Color(231, 111, 81);

    public JButton seeAllCarsButton;
    public JButton refreshButton;
    public JButton addCarsButton;


    //Empty constructor
    public ClientGUI(){

    }

    //Main constructor
    public ClientGUI(String clientUsername) {
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
        JLabel titleLabel = new JLabel("Hello, " + clientUsername + "!");
        titleLabel.setFont(fontBig);
        titleLabel.setForeground(yellowColor);
        titleLabel.setBounds(10, 10, 700, 40);

        JLabel bottomText = new JLabel("You currently have " + cars + " cars at the mechanic."); //add variable
        bottomText.setFont(fontNormal);
        bottomText.setForeground(yellowColor);
        bottomText.setBounds(10, 400, 800, 40);


        //Buttons
        addCarsButton = new JButton();
        addCarsButton.setText("ADD CAR");
        addCarsButton.setFont(fontNormal);
        addCarsButton.setBackground(buttonBg);
        addCarsButton.setForeground(white);
        addCarsButton.setBounds(30, 200, 150, 60);
        addCarsButton.setFocusable(false);
        addCarsButton.addActionListener(this);

        seeAllCarsButton = new JButton();
        seeAllCarsButton.setText("SEE CARS");
        seeAllCarsButton.setFont(fontNormal);
        seeAllCarsButton.setBackground(buttonBg);
        seeAllCarsButton.setForeground(white);
        seeAllCarsButton.setBounds(230, 200, 150, 60);
        seeAllCarsButton.setFocusable(false);
        seeAllCarsButton.addActionListener(this);

        refreshButton = new JButton();
        refreshButton.setText("REFRESH");
        refreshButton.setFont(fontNormal);
        refreshButton.setBackground(buttonBg);
        refreshButton.setForeground(white);
        refreshButton.setBounds(430, 200, 150, 60);
        refreshButton.setFocusable(false);
        refreshButton.addActionListener(this);

        frame.add(addCarsButton);
        frame.add(seeAllCarsButton);
        frame.add(refreshButton);
        frame.add(titleLabel);
        frame.add(bottomText);
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
            System.out.println("See cars");
        }

        //Exit button
        if (e.getSource() == addCarsButton) {
            System.out.println("add car");
        }

    }
}

package GUI;

import net.codejava.JavaMySQL;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Welcome implements ActionListener {

    JFrame frame = new JFrame();
    JavaMySQL javaMySQL = new JavaMySQL();


    private final int WIDTH = 350;
    private final int HEIGHT = 550;

    public String username;
    public String password;

    Font fontBig = new Font("Eras Bold ITC", Font.BOLD, 28);
    Font fontNormal = new Font("Eras Bold ITC", Font.PLAIN, 20);
    Font fontSmall = new Font("Eras Bold ITC", Font.PLAIN, 18);

    Color darkGreen = new Color(38, 70, 83);
    Color lightGreen = new Color(42, 157, 143);
    Color white = new Color(255, 255, 255);
    Color yellowColor = new Color(233, 196, 106);
    Color labelBg = new Color(244, 162, 97);
    Color buttonBg = new Color(231, 111, 81);

    public JButton submitButton;
    JTextField usernameInput = new JTextField();
    JTextField passwordInput = new JTextField();


    //Empty Constructor
    public Welcome() {

    }

    //Main Constructor
    public Welcome(String title) {
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
        frame.setTitle("AutoCheck " + title);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(WIDTH, HEIGHT);
        frame.getContentPane().setBackground(new Color(38, 70, 83));


        //Labels
        JLabel titleLabel = new JLabel("Auto-Check");
        titleLabel.setFont(fontBig);
        titleLabel.setForeground(yellowColor);
        titleLabel.setBounds(75, 25, 200, 50);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(fontNormal);
        usernameLabel.setForeground(yellowColor);
        usernameLabel.setBounds(60, 150, 150, 50);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(fontNormal);
        passwordLabel.setForeground(yellowColor);
        passwordLabel.setBounds(60, 250, 150, 50);


        //Inputs
        usernameInput.setBackground(labelBg);
        usernameInput.setForeground(white);
        usernameInput.setHorizontalAlignment(JTextField.CENTER);
        usernameInput.setFont(fontNormal);
        usernameInput.setBounds(60, 200, 200, 35);
        usernameInput.setBorder(null);

        passwordInput.setBackground(labelBg);
        passwordInput.setForeground(white);
        passwordInput.setHorizontalAlignment(JTextField.CENTER);
        passwordInput.setFont(fontNormal);
        passwordInput.setBounds(60, 300, 200, 35);
        passwordInput.setBorder(null);

        //Buttons
        submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setFont(fontNormal);
        submitButton.setBackground(buttonBg);
        submitButton.setForeground(white);
        submitButton.setBounds(40, 370, 250, 60);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        //Adding to frame
        frame.add(titleLabel);
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(usernameInput);
        frame.add(passwordInput);
        frame.add(submitButton);
        frame.setVisible(true);
    }


    //When Submit button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            username = usernameInput.getText();
            password = passwordInput.getText();






            //Check lengths
            for(int i = 0; i < JavaMySQL.username_vector.length;i++)
            {
                if(username == JavaMySQL.username_vector[i])
                {

                    if(password == JavaMySQL.passwords_vector[i])
                    {
                        if(JavaMySQL.mechanic_status[i] == 0)
                        {
                            System.out.println("e user");
                        }
                        else
                        {
                            System.out.println("e mecanic");
                        }
                    }
                }

            }

            //If lengths are ok, code inside "else"
//            else{
//                //Add query to check if user exists in DB
//                frame.setVisible(false);
//            }
        }

    }
}

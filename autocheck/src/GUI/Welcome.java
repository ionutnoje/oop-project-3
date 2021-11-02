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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Welcome implements ActionListener {

    JFrame frame = new JFrame();


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
            if ((username.length() < 3 || username.length() > 16) && (password.length() < 3 || password.length() > 16)) {
                System.out.println("Problema.");
            }

            //If lengths are ok, code inside "else"
            else{
                //Add query to check if user exists in DB

                MechanicGUI mechanicGUI = new MechanicGUI(username);
                frame.setVisible(false);

                try {
                    if (username != null && password != null) {
                        String sql = "Select * from users_table Where username='" + username + "' and password='" + password + "'";
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        if (rs.next()) {
                            //in this case enter when at least one result comes it means user is valid
                        } else {
                            //in this case enter when  result size is zero  it means user is invalid
                        }
                    }

                    // You can also validate user by result size if its comes zero user is invalid else user is valid

                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(this, err.getMessage());
                }
            }
        }

    }
}

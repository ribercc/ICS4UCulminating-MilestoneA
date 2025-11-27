import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class LoginPage extends JPanel {
    public LoginPage(JPanel mainPanel, Font mainText) throws IOException{
        setLayout(null);
        setBackground(Color.WHITE);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(600, 300, 100, 30);
        usernameLabel.setFont(mainText);
        add(usernameLabel);

        JTextField usernameTextbox = new JTextField();
        usernameTextbox.setBounds(700, 300, 150, 30);
        add(usernameTextbox);

    
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(600, 350, 100, 30);
        passwordLabel.setFont(mainText);
        add(passwordLabel);


        JPasswordField passwordTextbox = new JPasswordField();
        passwordTextbox.setBounds(700, 350, 150, 30);
        add(passwordTextbox);

        JButton newAccount = new JButton("Create an Account");
        newAccount.setBounds(675, 380, 200, 25);
        newAccount.setFont(mainText);
        newAccount.setOpaque(false);
        newAccount.setContentAreaFilled(false);
        newAccount.setBorderPainted(false);
        newAccount.setForeground(Color.BLACK);

        newAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent makeNewAccount) {
                System.out.println("Create new account button has been clicked.");

              CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "NewAccount");
                //follow create new account information here
            }
        });
        add(newAccount);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(700, 410, 150, 30);
        loginButton.setBackground(new Color(212, 139, 179));

        JLabel errorMessage = new JLabel("Invalid Data, please try again");
        errorMessage.setBounds(695, 250, 200, 30);
        errorMessage.setFont(mainText);
        errorMessage.setForeground(Color.RED);
        errorMessage.setVisible(false);
        add(errorMessage);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent login) {
                System.out.println("Login button clicked!");
                
                String username = usernameTextbox.getText();
                char[] password = passwordTextbox.getPassword();
                
                System.out.println(username);
                System.out.println(password);
                boolean validCredentials = false;
                
                try {
                    if (CustomerManager.checkCustomerExists(username)) {
                        if (CustomerManager.correctLogIn(username, password) == true) {
                            validCredentials = true;
                            CardLayout cl = (CardLayout) mainPanel.getLayout();
                            cl.show(mainPanel, "Homepage");
                            Customer currentCustomer = CustomerManager.readCustomer(username, password);
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    errorMessage.setText("File error. Contact admin.");
                    errorMessage.setVisible(true);
                }

               /* if (CustomerManager.checkCustomerExists(username)== true){
                    if (CustomerManager.correctLogIn(username, password) == true){
                        validCredentials = true;
                        Customer currentCustomer = CustomerManager.readCustomer (username, password);
                    }
                }*/

                
                
                if (validCredentials){
                     CardLayout cl = (CardLayout) mainPanel.getLayout();
                     cl.show(mainPanel, "Homepage");
                }

                else {
                   errorMessage.setVisible(true);
                    usernameTextbox.setText(""); // clears field
                    passwordTextbox.setText("");
                }
                
                //ask again if invalid
             
                
            }
        });
        add(loginButton);

    }
    
}
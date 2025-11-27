import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JPanel {
    public HomePage (JPanel mainPanel, Font mainText){
        setLayout(null);
        setBackground(Color.WHITE);

        /*JLabel label = new JLabel("This is the homepage!");
        label.setFont(new Font("Franklin Gothic Book", Font.BOLD, 24));
        label.setBounds(600, 200, 400, 50);
        add(label);*/

        /*JButton watchListButton = new JButton("Back to Login");
        watchListButton.setBounds(700, 400, 200, 30);
        watchListButton.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        add(watchListButton);*/

        /*watchListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Login"); // switch back to login page
            }
        });*/

        JPanel recommendedPanel = new JPanel();
        recommendedPanel.setBackground(Color.WHITE);
        recommendedPanel.setBounds(150, 100, 900, 350);
        recommendedPanel.setBorder(BorderFactory.createTitledBorder("Recommended movies")); //change font and location
        add(recommendedPanel);

        JPanel reviewPanel = new JPanel();
        reviewPanel.setBackground(Color.WHITE);
        reviewPanel.setBounds(150, 500, 900, 200);
        reviewPanel.setBorder(BorderFactory.createTitledBorder("Reviews from Recently Watched")); //change font and location
        add(reviewPanel);

        JPanel blogPanel = new JPanel();
        blogPanel.setBackground(Color.white);
        blogPanel.setBounds(1100, 100, 300, 600);
        blogPanel.setBorder(BorderFactory.createTitledBorder("Blogs and Discussions"));
        add(blogPanel);

        JPanel indexPanel = new JPanel();
        indexPanel.setLayout(null);
        indexPanel.setBackground(Color.WHITE);
        indexPanel.setBounds(150, 730, 900, 50);
        indexPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        add(indexPanel);

        indexPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        JButton watchListButton = new JButton("Watchlist");
        watchListButton.setFont(mainText);
        watchListButton.setOpaque(false);
        watchListButton.setContentAreaFilled(false);
        watchListButton.setBorderPainted(false);
        watchListButton.setForeground(Color.BLACK);
       

        JButton favoritesButton = new JButton("Favorites");
        favoritesButton.setFont(mainText);
        favoritesButton.setOpaque(false);
        favoritesButton.setContentAreaFilled(false);
        favoritesButton.setBorderPainted(false);
        favoritesButton.setForeground(Color.BLACK);

        JButton reviewButton = new JButton("Write a Review");
        reviewButton.setFont(mainText);
        reviewButton.setOpaque(false);
        reviewButton.setContentAreaFilled(false);
        reviewButton.setBorderPainted(false);
        reviewButton.setForeground(Color.BLACK);
        
        JButton accountSettingsButton = new JButton("Account Settings");
        accountSettingsButton.setFont(mainText);
        accountSettingsButton.setOpaque(false);
        accountSettingsButton.setContentAreaFilled(false);
        accountSettingsButton.setBorderPainted(false);
        accountSettingsButton.setForeground(Color.BLACK);

        JButton moviePageButton = new JButton("Movies");
        moviePageButton.setFont(mainText);
        moviePageButton.setOpaque(false);
        moviePageButton.setContentAreaFilled(false);
        moviePageButton.setBorderPainted(false);
        moviePageButton.setForeground(Color.BLACK);

        indexPanel.add(watchListButton);
        indexPanel.add(favoritesButton);
        indexPanel.add(reviewButton);
        indexPanel.add(accountSettingsButton);
        indexPanel.add(moviePageButton);

        moviePageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent goToMovies) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "MoviePage");
            }
        });

    }
}
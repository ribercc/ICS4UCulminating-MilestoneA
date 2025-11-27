import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

//TODO (MovieDataBase.csv) change genre type to enum, add image directory
//TODO Reformated project folders, add method comments
//TODO (Customer.java) read customers, check if the customer exists + password is correct before logging in
//TODO (NewAccountPage.java) ensure customer usernames are not repeated
public class Main {
    public static void main(String[] args) throws IOException {
        //declare fonts
        Font mainText = new Font("Franklin Gothic Book", Font.BOLD ,12);
        // Create the frame (main window)
        JFrame frame = new JFrame("Movies, Reviews, Suggestions & More");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2400, 900); 
        frame.setLocationRelativeTo(null); // centers the frame on screen

        //main panel to hold pages
        JPanel mainPanel = new JPanel(new CardLayout());

        //create main pages, pass through mainPanel
        LoginPage loginPage = new LoginPage(mainPanel, mainText);
        NewAccountPage newAccountPage = new NewAccountPage(mainPanel, mainText);
        HomePage homePage = new HomePage(mainPanel, mainText);
        MoviePage moviePage = new MoviePage(mainPanel, mainText);

        // Add pages to the CardLayout container
        mainPanel.add(loginPage, "Login");
        mainPanel.add(newAccountPage, "NewAccount");
        mainPanel.add(homePage,"Homepage");
        mainPanel.add(moviePage, "MoviePage");

        // Add to frame and show
        frame.add(mainPanel);
        frame.setVisible(true);

        //show login page first
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, "Login"); 
    }
    /*
     * Method to do file I/O for movie.java
     * By Jonathan
     * @return List<Movie> movieList
     
    public static ArrayList<Movie> readMovieFile() throws IOException{
        
        //Intialize variables, arrayLists, file object
        ArrayList<Movie> movieList = new ArrayList<>();
        String movieTtle;
        String movieDrector;
        String[] movieCstTop3 = new String[3];
        String[] movieTgs = new String[10];
        String movieGnre = "";
        String movieBlrb = "";
        int movieLngth;
        int rleaseYear;
        int commas = 0;
        String lineString = "";
        File movieFile = new File("MovieDataBase.csv");
        
        //if()
        
        //Verifying the file exists
        if(!movieFile.exists()){
            System.out.println("This file does not exist. The program will exit.");
            System.exit(0);
        }
        
        Scanner inFile = new Scanner(movieFile);
        
        while(inFile.hasNext()){
            commas = 0;
            lineString = inFile.nextLine();
            for(int i = 0; i < lineString.length(); i++){
                if(lineString.charAt(i) == ','){
                    commas++;
                }
            }
            

            if(commas < 18){
                System.out.println("This file is formatted incorrectly. The program will exit");
                System.exit(0);
            }
            
            String[] movieArray = lineString.split(",");
            
            Genre movieGenre = Genre.INDIE;
            
            if(movieArray[15].toLowerCase().equals("horror")){
                movieGenre = Genre.HORROR;
            }
            else if(movieArray[15].toLowerCase().equals("romance")){
                movieGenre = Genre.ROMANCE;
            }
            else if(movieArray[15].toLowerCase().equals("comedy")){
                movieGenre = Genre.COMEDY;
            }
            else if(movieArray[15].toLowerCase().equals("drama")){
                movieGenre = Genre.DRAMA;
            }
            else if(movieArray[15].toLowerCase().equals("animation")){
                movieGenre = Genre.ANIMATION;
            }
            else if(movieArray[15].toLowerCase().equals("fantasy")){
                movieGenre = Genre.COMEDY;
            }
            else if(movieArray[15].toLowerCase().equals("sci-fi")){
                movieGenre = Genre.SCIFI;
            }
            else if(movieArray[15].toLowerCase().equals("musical")){
                movieGenre = Genre.MUSICAL;
            }
            else if(movieArray[15].toLowerCase().equals("action")){
                movieGenre = Genre.ACTION;
            }
            else if(movieArray[15].toLowerCase().equals("adventure")){
                movieGenre = Genre.ADVENTURE;
            }
            else{
                movieGenre = Genre.INDIE;
            }
            
            
            
            
            if(!isNumeric(movieArray[18]) && !isNumeric(movieArray[17])){
                 System.out.println("This file is formatted incorrectly. The program will exit");
                 System.exit(0);
            }
            movieList.add(new Movie(movieArray[0], movieArray[1], new String[]{movieArray[2], movieArray[3], movieArray[4]}, movieGenre, movieArray[16], Integer.parseInt(movieArray[18]), Integer.parseInt(movieArray[17]), new String[]{movieArray[5], movieArray[6], movieArray[7], movieArray[8], movieArray[9], movieArray[10], movieArray[11], movieArray[12], movieArray[13], movieArray[14]}));
            
            
        }
        return movieList;
     // end readMovieFile
        

    }
    
     
     
    public static boolean isNumeric(String d){
        return d.matches("-?\\d+(\\.\\d+)?");
        
    }
    */
    
}
//TODO Add movie display information, incorporate movie images?
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class MoviePage extends JPanel{
    
    public MoviePage(JPanel mainPanel, Font mainText) throws IOException{
        setLayout(null);
        setBackground(Color.WHITE);


        //Basic buttons to return to homepage
        JButton returnHomepageButton = new JButton("Return to Homepage");
        returnHomepageButton.setBounds(100,700,171,30);
        returnHomepageButton.setFont(mainText);
        add(returnHomepageButton);

        returnHomepageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent goBack) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Homepage");
            }
        });

        //Button to print movie arraylist to console
        JButton showMovies = new JButton("Show Movies");
        showMovies.setBounds(280, 700, 171, 30);
        showMovies.setFont(mainText);
        add(showMovies);

        showMovies.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent showMovies) {
                MovieManager movie = new MovieManager(/*!Needs ArrayList Here? */);
                movie.printToScreenMovies(); //?Should be accessed in a static way
            }
        });

        JPanel moviePoster = new JPanel();
        moviePoster.setBackground(Color.WHITE);
        moviePoster.setBounds(100, 150, 342, 513);
        moviePoster.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(moviePoster);

    
}

}
   // List<Movie> movieList = new ArrayList<>();
    
    /*public MoviePage(List<Movie> mL){
        //Example code to print movie info to screen, obv diff w GUI, and security stuff not implemented, but Rob isn't checking yet
        movieList = mL;
    }*/
    
    /*public void printToScreenMovies(){
        for(int i = 0; i < movieList.size(); i++){
            System.out.println("Movie: " + movieList.get(i).getTitle());
            System.out.println("Director: " + movieList.get(i).getDirector());
            System.out.print("Genre: ");
            switch(movieList.get(i).getGenre()){
                case ROMANCE:
                    System.out.println("Romance");
                case COMEDY:
                    System.out.println("Comedy");    
                case DRAMA:
                    System.out.println("Drama");  
                case ANIMATION:
                    System.out.println("Animation");  
                case FANTASY:
                    System.out.println("Fantasy");  
                case SCIFI:
                    System.out.println("Sci-Fi");  
                case MUSICAL:
                    System.out.println("Musical");  
                case ACTION:
                    System.out.println("Action"); 
                case ADVENTURE:
                    System.out.println("Adventure");  
                case INDIE:
                    System.out.println("Indie");  
                
            }
            System.out.println("Blurb: " + movieList.get(i).getBlurb());
            System.out.println("Top 3 cast: " + Arrays.toString(movieList.get(i).getCastTop3()));
            System.out.println("Tags: " + Arrays.toString(movieList.get(i).getTags()));
            System.out.println("Length: " + movieList.get(i).getLength());
            System.out.println("Release Year: " + movieList.get(i).getReleaseYear());
            System.out.println("-----------------------------------------------------------------------------------");
            
        }
    }*/
//}

/*
HORROR,
    ROMANCE,
    COMEDY,
    DRAMA,
    ANIMATION,
    FANTASY,
    SCIFI,
    MUSICAL,
    ACTION,
    ADVENTURE,
    INDIE

*/
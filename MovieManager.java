import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MovieManager {
    private List<Movie> movieList = new ArrayList<>();

    /**
     * Method to do file I/O for movie.java
     * By Jonathan
     * @return List<Movie> movieList
     */
     // This needs to be moved to a different method, either Main or a Movie Manager - River
    
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
    } // end readMovieFile
        

    /*public MoviePage(List<Movie> mL){
        //Example code to print movie info to screen, obv diff w GUI, and security stuff not implemented, but Rob isn't checking yet
        movieList = mL;
    }*/
    
    public static void printToScreenMovies(){
        ArrayList<Movie> movieList = new ArrayList<>();

        //https://github.com/souvik-ghosh/react-native-create-thumbnail/issues/96
        try{
            movieList = readMovieFile();
        }
        catch(IOException e){
            System.out.println(".");
        }
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
    }
    public static boolean isNumeric(String d){
        return d.matches("-?\\d+(\\.\\d+)?");
        
    }
}

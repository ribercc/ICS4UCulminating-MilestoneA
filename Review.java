// Creates and manages Review objects
// Created on October 30th 2025 by Evangelia Lafontaine
// Last edited on November 27th 2025 by Daniel Malungo
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Review {
    private String userName;
    private int score;
    private String reviewText;
    private String movieName;
    private int movieIndex;

    /**
     * Constructor that initializes Review fields movie objects
     * @param paramUserName the name of the user in the review
     * @param paramScore the rating of a movie
     * @param paramReviewText the text of a review
     * @param paramMovieName the name of the movie
     * @param paramMovieIndex the index of the movie in the database
     */
    public Review(String paramUserName, int paramScore, String paramReviewText, String paramMovieName, int paramMovieIndex){
        userName = paramUserName;
        score = paramScore;
        reviewText = paramReviewText;
        movieName = paramMovieName;
        movieIndex = paramMovieIndex;
    }// End Review
    
    /**
     * This method gets the username of the person who made the review
     * @return the username of the reviewer
     */
    public String getReviewName(){
        return userName;
    }//End getReviewName
    
    /**
     * This method gets the review score
     * @return rating given to the movie as a number
     */
    public int getScore(){
        return score;
    }// End getScore
    
    /**
     * This method gets the review text
     * @return the text written in a review
     */ 
    public String getReviewText(){
        return reviewText;
    }// End getReviewText
    
    /**
     * This method gets the movie name
     * @return the name of the movie being reviewed
     */
    public String getMovieName(){
        return movieName;
    }// End getMovieName
    
    /**
     * This method gets the movie's index
     * @return the number of the movie in the database
     */
    public int getMovieIndex(){
        return movieIndex;
    }// End getMovieIndex
    
    /**
     * Adds a simple prompt to rate the movie, by Daniel
     * @param m the Movie object for which we will add a rating
     * @return Star object for the rating
     */
    public Star rateMovie(int u){
    
        //assume correct input: will be done via a GUI
        Star movieRating = Star.ONESTAR;
        if (u == 1)  movieRating = Star.ONESTAR;
        else if (u == 2) movieRating = Star.TWOSTAR;
        else if (u == 3) movieRating = Star.THREESTAR;
        else if (u == 4) movieRating = Star.FOURSTAR;
        else if (u == 5) movieRating = Star.FIVESTAR;
        return movieRating;
    } // end rateMovie
    
    /**
     * Gives the movie's score as an integer, by Daniel
     * This method will be more complex when code is updated
     * @param u the score given by the user
     * @return the score as an int
     */
    public int rateNum(String m){ //u will be a Star object later
        Scanner kb = new Scanner(System.in);
        System.out.print("Rate " + m + " out of 5 stars\t");
        int uStar = kb.nextInt(); //we're using the console for simplicity's sake for now
        rateMovie(uStar);
        return uStar;
    }
    
    /**
     * Allows the user to make a review, by Daniel
     * There's a chance that the MoviesList ArrayList didn't get filled out since Jonathan may still be editing it.
     * @param cust the user's account
     * @return a Review object with all fields filled out.
     */
    public Review makeReview(String name) throws IOException{ // switch back to a Customer object later for the username
        // Will change parameter, needs to be called on with correct data
        PrintWriter pw = new PrintWriter("Reviews.txt");
        Scanner kb = new Scanner(System.in);
        Movie film = new Movie();
      //?  ArrayList<Movie> moviesList = Main.readMovieFile(); // MUST be updated for the movieList
        System.out.print("Enter the name for the movie you want to review... \t");//For use until Daniel gets themself some proper variables.
        String revSubject = kb.nextLine();// Assume correct option because this is not permanent
        int rn = rateNum(revSubject);// You'll be clicking on the movie so the param may just be an object.
        System.out.print("Enter a short review for " + revSubject + " here to go along with your rating...\t");//You know the deal, this isn't final
        String uWriting = kb.nextLine();
        Review myReview = new Review(name, rn, uWriting, revSubject, moviesList.indexOf(revSubject));//Not fully populated YET!
        pw.println(uWriting);
        pw.close();
        return myReview;
    }
}
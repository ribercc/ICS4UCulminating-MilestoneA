// This class manages movie objects
// Created on October 30th by Evangelia LaFontaine
// Programmed by Jonathan Stetler
// Last edited on Nov 12 by Jonathan Stetler
//Movies are formatted in Movie.csv by "Title, Director, Movie Actor [3], 
//Movie Tags [10], Movie Genre, Movie Blurb (ENSURE NO COMMAS), Movie Length (minutes), Release Year,"

import java.util.*;

public class Movie {
    private String movieTitle;
    private String movieDirector;
    private String[] movieCastTop3;
    private String[] movieTags;
    private Genre movieGenre = Genre.INDIE;
    private String movieBlurb;
    private int movieLength;
    private int releaseYear;
    //TEST

    /**
     * Default onstructor that initializes all movie fields
     */
    public Movie() {
        movieTitle = "";
        movieDirector = "";
        movieCastTop3 = new String[] { ".", ".", "." };
        movieTags = new String[] { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };
        Genre movieGenre = Genre.INDIE;
        movieBlurb = "";
        movieLength = 0;
        releaseYear = 0;
    }// End Movie

    /**
     * Parameter constructor that initializes all movie fields
     * 
     * @param
     * @param
     */
    public Movie(String mT, String mD, String[] mCT3, Genre mG, String mB, int rY, int mL, String[] tgs) {
        this.movieTitle = mT;
        this.movieDirector = mD;
        this.movieCastTop3 = mCT3;
        this.movieTags = tgs;
        this.movieGenre = mG;
        this.movieBlurb = mB;
        this.movieLength = mL;
        this.releaseYear = rY;
    }// End Movie
    /*
     * Dumb and super unnessary
     * public ArrayList<String> getMovieInfo(){
     * //
     * private ArrayList<String> movieInfo = new ArrayList<>();
     * movieInfo.add(movieTitle);
     * movieInfo.add(movieDirector);
     * movieInfo.add(movieGenre);
     * movieInfo.add(movieBlurb);
     * movieInfo.add(String.valueOf(movieLength));
     * movieInfo.add(String.valueOf(releaseYear));
     * movieInfo.add(movieCastTop3[0]);
     * movieInfo.add(movieCastTop3[1]);
     * movieInfo.add(movieCastTop3[2]);
     * movieInfo.add(movieTags[0]);
     * movieInfo.add(movieTags[1]);
     * movieInfo.add(movieTags[2]);
     * movieInfo.add(movieTags[3]);
     * movieInfo.add(movieTags[4]);
     * movieInfo.add(movieTags[5]);
     * movieInfo.add(movieTags[6]);
     * movieInfo.add(movieTags[7]);
     * movieInfo.add(movieTags[8]);
     * movieInfo.add(movieTags[9]);
     * return movieInfo;
     * }
     */
    /*
     * public ArrayList<String> recommendMovies(){
     * return
     * }
     */

    public String getTitle() {
        return movieTitle;
    }

    public String getDirector() {
        return movieDirector;
    }

    public Genre getGenre() {
        return movieGenre;
    }

    public String getBlurb() {
        return movieBlurb;
    }

    public String[] getCastTop3() {
        return movieCastTop3;
    }

    public String[] getTags() {
        return movieTags;
    }

    public int getLength() {
        return movieLength;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

}

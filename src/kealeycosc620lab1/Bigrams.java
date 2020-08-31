/*
 * Provides a class for Bigrams (consisting of the Bigram String, and an int for 
 * frequency of occurence). Allows for Collections.sort() to sort them more 
 * more easily.
 */
package kealeycosc620lab1;
//import java.util.Comparator;
/**
 *
 * @author wrkealey0
 * @version 0827191400
 */
public class Bigrams implements Comparable<Bigrams>{
    private String bigram;
    private int freq;
    


    
    public Bigrams(String bigram, int freq){
        
        this.bigram = bigram;
        this.freq = freq;
    }
    
    /**
     * Shows each bigram and its frequency in String format.
     * @return is the Bigram as a string. 
     */
    @Override
    public String toString(){
        return this.bigram+" "+this.freq;
    }
    
    //Returns the frequency that an assotiated bigram appears in the text.
    //This gets the value from the Collections.frequency() call. 
    public int getFreq(){
        return freq; 
    }
    
    //I doubt this will be used but it couldn't hurt to have a method to return 
    //the bigram.
    
    //Actually did use it in testing.
    public String getBigram(){
        return this.bigram;
    }
    
    /**
     * Overrides the native compareTo method in Collections.sort().
     * @param b2 is a Bigram to compare
     * @return is an int, 0 for a match, positive if properly sorted, and negative otherwise.
     */
    @Override
    public int compareTo(Bigrams b2){
        if(this.freq>b2.freq){
            return 1;
        } else if (this.freq<b2.freq){
            return -1;
        } else {
        return 0;
        }
    }
    
    /**
     * Takes two bigrams and compares them.
     * @param b1 first bigram
     * @param b2 second bigram
     * @return int returned by compareTo (see above).
     */
    public int compare(Bigrams b1, Bigrams b2){
        return b1.compareTo(b2);
    }
}



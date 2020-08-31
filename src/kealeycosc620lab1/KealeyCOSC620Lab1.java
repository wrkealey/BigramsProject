/**
 * This project takes an input file of nearly randomly collected text collected
 * from the web search for "security in computing". An informal collection of 
 * sources for this material will be included. It creates bigrams from this input
 * and reports the 20 most common bigrams in descending order. 
 */
package kealeycosc620lab1;
import java.util.*;
import java.io.*;

/**
 * @author wrkealey0
 * @version 0826191413
 */
public class KealeyCOSC620Lab1 {
    

    
    /**
     * @param args the command line arguments
     * @throws IOException if I am about to fail out of College.
     */
    public static void main(String[] args) throws IOException{
        //Bigrams n = new Bigrams();
        try {
        //One list to hold individual words
        ArrayList<String> words = new ArrayList();
        //One list to hold bigram strings
        ArrayList<String> combined = new ArrayList();
        //Set used to count specific occurances.
        Set<String> b1 = new HashSet();
        //List to hold bigrams as String + number of occurances
        ArrayList<Bigrams> bigrams = new ArrayList();
        File tFile = new File("./KealeyLab1Input.txt");
        FileInputStream in = new FileInputStream(tFile);
        Scanner reader = new Scanner(in, "UTF-8");
        while (reader.hasNext()){
            String fWord = reader.next(); //pun unintended. 
            words.add(fWord);
        }
        for(int i = 0; i<words.size()-1; i++){
            String k = (words.get(i)+" "+words.get(i+1));
            b1.add(k);
            combined.add(k);
        }
        
        //Get count and for convience put 
        for(String s : b1){
            int z = Collections.frequency(combined, s);
            if(z>=10){  //can figure that the most common bigrams will occur at least 10 times.
            Bigrams v = new Bigrams(s, z);
            bigrams.add(v);
            }
        }
        
        
        Collections.sort(bigrams, Collections.reverseOrder()); //sorts bigrams, descending.
        
        //ArrayList<Bigrams> fBigrams = new ArrayList();
        
     
        System.out.println("The 20 most common bigrams in "+tFile.getAbsolutePath());
        //Prints the top 20 to system.
        for(int i = 0; i < 20; i++){
            System.out.println((i+1)+". "+bigrams.get(i));
        }
        
        //prints the output to an output file.
        File output = new File("./KealeyOutput.txt");
        
        if(!output.exists()){
            output.createNewFile();
            System.out.println("Output file being created at: "+output.getAbsolutePath());
        }
        
        FileWriter fw = new FileWriter(output.getAbsoluteFile(), true);
        PrintWriter writer = new PrintWriter(fw);
        writer.println("The 20 most common Bigrams in "+tFile.getAbsolutePath());
        for (int i = 0; i < 20; i++){
            String out = (i+1)+". "+bigrams.get(i).toString();
            writer.println(out);
        }
        
        
        writer.close();
       
       
        } catch (Exception err) {
            System.out.println("Something has broken.");
        }
    }
    
}

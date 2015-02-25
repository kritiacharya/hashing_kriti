package seniorProject;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class hashing
{
public static void main( String[] args )
{
   // create HashMap to store String keys and Integer values
   Map< String, Double > myMap = new HashMap< String, Double>(); 

   createMap( myMap ); // create map based on user input
} // end main

// create map from user input
private static void createMap( Map< String, Double> map ) 
{
   Scanner scanner = new Scanner( System.in ); // create scanner
   System.out.println( "Enter a clickstream:" ); // prompt for user input
   String input = scanner.nextLine();

   // tokenize the input
   String[] tokens = input.split( " " );
            
   // processing input text 
   for ( String token : tokens ) 
   {
      String word = token.toLowerCase(); // get lowercase word
               
      // if the map contains the word
      if ( map.containsKey( word ) ) // is word in map
      {
    	 double count = map.get( word ); // get current count
         map.put( word, count + 1 ); // increment count
      } // end if
      else 
         map.put( word, (double) 1 ); // add new word with a count of 1 to map
   } // end for
   System.out.println("Initial counting!!!");
   System.out.println("Unique-Keys \t  Values");
   for(int a=0; a<tokens.length; a++){

	   System.out.println(tokens[a] + "\t\t" + map.get(tokens[a] ));
   }
   
   double prob;
   double[] entro = new double[tokens.length];
   for(int a=0; a<tokens.length; a++){ 
	   prob =(double)( map.get(tokens[a]))/(double)(tokens.length);
	   entro[a] = prob * (Math.log(prob)/Math.log(2));
	   //System.out.printf( "%-10s%10s\n", tokens[a],  entro[a] );
   }
   System.out.println("\n\nFinding Entropy Value");   
   System.out.println("Unique-Keys \t  Entropy Value");
for(int a=0; a<tokens.length; a++){
	   map.put(tokens[a], entro[a]);
	  System.out.printf( "%-10s%10s\n", tokens[a],  map.get( tokens[a] ) );
	   
   }
   
   Set< String > keys = map.keySet();
   System.out.println( "\nNo duplicates and ascending order:\nKey\t\tValue" );
   for ( String key : keys)
	      System.out.printf( "%-10s%10s\n", key,  map.get( key ) );
   
  
} // end method createMap


} // end class WordTypeCount


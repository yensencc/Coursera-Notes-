
/**
 * Write a description of quiz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class quiz {
    public void test(){
        
    String [] words = {"me", "you", "hello", "misspellit"};
    System.out.println(words.length);
    int [] counts = new int[words.length];
    
       
     for(String word : words){  	
     int wordlength = word.length(); 
     System.out.println("before: " + wordlength);
     if (wordlength >= counts.length) {  	    	   
          wordlength = counts.length - 1;  	
          System.out.println("after: " + wordlength);
     }  	
     if (wordlength > 0 ) {  	   	   
          counts[wordlength] ++;  	  	
     }
    }
    for(int count : counts){
     System.out.println(count);
    }
   
    }
    
    
    public void ahalf ( ){
        int start = 1;
        
        String message = "Qbkm Zgis";
        String answer = "";  	
     for (int k = start; k < message.length() ; k+= 2) {
     answer = answer + message.charAt(k);    	
     }
        System.out.println( answer);
    }
}

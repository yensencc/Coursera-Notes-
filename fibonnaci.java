/**
 * Class Untitled
 */
 
 import java.util.*;
public class fibonnaci {
	public static void main(String[] args) {
    	System.out.println("Hello from AWS Cloud9!");
    	fibonnaci();
	}
	
	public static void fibonnaci(){
    int startValue = 1;
    int prevValue = 1;
    int nextValue = 0;
    int count = 0;
    int afterNext = 0;
    System.out.println("Please enter fibonacci limit");
    Scanner keywordInput = new Scanner(System.in);
    int limit = keywordInput.nextInt();
    System.out.println(prevValue);
    
    while(count < limit ){
        
        if(startValue < 2){
            nextValue = startValue * 2;
            startValue = 3;
            System.out.println(nextValue);
            afterNext = nextValue;
            
        }else{
            nextValue = afterNext;
            System.out.println(afterNext = prevValue + nextValue);
            prevValue = nextValue;
            
        }
       
        count = count  + 1;
    }
}

}
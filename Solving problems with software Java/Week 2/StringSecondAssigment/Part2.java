
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public static int howMany(String stringa, String stringb){
        
        // 
        int startIndex = stringb.indexOf(stringa);
        int concurrences = 0;
        if(startIndex == -1){
            return 0;
        }
        else{
            while(startIndex != -1){
               concurrences += 1;
               startIndex = stringb.indexOf(stringa, startIndex + 3);
            }

           
        }
        
        return concurrences;
    }
    
    public static void testHowMany(){
        // invoke howMany method
        System.out.println(howMany("GAA", "ATGAACGAATTGAATGAAGAAC"));
    }
}

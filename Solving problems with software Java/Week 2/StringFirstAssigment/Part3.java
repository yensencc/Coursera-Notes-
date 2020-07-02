
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    // write method  


public static boolean twoOccurrences (String stringa, String stringb){
	boolean appTwice = false;
	int first_con = 1;
	first_con = stringb.indexOf(stringa);
	int second_con = stringb.indexOf(stringa, first_con + stringa.length() );
	if(first_con != -1  && second_con != -1 ){
		appTwice = true;
	}
	return appTwice;
}

public static String lastPart (String stringa, String stringb){
	// find first ocurrence index position of stringa in string b
	int first_occur = stringb.indexOf(stringa);
	
	// get first index position after stringa
	int afterStringaStart = first_occur + stringa.length();
	// get last position of stringb
	int afterStringaStop = stringb.length();
	// save substring from first to last position as lastpart
	String lastpart = stringb.substring(afterStringaStart, afterStringaStop);
	// is stringa does not occur in string b then return string b
	// if occurs then return lastpart
	if (stringb.indexOf(stringa) == -1){
		return stringb;
	}else{
		return lastpart;
	}
	
}

    
    public void testing (){
        System.out.println(twoOccurrences ("aaa", "baaabbbaaa"));
        System.out.println(lastPart("eee", "baaabbbaaa"));
    }
    
}

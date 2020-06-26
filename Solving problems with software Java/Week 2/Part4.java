
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part4 {
    
    public static boolean isIn(String stringa, String stringb){
    boolean contains = false;
    if(stringb.indexOf(stringa) != -1){
        contains = true;
    }
    return contains;
}

public static void findYoutuveUrls(String url){
   
    URLResource ur = new URLResource(url);
    for (String s : ur.lines()) {
    String lowerCaseUrl = s.toLowerCase();
    if(isIn("youtube",lowerCaseUrl)){
       System.out.println(getUrl(s));
    }
    
   
 }
   
}

public static String getUrl(String line){
    String parenthesis = "\"";
    // find first parenthesis
    int startIndex = line.indexOf(parenthesis);
    // find last parenthesis
    int lastIndex = line.indexOf(parenthesis, startIndex + 1 );
    // get substring between first parenthesis position and last parenthesis position
    String urlSubstring = line.substring(startIndex + 1 , lastIndex);
    // return substring as url
    return urlSubstring.toLowerCase();
}
public static void testWebUrl(){
     findYoutuveUrls("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
 }

}


/**
 * Write a description of PracticeEnum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PracticeEnum {

    
    public void tellMeIfitsTheWeekend(DayOfWeek day){
        if(day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)){
            System.out.println("Woo ! It's the weekend");
        } else if(day.equals(DayOfWeek.FRIDAY)){
            System.out.println("So close!, 1 more day until the weekend");
        }else  {
            System.out.println("Hang in there! Not the weekend yet");
        }
    
    }
    
    
    public void testTellMeIfItsTheWeekend(){
        DayOfWeek thirdDay = DayOfWeek.WEDNESDAY;
        System.out.println(thirdDay);
        tellMeIfitsTheWeekend(thirdDay);

    }   
    
    public void testOrderingDay(){
        DayOfWeek monday = DayOfWeek.MONDAY;
        DayOfWeek newDay = monday.plus(3);
        // should return 3 days after monday , which is thirdsday
        System.out.println(newDay);
        
       
        
        
        
    }
    
    
    public void testSuitColors(){
        Suit suits;
        
        for(Suit suit : Suit.values()){
            String output = String.format("The suit: %s is the color %s.%n" , suit, suit.getColor());
            System.out.println(output);
        }
        
    
    
    }

}

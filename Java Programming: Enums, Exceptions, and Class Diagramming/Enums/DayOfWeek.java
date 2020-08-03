
/**
 * Write a description of PracticeEnum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public enum DayOfWeek {

MONDAY(0),
TUESDAY(1),
WEDNESDAY(2),
THURSDAY(3),
FRIDAY(4),
SATURDAY(5),
SUNDAY(6);

    private int ordering;

    private DayOfWeek(int ordering){
    
        this.ordering = ordering;
    
    }
    public DayOfWeek plus(int numberOfDays){
        if(numberOfDays < 0){
            throw new IllegalArgumentException("Number of days must be positive.");
        }
        
        int newOrderingValue = (this.ordering + numberOfDays) % 7;
        for(DayOfWeek day : DayOfWeek.values()){
            if(day.ordering ==  newOrderingValue){
                return day;
            }
        
        }
        
        // if we got here someone has broken the DayOfWeek enum.
        
        throw new IllegalStateException("Could not find a day for ordering value");
    }
    @Override
    public String toString(){
    
        return name().substring(0,1) + name().substring(1).toLowerCase();
    }
    
    


}


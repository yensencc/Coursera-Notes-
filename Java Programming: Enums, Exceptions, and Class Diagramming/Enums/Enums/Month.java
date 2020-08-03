/**
 * An Enum representing the US months of the year.
 */
public enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);
    /**
     * Get the number of days in the month. Leap years are not considered.
     * Ex: January -> 31
     * @return the number of days in a month
     */
    
    private int ordering;
    private int numberOfDays;
    
    private Month(int ordering){
        this.ordering = ordering;
        this.numberOfDays = getDays(ordering);
    }
    public int getLength() {
        return this.numberOfDays;
    }

    /**
     * Adds numberOfMonths to the current Month and returns what month it will then be.
     * @param numberOfMonths the number of months to look ahead
     * @return what month it will be numberOfMonths after the current month
     */
    public Month plus(int numberOfMonths) {
        
        //TODO: Implement me
        
        Month newMonth = null;
        int newMonthNumber = 0;
        
        int currentMonthOrder = this.ordering;
        
        newMonthNumber = (currentMonthOrder + numberOfMonths) % 12;
        
        for(Month currentMonth : values()){
            
            if (currentMonth.ordering == newMonthNumber){
                return currentMonth;
            }
        
        }
                                        
      return newMonth;
    }
    
     public int getDays(int ordering){
         int numberOfDays = 0;
         switch(ordering){
            
             case 1:
              numberOfDays = 31;
              break;
             case 2:
              numberOfDays = 28;
              break;
             case  3:
             numberOfDays = 31;
             break;
             case 4:
             numberOfDays = 30;
             break;
             case 5:
             numberOfDays = 31;
             break;
             case 6:
             numberOfDays = 30;
             break;
             case 7:
             numberOfDays = 31;
             break;
             case 8:
             numberOfDays = 31;
             break;
             case 9:
             numberOfDays = 30;
             break;
             case 10:
             numberOfDays = 31;
             break;
             case 11:
             numberOfDays = 30;
             break;
             case 12:
             numberOfDays = 31;
             break;
             
             default:
             numberOfDays = 0;
            }
        
       return numberOfDays;
     }

    /**
     * Return the name of the month in the requested style, either SHORT or default to LONG. For some months,
     * SHORT may be equal to LONG.
     * Ex: A SHORT style would return 'Jan' and the LONG style would return 'January'
     * @param style - the style the month should be returned in
     * @return the display name of the current month according to the requested style.
     */
    public String getDisplayName(DisplayStyle style) {
        //TODO: Implement me
        
        String monthStyle = "";
        DisplayStyle ShortSt = DisplayStyle.SHORT;
        DisplayStyle longSt = DisplayStyle.LONG;
        
        switch(this.ordering){
            case  1:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString().substring(0,3);
                }else{
                    monthStyle = this.toString();
                }
                
                break;
            case 2:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString().substring(0,3);
                }else{
                    monthStyle = this.toString();
                }
                
                break;
            case 3:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString();
                }else{
                    monthStyle = this.toString();
                }
                
                break;
            case 4:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString();
                }else{
                    monthStyle = this.toString();
                }
                
                break;
            case 5:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString();
                }else{
                    monthStyle = this.toString();
                }
                
                break;
            case 6:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString();
                }else{
                    monthStyle = this.toString();
                }
                
                break;
            case 7:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString();
                }else{
                    monthStyle = this.toString();
                }
                
                break;
            case 8:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString().substring(0,3);
                }else{
                    monthStyle = this.toString();
                }
            case 9:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString().substring(0,4);
                }else{
                    monthStyle = this.toString();
                }
                
                break;
            case 10:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString().substring(0,3);
                }else{
                    monthStyle = this.toString();
                }
                
                break;
            case 11:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString().substring(0,4);
                }else{
                    monthStyle = this.toString();
                }
                
                break;
            case 12:
                if(style.equals(ShortSt)){
                    monthStyle = this.toString().substring(0,4);
                }else{
                    monthStyle = this.toString();
                }
                
                break;
            default:
        }
        
        
        return monthStyle.substring(0,1) + monthStyle.substring(1, monthStyle.length()).toLowerCase();
    }
}

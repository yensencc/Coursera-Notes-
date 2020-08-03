
/**
 * Write a description of Suit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum Suit {
    
    CLUBS("black"),
    DIAMONDS("red"),
    HEARTS("red"),
    SPADES("black");
    
    
    
    private String color;
    
    
    private Suit(String suitColor){
        this.color = suitColor;
    
    }
    
    public boolean isBlack(){
        return "black".equals(this.color);
    
    }
    public boolean isRed(){
        return "red".equals(this.color);
    
    }
    
    public String getColor(){
        return this.color;
    }
    
    
}

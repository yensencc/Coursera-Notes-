public class PracticeThis {
     private String str;
   
     public PracticeThis() {
         this("ATA Rulez");
     }
   
     public PracticeThis(String str) {
         this.str = str;
     }
   
     public void practiceMyThisKnowledge() {
          String str = "Who says ATA Rulez?";
   
          System.out.println(str);
         System.out.println(this);
     }
   
     @Override
     public String toString() {
         return "According to PracticeThis: " + str;
     }
     
     public static void main(String [] args ){
    
    PracticeThis thisPractice = new PracticeThis();
    thisPractice.practiceMyThisKnowledge();
}
}


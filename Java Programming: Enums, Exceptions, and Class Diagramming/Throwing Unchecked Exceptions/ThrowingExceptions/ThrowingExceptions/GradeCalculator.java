import java.util.Scanner;

public class GradeCalculator {
    /**
     * You don't need to modify this method.
     *
     * You do not need to understand how Scanner or printf work.
     */
    public void gradeEntryForStudent(int numberOfSubjects) {
        double[] grades = getGrades(numberOfSubjects);
        double finalGrade = calculateFinalGrade(grades);

        // Here we print out the final grade to two decimal places (the "%.2f" part) followed
        // by a new line (the "%n" part). That way the message appears on a distinct line.
        System.out.printf("Final grade for this student: %.2f%n", finalGrade);
    }

    /**
     * You don't need to modify this method.
     *
     * You do not need to understand how Scanner or printf work.
     */
    private double[] getGrades(int numberOfSubjects) {
        Scanner in = new Scanner(System.in, "UTF-8");
        double[] grades = new double[numberOfSubjects];
        for (int i = 0; i < grades.length; i++) {
            // Here we print out a message asking for a grade for this student. The "%d" part
            // prints out 1 + the current loop index. Note that this message does not end with
            // "%n", meaning there is no new line, so that the user input appears on the same
            // line as this message.
            System.out.printf("Please enter grade #%d for this student: ", i + 1);

            double grade = in.nextDouble();
            grades[i] = grade;
        }
        return grades;
    }

    /**
     * You need to modify this method.
     *
     * What assumptions does the method make? How can you protect this method's assumptions so that it can either
     * fulfill its purpose or loudly complain to the caller that something terrible could happen?
     */
    private double calculateFinalGrade(double[] grades) {
        // First let's find the index of the smallest grade.
        
        if(grades.length < 2 ){
            throw new IllegalArgumentException(" IllegalArgumentException thrown because there must be at least two subjects worth of grades");
        
        }
        
        int smallestIndex = 0;
        double smallestValue = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < smallestValue) {
                smallestIndex = i;
                smallestValue = grades[i];
            }
        }

        // Now let's calculate the average, skipping over the smallest element
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            if (i != smallestIndex) {
                
                if(grades[i] > 4){
                    throw new IllegalArgumentException(" IllegalArgumentException thrown because the grade at index " + grades[i]  + " is not a valid grade");
                }
                sum = sum + grades[i];
            }
        }
        return sum / (grades.length - 1);
    }
}
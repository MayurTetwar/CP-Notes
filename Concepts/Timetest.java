package Concepts;

public class Timetest {
    public static void main(String[] args) {
       
    
        long startTime = System.currentTimeMillis();
        // Some task (example: loop)
        for (long i = 0; i < 1000; i++) {
           
        }

        // Record end time
        long endTime = System.currentTimeMillis();

        // Difference in milliseconds
        long difference = endTime - startTime;

        System.out.println("Time taken: " + difference + " ms");
        

    }
}


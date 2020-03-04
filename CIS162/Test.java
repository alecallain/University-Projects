import java.util.Scanner;
import java.lang.String;
import java.awt.*;

/**
 * This is either for projects or just to mess around.
 * 
 * @author Alec Allain
 * @version 0.1.2
 */

// yeah mainly to mess around with code

public class Test
{
    public static void main(String args[]){
        Scanner scnr = new Scanner(System.in);

        String answer = "";

        System.out.println("Do you like me? Answer with yes or no");
        answer = scnr.nextLine();
        if (answer.contains("yes")){
            System.out.println("Oh my goodness! You dont know how happy you made me ^.^");
        } 
        else {
            System.out.println("Oh....alright :(");
        }
        System.out.println("How would you feel about me taking you to lunch? Answer with good or not good");
        answer = scnr.nextLine();
        if (answer.contains("good")){
            System.out.println("Yay! :)");
            System.out.println("Anywhere your in the mood for?");
            answer = scnr.nextLine();
            if (answer.contains("nowhere")){
                System.out.println("Ah....alrighty then");
            }
            else {
                System.out.print("Ah excelent choice!");
            }
        }
        else {
            System.out.println("Ah...ok...");
        }

        return;
    }

    public static double average(int[] nums) {
        // nums = new {1,2,3,4,5,6,7,8,9,10};

        double avg = 0.0;
        double sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        avg = sum / nums.length;

        return avg;
    }

    public static int [] reverseIt (int[] nums) {
        //int [] nums = {1,2,3,4,5,6,7,8,9,10};
        int [] results = new int[nums.length];
        int j = nums.length - 1;

        for (int i = 0; i < nums.length; i++, j--) {
            results[j] = nums[i];
        }

        return results;
    }

}

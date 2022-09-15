package Activities;
import java.util.*;

public class Activity13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random indexGen = new Random();

        System.out.print("Enter the integers");
        System.out.println("(EOF or non-integer to terminate): ");

        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        Integer nums[] = list.toArray(new Integer[0]);
        int index = indexGen.nextInt(nums.length);
        System.out.println("Index value created as: " + index);
        System.out.println("Value in array at generated index: " + nums[index]);

        scan.close();
    }
}

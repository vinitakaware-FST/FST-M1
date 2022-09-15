package Activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Sam");
        myList.add("Ram");
        myList.add("Joy");
        myList.add(3, "Jay");
        myList.add(1, "Ron");

        System.out.println("All the names are:");
        for(String s:myList){
            System.out.println(s);
        }

        System.out.println("3rd name in the list is: " + myList.get(2));
        System.out.println("Is Rony is in list: " + myList.contains("Rony"));
        System.out.println("Size of ArrayList: " + myList.size());
        myList.remove("Jay");
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}
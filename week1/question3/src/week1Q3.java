import java.util.Scanner;

public class week1Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean check = false;
        do {
            System.out.println("enter String to a maximum of 30: ");
            // get user string
            // Replace the spaces
            String userInput = input.nextLine().toLowerCase().replaceAll(" ", "");

            // if user input is less then 30 run
            if (checkLength(userInput) == true) {
                check = true;
                char[] vowelArray = turnToArray(userInput);
                System.out.println("");

                Count(vowelArray);

                System.out.println("");
                firstInstance(vowelArray);
            }
            // if user input more then 30 exit
            else {
                System.out.println("The string is too long. please enter again.");
            }
        } while (check == false);
        input.close();
    }

    public static boolean checkLength(String userInput) {
        // make sure user string doesn't exceed 30 characters

        if (userInput.length() > 30)
            return false;
        else
            return true;
    }

    public static char[] turnToArray(String userInput) {
        // Transform the user input into a Character array
        // return transformed array to main

        // set User input as a char Array
        char[] arr = new char[userInput.length()];

        // populate Char from all character of userInput
        for (int i = 0; i < userInput.length(); i++) {
            arr[i] = userInput.charAt(i);
        }

        char[] arr1 = new char[arr.length];
        int counter = 0;
        // Loop through array and make array only Vowels
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'a':
                    arr1[counter] = userInput.charAt(i);
                    counter++;
                    break;
                case 'e':
                    arr1[counter] = userInput.charAt(i);
                    counter++;
                    break;
                case 'i':
                    arr1[counter] = userInput.charAt(i);
                    counter++;
                    break;
                case 'o':
                    arr1[counter] = userInput.charAt(i);
                    counter++;
                    break;
                case 'u':
                    arr1[counter] = userInput.charAt(i);
                    counter++;
                    break;
                default:
                    break;
            }
        }
        // Display Array
        System.out.print(arr1);
        // return array to main
        return arr1;

    }

    public static void Count(char[] vowelArray) {
        // Count the number of Vowels in vowelArray

        // initalise the count
        int countA = 0;
        int countE = 0;
        int countI = 0;
        int countO = 0;
        int countU = 0;

        // loop through array
        for (int i = 0; i < vowelArray.length; i++) {
            // Add to count depending on if Array at i is a Vowel
            switch (vowelArray[i]) {
                case 'a':
                    countA = countA + 1;
                    break;
                case 'e':
                    countE = countE + 1;
                    break;
                case 'i':
                    countI = countI + 1;
                    break;
                case 'o':
                    countO = countO + 1;
                    break;
                case 'u':
                    countU = countU + 1;
                    break;
            }
        }
        // Display the Count
        System.out.println("The Counts are as follows");
        System.out.println(countA);
        System.out.println(countE);
        System.out.println(countI);
        System.out.println(countO);
        System.out.println(countU);
    }

    public static void firstInstance(char[] vowelArray) {
        // find the first instance a Vowel appears

        // initalise first
        // Count greater then 31 to exceed bounds of array set previously
        int countA = 31;
        int countE = 31;
        int countI = 31;
        int countO = 31;
        int countU = 31;

        // loop through Array
        for (int i = 0; i < vowelArray.length; i++) {
            // find specific Vowel in array
            switch (vowelArray[i]) {
                case 'a':
                    // count the first appearance of specific Vowel
                    // make sure it is first appearance by checking if it is the lowest value
                    if (i < countA)
                        countA = i;
                    break;
                case 'e':
                    if (i < countE)
                        countE = i;
                    break;
                case 'i':
                    if (i < countI)
                        countI = i;
                    break;
                case 'o':
                    if (i < countO)
                        countO = i;
                    break;
                case 'u':
                    if (i < countU)
                        countU = i;
                    break;
            }
        }

        // Display the first instance if not outside bounds of array
        if (countA <= 30) {
            System.out.println("A first appears at " + countA);
        } else {
            // display message where Value is not in array
            System.out.println("A is not in the input");
        }
        if (countE <= 30) {
            System.out.println("E first appears at " + countE);
        } else {
            System.out.println("E is not in the input");
        }
        if (countI <= 30) {
            System.out.println("I first appears at " + countI);
        } else {
            System.out.println("I is not in the input");
        }
        if (countO <= 30) {
            System.out.println("O first appears at " + countO);
        } else {
            System.out.println("O is not in the input");
        }
        if (countU <= 30) {
            System.out.println("U first appears at " + countU);
        } else {
            System.out.println("U is not in the input");
        }

    }
}

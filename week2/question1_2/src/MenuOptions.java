public class MenuOptions {
    // Display menu options
    public void displayOptions() {
        System.out.println("Choose one of the following options to proceed:");
        System.out.println("[a] Output names");
        System.out.println("[b] Output the largest and the smallest of 3 numbers");
        System.out.println("[c] Display numbers between 2 integers and sum odd numbers");
        System.out.println("[d] Identify if a combination of sides forms a triangle");
        System.out.println("[e] Determine if a number is a prime number");
        System.out.println("[f] Display average, highest and lowest numbers");
        System.out.println("[q] Exit menu");
    }

    // Process user input
    public boolean processInput(boolean flag, char choice) {
        switch (choice) {
            case 'a':
                optionA();
                break;
            case 'b':
                optionB();
                break;
            case 'c':
                optionC();
                break;
            case 'd':
                optionD();
                break;
            case 'e':
                optionE();
                break;
            case 'f':
                optionF();
                break;
            case 'q':
                System.out.println("Exited Menu");
                flag = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        System.out.println();
        return flag;
    }

    // Option A
    public void optionA() {
        // Display your name and tutor's name
        System.out.println("Name: Vimalnath Nambiar");
        System.out.println("Tutor's name: Vimalnath Nambiar");
    }

    // Option B
    public void optionB() {
        // Receive user input for three floating point numbers (double)
        System.out.println("Enter three double numbers");
        System.out.print("x: ");
        double x = Menu.kb.nextDouble();
        System.out.print("y: ");
        double y = Menu.kb.nextDouble();
        System.out.print("z: ");
        double z = Menu.kb.nextDouble();

        // Identify and display largest and smallest number
        double largest = Math.max(x, Math.max(y, z));
        double smallest = Math.min(x, Math.min(y, z));
        System.out.println("Largest: " + largest);
        System.out.println("Smallest: " + smallest);
    }

    // Option C
    public void optionC() {
        // Receive user input for two integer numbers
        System.out.println("Enter two integer numbers");
        System.out.print("m: ");
        int m = Menu.kb.nextInt();
        System.out.print("n: ");
        int n = Menu.kb.nextInt();

        // Initialise variables
        int start, end;
        int count = 0;
        int sum = 0;

        // Check which integer to be used as the beginning and end values
        if (m > n) {
            start = n;
            end = m;
        } else {
            start = m;
            end = n;
        }

        for (int i = start; i <= end; i++) {
            // Display integer in a single line continuously
            System.out.print(i + " ");

            // Check if integer is an odd number
            if (i % 2 != 0) {
                // Add to sum if odd
                sum += i;
            }

            // Increase count
            count++;

            // Split line if 5 integers have been displayed
            if (count % 5 == 0) {
                System.out.println();
            }
        }
        // Display sum of odd numbers
        System.out.println("\nSum of odd numbers between the two integers: " + sum);
    }

    // Option D
    public void optionD() {
        // Receive user input for three integer numbers
        System.out.println("Enter three integer numbers representing the the sides of a triangle:");
        System.out.print("Side A: ");
        int a = Menu.kb.nextInt();
        System.out.print("Side B: ");
        int b = Menu.kb.nextInt();
        System.out.print("Side C: ");
        int c = Menu.kb.nextInt();

        // Check if two sides are larger than the other
        if (a + b > c || a + c > b || b + c > a) {
            System.out.println("The sides form a triangle.");
        } else {
            System.out.println("The sides do not form a triangle.");
        }
    }

    // Option E
    public void optionE() {
        // Receive user input for an integer numbers
        System.out.println("Enter an integer to check");
        System.out.print("n: ");
        int n = Menu.kb.nextInt();

        boolean isPrime = true;

        // Check if n less greater than 1
        if (n <= 1) {
            isPrime = false;
        }

        // Check if n is divisible by 2 or other divisors
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }

        // Display result
        if (isPrime) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }

    // Option F
    public void optionF() {
        // Create an empty array to store 10 integer numbers
        int[] numArray = new int[10];

        System.out.println("Enter 10 integer numbers:");
        for (int i = 0; i < 10; i++) {
            numArray[i] = Menu.kb.nextInt();
        }

        // Initialise variable to store sum, min and max
        int sum = 0;
        int min = numArray[0];
        int max = numArray[0];

        // Identify sum, min and max
        for (int i = 0; i < numArray.length; i++) {
            sum += numArray[i];
            min = Math.min(min, numArray[i]);
            max = Math.max(max, numArray[i]);
        }

        // Calculate average
        double average = (double) sum / 10;

        // Display output
        System.out.println("Average: " + average);
        System.out.println("Lowest number: " + min);
        System.out.println("Highest number: " + max);
    }
}

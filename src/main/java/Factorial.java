import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();
        int fact = factorial(num);
        System.out.println("Factorial of " + num + " is " + fact);
        input.close();
    }

    private static int factorial(int num) {
        if (num == 0)
            return 1;
        return num * factorial(num - 1);
    }

}

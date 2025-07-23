import java.util.Scanner;

public class Baekjoon2749 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int fib = fibonacci(n);

        System.out.println(fib % 1000000);
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}
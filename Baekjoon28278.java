import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon28278 {
    static Stack<Integer> stack = new Stack<>();

    public static void addInt(int n) {
        stack.add(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    int num = sc.nextInt();
                    addInt(num);
                    continue;
                case 2:
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                    continue;
                case 3:
                    System.out.println(stack.size());
                    continue;
                case 4:
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    continue;
                case 5:
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                    continue;
                default:
                    break;
            }
        }
    }
}


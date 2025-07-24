import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Baekjoon12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> now = new LinkedList<>();
        Stack<Integer> place = new Stack<>();
        Deque<Integer> afterReceive = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int target = 1;

        for (int i = 0; i < N; i++) {
            now.add(Integer.parseInt(line.split(" ")[i]));
        }

        while (!now.isEmpty()) {
            if (target != now.peek()) {
                place.add(now.poll());
            } else {
                afterReceive.add(now.poll());
                target++;
            }
        }

        String result = "Nice";

        for (int i = afterReceive.peekLast() + 1; i <= afterReceive.peekLast() + place.size() - 1; i++) {
            if (i != place.pop()) {
                result = "Sad";
                break;
            }
        }

        System.out.println(result);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int K = Integer.parseInt(line.split(" ")[1]);
        int count = 1;
        Deque<Integer> q = new ArrayDeque<>();
        Deque<Integer> dead = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) q.add(i);

        while (!q.isEmpty()) {
            if (count == K) {
                dead.add(q.poll());
                count = 1;
            } else {
                q.add(q.poll());
                count++;
            }
        }

        System.out.print("<");
        for (int i = 0; i < N - 1; i++) {
            System.out.print(dead.poll() + ", ");
        }
        System.out.print(dead.poll() + ">");
    }
}

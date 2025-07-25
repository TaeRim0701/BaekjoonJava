
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        Deque<Integer> idx = new ArrayDeque<>();
        int target = 0;
        String line = br.readLine();

        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(line.split(" ")[i]));
            idx.add(i + 1);
        }

        while (!q.isEmpty()) {
            if (target == 1) {
                q.add(q.pollFirst());
                idx.add(idx.pollFirst());
            } else {
                for (int i = 1; i < target; i++) {
                    q.add(q.pollFirst());
                    idx.add(idx.pollFirst());
                }
            }
            sb.append(idx.pollFirst()).append(" ");
            target = q.pollFirst();

            if (target < 0) {
                target = q.size() + target;
            }
        }

        System.out.println(sb);

    }
}

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
        Deque<int[]> q = new ArrayDeque<>();
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            q.add(new int[]{Integer.parseInt(line[i]), i + 1});
        }

        int[] current = q.pollFirst();
        sb.append(current[1]).append(" ");
        int target = current[0];

        while (!q.isEmpty()) {
            if (target > 0) {
                for (int i = 1; i < target; i++) {
                    q.addLast(q.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(target); i++) { // 왜 음수일 때는 target - 1을 하지 않는지?
                    q.addFirst(q.pollLast());
                }
            }

            current = q.pollFirst();
            sb.append(current[1]).append(" ");
            target = current[0];
        }
        System.out.println(sb);
    }
}
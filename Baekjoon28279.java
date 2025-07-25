import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new ArrayDeque<Integer>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int command = Integer.parseInt(line.split(" ")[0]);

            switch (command) {
                case 1:
                    q.addFirst(Integer.parseInt(line.split(" ")[1]));
                    break;
                case 2:
                    q.addLast(Integer.parseInt(line.split(" ")[1]));
                    break;
                case 3:
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.pollFirst()).append("\n");
                    }
                    break;
                case 4:
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.pollLast()).append("\n");
                    }
                    break;
                case 5:
                    sb.append(q.size()).append("\n");
                    break;
                case 6:
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 7:
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.peekFirst()).append("\n");
                    }
                    break;
                case 8:
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}

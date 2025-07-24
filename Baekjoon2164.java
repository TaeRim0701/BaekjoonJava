import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = N; i >= 1; i--) {
            q.add(i);
        }

        while (q.size() != 1) {
            //제일 위에 카드 버리기
            q.pollLast();

            // 제일 위에 있는 카드 제일 아래로
            int tmp = q.pollLast();
            q.addFirst(tmp);
        }

        System.out.println(q.peek());
    }
}

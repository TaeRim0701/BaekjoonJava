import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon24445 {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] Visited;
    static int count;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int R = Integer.parseInt(line[2]);

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        Visited = new int[N + 1];

        for (int i = 1; i <= M ; i++) {
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 1; i <= N ; i++) {
            Collections.sort(adj.get(i), Collections.reverseOrder());
        }

        count = 1;
        BFS(R);

        for (int i = 1; i <= N ; i++) {
            System.out.println(Visited[i]);
        }

    }

    public static void BFS(int R) {
        q = new LinkedList<>();
        Visited[R] = count++;
        q.add(R);
        while (!q.isEmpty()) {
            int i = q.poll();
            for (Integer j : adj.get(i)) {
                if (Visited[j] == 0) {
                    Visited[j] = count++;
                    q.add(j);
                }
            }
        }
    }
}

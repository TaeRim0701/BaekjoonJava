import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon24479 {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] Visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int R = Integer.parseInt(line[2]);
        
        adj = new ArrayList<>();
        for (int i = 0; i <= M; i++) {
            adj.add(new ArrayList<>());
        }

        Visited = new int[N + 1];
        count = 1;

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(adj.get(i));
        }

        DFS(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(Visited[i]);
        }
    }

    public static void DFS(int start) {
            Visited[start] = count++;
            for (int i : adj.get(start)) {
                if (Visited[i] == 0) {
                    DFS(i);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2178 {
    static int N;
    static int M;
    static int [][] Miro;
    static boolean [][] Visited;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        Miro = new int[N][M];
        Visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                Miro[i][j] = Integer.parseInt(line[j]);
            }
        }
        BFS(0, 0);
        System.out.println(Miro[N-1][M-1]);
    }

    static public void BFS(int x, int y) {
        Visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            x = now[0];
            y = now[1];
            Visited[x][y] = true;

            if (x == N - 1 && y == M - 1) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M ) {
                    if (!Visited[nx][ny] && Miro[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        Miro[nx][ny] += Miro[x][y];
                    }
                }
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon1012 {
    static int N;
    static int M;
    static int [][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String [] line = br.readLine().split(" ");
            M = Integer.parseInt(line[0]);
            N = Integer.parseInt(line[1]);
            int K = Integer.parseInt(line[2]);

            field = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            while (K-- > 0) {
                line = br.readLine().split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                field[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        DFS(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void DFS(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < M && 0 <= ny && ny < N)
                if (!visited[ny][nx] && field[ny][nx] == 1) {
                    DFS(ny, nx);
                }
        }
    }
}

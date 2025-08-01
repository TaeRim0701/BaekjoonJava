import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon2667 {
    static int [][] Map;
    static boolean [][] Visited;
    static int N;
    static ArrayList<Integer> comunity;
    static int[] dx = {-1, 1, 0, 0}; //좌, 우, 상, 하
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        Visited = new boolean[N][N];
        comunity = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String [] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                Map[i][j] = Integer.parseInt(line[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(Map[i][j]);
            }
            System.out.println();
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Map[i][j] == 1 && !Visited[i][j]) {
                    comunity.add(DFS(i, j));
                }
            }
        }

        Collections.sort(comunity);

        System.out.println(comunity.size());
        for(int i : comunity) {
            System.out.println(i);
        }

    }

    public static int DFS(int x, int y) {
        Visited[x][y] = true;
        int count = 1;

        for (int i  = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <=ny && ny < N) {
                if (!Visited[nx][ny] && Map[nx][ny] == 1) {
                    count += DFS(nx, ny);
                }
            }
        }

        return count;
    }
}

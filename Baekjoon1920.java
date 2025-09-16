import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] A = new int[N];
        String line = br.readLine();
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(line.split(" ")[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int [] B = new int[M];
        line = br.readLine();
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(line.split(" ")[i]);
        }

        for (int i = 0; i < M; i++) {
            int result = 0;
            for (int j = 0; j < N; j++) {
                if (A[j] == B[i]) {
                    result = 1;
                    break;
                } else {
                    result = 0;
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}

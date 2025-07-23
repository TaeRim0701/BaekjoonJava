import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2749 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 백준에서 많은 양의 입력을 처리할 때 Scanner보다 BufferedReader가 더 효율적
        Long N = 0L;

        int M = 1_000_000;
        int P = 1_500_000; //피사노 주기 : M = 10^k 일 때, k > 2 라면, 주기는 항상 15 × 10^(k-1)

        try {
            N = Long.parseLong(br.readLine());
        } catch (IOException e) { // 입출력 오류
            System.out.println("IOException");
            System.exit(1);
        }

        int[] fibo = new int[(int)(N % P) + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = (fibo[i - 2] + fibo[i - 1]) % M;
        }

        System.out.println(fibo[(int)(N % P)]);
    }
}
import java.util.Scanner;

public class Baekjoon12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] W = new int[N + 1];
        int[] V = new int[N + 1];
        int [][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) { // 각 물건
            for (int j = 1; j <= K; j++) { // 각 무게
                if (W[i] > j) { //현재 물건을 배닝에 넣을 수 없으면
                    dp[i][j] = dp[i - 1][j]; // 이전까지의 무게를 가져오기
                } else { // 현재 물건을 배낭에 넣을 수 있으면
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                    // 이번 물건을 드는 경우, 이번 물건을 들지 않는 경우 비교해서 큰 거 insert
                }
            }
        }

        System.out.println(dp[N][K]);
        sc.close();
    }
}

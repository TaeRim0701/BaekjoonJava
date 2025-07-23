import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon28278 {
    static Stack<Integer> stack = new Stack<>();

    public static void addInt(int n) {
        stack.add(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력을 모아둘 StringBuilder

        int N = Integer.parseInt(br.readLine());;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int command = Integer.parseInt(line.split(" ")[0]);

            switch (command) {
                case 1:
                    int num = Integer.parseInt(line.split(" ")[1]);
                    addInt(num);
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 5:
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb.toString());
        br.close();
    }
}


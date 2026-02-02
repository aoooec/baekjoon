import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long cnt = 0L;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (stack.isEmpty()) {
                stack.push(num);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            cnt += stack.size();
            stack.push(num);
        }

        System.out.print(cnt);
    }
}
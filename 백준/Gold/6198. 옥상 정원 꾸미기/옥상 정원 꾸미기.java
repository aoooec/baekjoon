import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        long cnt = 0L;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peekLast() <= num) {
                stack.pollLast();
            }

            cnt += stack.size();
            stack.addLast(num);
        }

        System.out.print(cnt);
    }
}
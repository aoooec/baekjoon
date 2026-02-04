import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < N; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            String word = br.readLine();

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!stack.isEmpty() && stack.peekLast() == c) {
                    stack.pollLast();
                    continue;
                }
                stack.addLast(c);
            }

            if (stack.isEmpty()) ans++;
        }

        System.out.print(ans);
    }
}
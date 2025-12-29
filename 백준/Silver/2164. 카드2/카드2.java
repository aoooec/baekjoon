import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> cards = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            cards.offer(i);
        }

        while (cards.size() != 1) {
            cards.poll();
            int second = cards.poll();
            cards.offer(second);
        }

        System.out.print(cards.poll());
    }
}

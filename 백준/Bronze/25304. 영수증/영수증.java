import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int price = Integer.parseInt(input[0]);
            int count = Integer.parseInt(input[1]);

            sum += price * count;
        }

        System.out.println(X == sum ? "Yes" : "No");
    }
}
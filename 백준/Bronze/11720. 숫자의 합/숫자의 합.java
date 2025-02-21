import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        String input = br.readLine();
        for(int i = 0; i < N; i++) {
            sum += input.charAt(i) - '0';
        }
        System.out.print(sum);
    }
}

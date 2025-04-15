import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;
        for(int i = 0; i < 5; i++) {
            long num = Long.parseLong(br.readLine());
            sum += num;
        }
        System.out.print(sum);
    }
}
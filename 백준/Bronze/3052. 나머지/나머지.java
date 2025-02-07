import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[42];
        int answer = 0;

        for(int i = 0; i < 10; i++) {
            arr[Integer.parseInt(br.readLine()) % 42] = 1;
        }

        for(int num: arr) {
            if(num == 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
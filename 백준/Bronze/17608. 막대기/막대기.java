import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < N; i++) {
            stack.add(Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i < N; i++) {
            int num = stack.pop();
            if(max < num) {
                count++;
                max = num;
            }
        }

        System.out.println(count);
    }
}
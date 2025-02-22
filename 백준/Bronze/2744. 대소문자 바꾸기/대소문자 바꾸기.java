import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++) {
            char c = (char) (input.charAt(i) < 97 ? input.charAt(i) + 32 : input.charAt(i) - 32);
            sb.append(c);
        }
        System.out.print(sb.toString());
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stackL = new Stack<Character>();
        Stack<Character> stackS = new Stack<Character>();
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        char[] skills = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            char skill = skills[i];

            switch (skill) {
                case 'L':
                    stackL.push(skill);
                    break;
                case 'S':
                    stackS.push(skill);
                    break;
                case 'R':
                    if (stackL.isEmpty()) {
                        System.out.println(count);
                        return;
                    } else {
                        count++;
                        stackL.pop();
                    }
                    break;
                case 'K':
                    if (stackS.isEmpty()) {
                        System.out.println(count);
                        return;
                    } else {
                        count++;
                        stackS.pop();
                    }
                    break;
                default:
                    count++;
            }
        }

        System.out.println(count);
    }
}
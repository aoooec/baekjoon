import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while(!(input = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for(char c: input.toCharArray()) {
                if(c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    }

                    char left = stack.pop();

                    if(!((c == ')' && left == '(') || (c == ']' && left == '['))) {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isBalanced = false;
            }

            bw.write(isBalanced ? "yes\n" : "no\n");
        }

        bw.flush();
        bw.close();
    }
}
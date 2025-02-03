import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Stack<Integer> s = new Stack<Integer>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int num = 0;

            switch(command) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    s.push(num);
                    break;
                case "pop":
                    if (s.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(s.pop() + "\n");
                    }
                    break;
                case "size":
                    bw.write(s.size() + "\n");
                    break;
                case "empty":
                    bw.write((s.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "top":
                    bw.write((s.isEmpty() ? -1 : s.peek()) + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
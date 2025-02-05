import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last = 0;

        for(int i = 0; i < N; i++) {
            String command = br.readLine();

            switch(command) {
                case "pop":
                    bw.write((q.isEmpty() ? -1 : q.poll()) + "\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    bw.write((q.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((q.isEmpty() ? -1 : q.peek()) + "\n");
                    break;
                case "back":
                    bw.write((q.isEmpty() ? -1 : last) + "\n");
                    break;
                default:
                    int num = Integer.parseInt(command.split(" ")[1]);
                    q.add(num);
                    last = num;
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
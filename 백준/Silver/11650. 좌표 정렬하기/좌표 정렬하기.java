import java.io.*;
import java.util.*;

public class Main {
    static class Position implements Comparable<Position> {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Position[] arr = new Position[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Position(x, y);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (Position p : arr) {
            sb.append(p.x).append(' ').append(p.y).append('\n');
        }

        System.out.print(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_DISTANCE = 20 * 50;
    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        int distance(Point other) {
            return Math.abs(this.r - other.r) + Math.abs(this.c - other.c);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            Point[] points = new Point[n + 2];

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                points[i] = new Point(r, c);
            }

            sb.append(bfs(points, n) ? "happy" : "sad").append('\n');
        }

        System.out.print(sb);
    }

    static boolean bfs(Point[] points, int n) {
        boolean[] visited = new boolean[n + 2];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == n + 1) return true;

            for (int next = 0; next < n + 2; next++) {
                if (visited[next]) continue;
                if (points[cur].distance(points[next]) > MAX_DISTANCE) continue;

                q.offer(next);
                visited[next] = true;
            }
        }

        return false;
    }
}
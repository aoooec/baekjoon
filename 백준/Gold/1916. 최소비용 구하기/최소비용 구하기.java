import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class State implements Comparable<State> {
        int city, dist;

        State(int city, int dist) {
            this.city = city;
            this.dist = dist;
        }

        @Override
        public int compareTo(State o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new State(start, 0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            if (curr.dist > dist[curr.city]) continue;

            for (Node next : graph[curr.city]) {
                int nd = curr.dist + next.cost;

                if (dist[next.to] > nd) {
                    dist[next.to] = nd;
                    pq.add(new State(next.to, nd));
                }
            }
        }

        System.out.print(dist[end]);
    }
}
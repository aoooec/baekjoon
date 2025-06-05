import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 1000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 1~50
        int[][] arr = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i != j) arr[i][j] = INF;
            }
        }
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1) break;
            arr[a][b] = arr[b][a] = 1;
        }
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                if(k == i) continue;
                for(int j = 1; j <= N; j++) {
                    if(k == j || j == i) continue;
                    if(arr[i][j] > arr[i][k] + arr[k][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        int[] score = new int[N+1];
        int minScore = INF;
        for(int i = 1; i <= N; i++) {
            int maxDist = 0;
            for(int j = 1; j <= N; j++) {
                maxDist = Math.max(maxDist, arr[i][j]);
            }
            score[i] = maxDist;
            minScore = Math.min(minScore, maxDist);
        }
        List<Integer> candidates = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(score[i] == minScore) {
                candidates.add(i);
            }
        }

        System.out.println(minScore + " " + candidates.size());
        for(int c: candidates) {
            System.out.print(c + " ");
        }
    }
}
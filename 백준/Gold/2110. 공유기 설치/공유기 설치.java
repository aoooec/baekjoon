import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());        // 2~200000
        int C = Integer.parseInt(st.nextToken());        // 2 <= C <= N
        int[] houses = new int[N];
        for(int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine()); // 0~1000000000
        }
        Arrays.sort(houses);                             // 이분탐색을 위한 정렬
        int max = houses[N - 1] - houses[0];             // 집 사이의 최장 거리
        int min = 1;                                     // 최소 거리
        int ans = 0;
        while(min <= max) {
            int mid = (min + max) / 2;
            int cnt = 1;                                 // 공유기 설치 개수
            int prev = houses[0];                        // 이전 공유기 설치 위치
            for(int i = 1; i < N; i++) {
                if(houses[i] - prev >= mid) {
                    cnt++;
                    prev = houses[i];
                    if(cnt == C) break;
                }
            }
            if(cnt >= C) {
                min = mid + 1;
                ans = mid;
            } else max = mid - 1;
        }
        System.out.print(ans);
    }
}
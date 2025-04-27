import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Meeting implements Comparable<Meeting> {
        int start;
        int end;
        public  Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end) {
                return this.start - o.start; // 끝나는 시간이 같으면, 시작이 빠른 것 먼저
            }
            return this.end - o.end; // 끝나는 시간 기준 정렬 -> 가장 많은 회의
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 1~100000;
        PriorityQueue<Meeting> pq = new PriorityQueue<>(); // 오름차순 정렬

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Meeting(start, end));
        }

        int maxCnt = 0; // 최대 회의 수
        int startIdx = -1; // 다음 회의 시작 가능 시간
        while(!pq.isEmpty()) {
            Meeting m = pq.poll();
            if(startIdx > m.start) continue; // 만약 시작 가능 시간보다 회의 시간이 빠르면 넘어감
            startIdx = m.end; // 회의 종료 시간으로 startIdx 갱신
            maxCnt++; // 회의 수 증가
        }
        System.out.print(maxCnt);
    }
}
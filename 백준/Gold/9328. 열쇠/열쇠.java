import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int h, w, answer;
    static char[][] map;
    static boolean[] haveKey;
    static boolean[][] visited;
    static List<Point>[] doorQueue;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static class Point {
        int r, c;
        Point(int r, int c) { 
            this.r = r; 
            this.c = c; 
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            // 원본 맵 읽기
            char[][] raw = new char[h][w];
            for (int i = 0; i < h; i++) {
                raw[i] = br.readLine().toCharArray();
            }
            // 패딩된 맵 생성 (가장자리는 모두 '.')
            map = new char[h + 2][w + 2];
            for (char[] row : map) Arrays.fill(row, '.');
            for (int i = 0; i < h; i++) {
                System.arraycopy(raw[i], 0, map[i + 1], 1, w);
            }
            // 초기화
            haveKey = new boolean[26];
            doorQueue = new ArrayList[26]; // 잠긴 문이 있을 경우 담을 큐 
            for (int i = 0; i < 26; i++) doorQueue[i] = new ArrayList<>();
            visited = new boolean[h + 2][w + 2];
            answer = 0;

            // 초기 키 입력
            String keys = br.readLine();
            if (!keys.equals("0")) {
                for (char k : keys.toCharArray()) {
                    haveKey[k - 'a'] = true;
                }
            }

            // BFS 시작
            Queue<Point> q = new ArrayDeque<>();
            q.add(new Point(0, 0)); // 0,0에서 시작 
            visited[0][0] = true;

            while (!q.isEmpty()) {
                Point p = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];
                    // 범위, 방문 여부 체크 
                    if (nr < 0 || nc < 0 || nr >= h + 2 || nc >= w + 2) continue;
                    if (visited[nr][nc]) continue;
                    char c = map[nr][nc];
                    if (c == '*') continue;  // 벽이면 패스 
                    // 문서인 경우 정답 수 추가
                    if (c == '$') {
                        answer++;
                        map[nr][nc] = '.';
                    }
                    // 키인 경우 
                    if ('a' <= c && c <= 'z') {
                        int k = c - 'a';
                        if (!haveKey[k]) {
                            haveKey[k] = true; // 가지고 있는 키에 추가 
                            // 대기 중이던 문이 있는 경우 바로 방문, 해제후 해당 위치를 큐에 담음
                            for (Point dp : doorQueue[k]) {
                                visited[dp.r][dp.c] = true;
                                q.add(dp);
                            }
                            doorQueue[k].clear(); // 해당 알파벳의 잠긴 문 리스트 클리어
                        }
                        map[nr][nc] = '.';
                    }
                    // 문인 경우 
                    if ('A' <= c && c <= 'Z') {
                        int idx = c - 'A';
                        if (!haveKey[idx]) {
                            // 키 없으면 큐에 추가후 패스 
                            doorQueue[idx].add(new Point(nr, nc));
                            continue;
                        }
                        map[nr][nc] = '.'; // 키 있으면 문 열기
                    }
                    // 해당 위치를 방문표시하고 다음 칸으로 이동(bfs 큐에 추가)
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int R, C;
    private static char[][] map;
    private static char[][] initialState;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        // 초기 상태 저장
        map = new char[R][C];
        initialState = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                initialState[i][j] = input.charAt(j);
            }
        }
        
        if (N == 1) {
            // N=1일 때는 초기 상태 그대로 출력
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(initialState[i][j]);
                }
                sb.append("\n");
            }
        } else if(N % 2 == 0) {
            // N이 짝수일 때는 모든 칸이 폭탄
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append('O');
                }
                sb.append("\n");
            }
        } else {
            // N이 홀수이고 N >= 3인 경우
            if (N % 4 == 3) {
                // N = 3, 7, 11...일 때: 초기 상태에서 폭발
                // 먼저 모든 칸을 폭탄으로 채움
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        map[i][j] = 'O';
                    }
                }
                
                // 초기 폭탄 위치에서 폭발 처리
                visited = new boolean[R][C];
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (initialState[i][j] == 'O') {
                            check(i, j);
                        }
                    }
                }
            } else if (N % 4 == 1) {
                // N = 5, 9, 13...일 때: 두 번 폭발한 상태
                
                // 먼저 첫 번째 폭발 상태를 계산
                char[][] firstState = new char[R][C];
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        firstState[i][j] = 'O';
                    }
                }
                
                boolean[][] firstVisited = new boolean[R][C];
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (initialState[i][j] == 'O') {
                            checkForState(i, j, firstState, firstVisited);
                        }
                    }
                }
                
                // 첫 번째 폭발 상태를 기준으로 두 번째 폭발 계산
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        map[i][j] = 'O';
                    }
                }
                
                visited = new boolean[R][C];
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (firstState[i][j] == 'O') {
                            check(i, j);
                        }
                    }
                }
            }
            
            // 결과 출력
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
    
    private static void check(int r, int c) {
        visited[r][c] = true;
        map[r][c] = '.';
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc]) continue;
            map[nr][nc] = '.';
            visited[nr][nc] = true;
        }
    }
    
    private static void checkForState(int r, int c, char[][] state, boolean[][] stateVisited) {
        stateVisited[r][c] = true;
        state[r][c] = '.';
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || stateVisited[nr][nc]) continue;
            state[nr][nc] = '.';
            stateVisited[nr][nc] = true;
        }
    }
}
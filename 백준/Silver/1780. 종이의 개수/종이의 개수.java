import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] papers;
    static int[] cnt = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        papers = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        for (int c : cnt) {
            sb.append(c).append('\n');
        }

        System.out.print(sb);
    }

    static void divide(int r, int c, int size) {
        int first = papers[r][c];

        int endR = r + size;
        int endC = c + size;

        for (int i = r; i < endR; i++) {
            for (int j = c; j < endC; j++) {
                if (papers[i][j] != first) {
                    int nSize = size / 3;
                    for (int nr = 0; nr < 3; nr++) {
                        for (int nc = 0; nc < 3; nc++) {
                            divide(r + nr * nSize, c + nc * nSize, nSize);
                        }
                    }
                    return;
                }
            }
        }

        cnt[first + 1]++;
    }
}
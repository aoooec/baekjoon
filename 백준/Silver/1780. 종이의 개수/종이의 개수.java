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

        devide(0, 0, N);

        for (int c : cnt) {
            sb.append(c).append('\n');
        }

        System.out.print(sb);
    }

    static void devide(int r, int c, int size) {
        int first = papers[r][c];
        boolean isSame = true;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (papers[i][j] != first) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame) {
            addCnt(first);
            return;
        }

        int nSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                devide(r + i * nSize, c + j * nSize, nSize);
            }
        }
    }

    static void addCnt(int num) {
        switch(num) {
            case -1 : cnt[0]++; break;
            case 0 : cnt[1]++; break;
            case 1 : cnt[2]++; break;
        }
    }
}
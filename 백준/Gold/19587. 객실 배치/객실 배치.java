import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine()); // 1~10^18

        if(N == 1) {
            System.out.print(3);
            return;
        }
        long[][] base = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };

        long[][] result = matrixPow(base, N - 1);

        long A = (result[0][0] + result[0][1] + result[0][2]) % MOD;
        long B = (result[1][0] + result[1][1] + result[1][2]) % MOD;
        long C = (result[2][0] + result[2][1] + result[2][2]) % MOD;

        System.out.print((A + B + C) % MOD);
    }

    static long[][] matrixMul(long[][] a, long[][] b) {
        long[][] res = new long[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }

    static long[][] matrixPow(long[][] mat, long exp) {
        long[][] res = new long[3][3];
        for(int i = 0; i < 3; i++) res[i][i] = 1;

        while(exp > 0) {
            if((exp & 1) == 1) res = matrixMul(res, mat);
            mat = matrixMul(mat, mat);
            exp >>= 1;
        }
        return res;
    }
}

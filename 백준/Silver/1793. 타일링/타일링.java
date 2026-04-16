import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= 250; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
        }

        String s;
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            int n = Integer.parseInt(s);
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}
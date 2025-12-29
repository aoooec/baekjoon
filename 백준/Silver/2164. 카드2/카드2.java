import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int L = Integer.highestOneBit(N); // 정수의 이진수 표현에서 가장 왼쪽에 있는 1만 남김 -> N 이하의 가장 큰 2의 거듭제곱
        int answer = N == L ? N : 2 * (N - L);

        System.out.print(answer);
    }
}

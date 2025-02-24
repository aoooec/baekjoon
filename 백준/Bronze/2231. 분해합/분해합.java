import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int result = 0;
		for (int i = Math.max(1, N - 9 * String.valueOf(N).length()); i < N; i++) {
            int sum = i; // 자기 자신을 일단 가짐 
            int num = i; // 자릿수 합하는 용 

            // 각 자리수 더하기
            while (num > 0) {
                sum += num % 10; // 일의 자리 숫자 추가
                num /= 10;       // 다음 자리수로 이동
            }

            if (sum == N) {  // 분해합이 N과 같으면
                result = i;
                break;  
            }
        }
		System.out.println(result);
	}
}
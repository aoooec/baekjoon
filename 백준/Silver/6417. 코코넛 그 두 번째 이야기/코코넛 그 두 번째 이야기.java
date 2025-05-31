import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while((input = Integer.parseInt(br.readLine()))!= -1) { // 입력 종료 조건 -1
            int num = input - 1; // 원숭이 몫
            List<Integer> divisors = new ArrayList<Integer>(); // 약수 리스트
            for(int i = 2; i <= (int) Math.sqrt(num); i++) {
                if(num % i == 0) { // 약수를 담는다
                    divisors.add(i);
                    if(i != num / i) {
                        divisors.add(num / i);
                    }
                }
            }
            if (num > 1) {
                divisors.add(num);
            }
            Collections.sort(divisors, Collections.reverseOrder());
            int K = 0;
            for(int k: divisors) {
                if(divide(k)) {
                    K = k;
                    break;
                }
            }
            sb.append(input).append(" coconuts, ");
            if(K == 0) {
                sb.append("no solution");
            } else {
                sb.append(K).append(" people and 1 monkey");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static boolean divide(int divisor) {
        int tmp = input;
        for(int i = 0; i < divisor; i++) {
            if((tmp - 1) % divisor != 0) return false; // 현재 수에서 1 뺀 뒤 k등분 불가능
            int hidden = (tmp - 1) / divisor;
            tmp = tmp - 1 - hidden;
        }
        return tmp % divisor == 0;
    }
}
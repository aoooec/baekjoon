import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		boolean[] prime = new boolean[b+1];
		for(int i = 2; i*i <= b; i++) {
			if(prime[i]) continue;
			for(int j = i*i; j <= b; j+= i) {
				prime[j] = true;
			}
		}
		for(int i = a; i <= b; i++) {
			if(i < 2) continue;
			if(prime[i]) continue;
			sb.append(i).append("\n");
		}
		System.out.print(sb.toString());
	}
}
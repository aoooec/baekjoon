import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		String n1 = br.readLine();
		String n2 = br.readLine();
		
		char[] ants = new char[N1+N2];
		boolean[] fromFirst = new boolean[N1+N2];
		for(int i = 0; i < N1; i++) {
			ants[N1-1-i] = n1.charAt(i);
			fromFirst[N1-1-i] = true;
		}
		for(int i = 0; i < N2; i++) {
			ants[N1+i] = n2.charAt(i);
			fromFirst[N1+i] = false;
		}
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < ants.length-1; j++) {
				if(fromFirst[j] && !fromFirst[j+1]) {
					char temp = ants[j];
					ants[j] = ants[j+1];
					ants[j+1] = temp;
					fromFirst[j] = !fromFirst[j];
					fromFirst[j+1] = !fromFirst[j+1];
					j++;
				}
			}
		}
		System.out.println(new String(ants));
	}
}
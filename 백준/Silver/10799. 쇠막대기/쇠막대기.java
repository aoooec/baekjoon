import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int count = 0; 
		int layer = 0;
		boolean prevRight = false;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			switch(c) {
			case '(':
				layer++;
				prevRight = false;
				break;
			case ')':
				layer--;
				if(prevRight) {
					count++;
				} else {
					prevRight = true;
					count += layer;
				}
			}
		}
		System.out.print(count);
	}
}

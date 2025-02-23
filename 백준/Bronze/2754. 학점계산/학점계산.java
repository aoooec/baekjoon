import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		switch(input.charAt(0)) {
		case 'A': 
			switch(input.charAt(1)) {
			case '+': System.out.print(4.3); break;
			case '0': System.out.print(4.0); break;
			case '-': System.out.print(3.7); break;
			}
			break;
		case 'B': 
			switch(input.charAt(1)) {
			case '+': System.out.print(3.3); break;
			case '0': System.out.print(3.0); break;
			case '-': System.out.print(2.7); break;
			}
			break;
		case 'C': 
			switch(input.charAt(1)) {
			case '+': System.out.print(2.3); break;
			case '0': System.out.print(2.0); break;
			case '-': System.out.print(1.7); break;
			}
			break;
		case 'D': 
			switch(input.charAt(1)) {
			case '+': System.out.print(1.3); break;
			case '0': System.out.print(1.0); break;
			case '-': System.out.print(0.7); break;
			}
			break;
		case 'F': System.out.print(0.0);;
		}
	}
}
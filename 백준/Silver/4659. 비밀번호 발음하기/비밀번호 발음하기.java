import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean isOk = false;

        while (!input.equals("end")) {
            isOk = checkPassword(input);
            sb.append("<").append(input).append("> is ").append(isOk ? "acceptable" : "not acceptable").append(".\n");
            input = br.readLine();
        }

        System.out.print(sb);
    }

    static boolean checkPassword(String pw) {
        boolean hasVowel = false;
        int vowelCnt = 0;
        int consCnt = 0;

        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);

            boolean isVowel = isVowel(c);

            if (isVowel) {
                hasVowel = true;
                vowelCnt++;
                consCnt = 0;
            } else {
                consCnt++;
                vowelCnt = 0;
            }

            if (vowelCnt == 3 || consCnt == 3) return false;

            if (i > 0) {
                char prev = pw.charAt(i - 1);
                if (c == prev && c != 'e' && c != 'o') {
                    return false;
                }
            }
        }

        return hasVowel;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

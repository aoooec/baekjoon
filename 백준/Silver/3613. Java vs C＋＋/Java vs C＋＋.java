import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int JAVA = 0,
                    CPP = 1,
                    PLAIN = 2,
                    ERROR = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String var = br.readLine();
        int length = var.length();

        int type = checkLanguage(var, length);
        if (type == ERROR) {
            System.out.print("Error!");
            return;
        }
        if (type == PLAIN) {
            System.out.print(var);
            return;
        }

        StringBuilder sb = new StringBuilder();

        if (type == JAVA) {
            for (int i = 0; i < length; i++) {
                char c = var.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    sb.append('_');
                    sb.append((char)(c - 'A' + 'a'));
                } else {
                    sb.append(c);
                }
            }
        } else {
            boolean upperNext = false;
            for (int i = 0; i < length; i++) {
                char c = var.charAt(i);
                if (c == '_') {
                    upperNext = true;
                    continue;
                }
                if (upperNext) {
                    sb.append((char)(c - 'a' + 'A'));
                    upperNext = false;
                } else {
                    sb.append(c);
                }
            }
        }

        System.out.print(sb);
    }

    static int checkLanguage(String var, int n) {
        if (n == 0) return ERROR;

        char first = var.charAt(0);
        if (first == '_' || (first >= 'A' && first <= 'Z')) return ERROR;
        if (var.charAt(n - 1) == '_') return ERROR;

        boolean hasUpper = false;
        boolean hasUnderScore = false;

        char prev = 0;
        for (int i = 0; i < n; i++) {
            char c = var.charAt(i);

            if (c == '_') {
                hasUnderScore = true;
                if (prev == '_') return ERROR;
            } else if (c >= 'A' && c <= 'Z') {
                hasUpper = true;
            }
            prev = c;
        }

        if (hasUpper && hasUnderScore) return ERROR;
        if (hasUnderScore) return CPP;
        if (hasUpper) return JAVA;
        return PLAIN;
    }
}

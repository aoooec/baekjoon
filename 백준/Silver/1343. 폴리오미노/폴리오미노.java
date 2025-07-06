import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'X') {
                count++;
            } else {
                if (count > 0) {
                    if (count % 2 != 0) {
                        System.out.print("-1");
                        return;
                    }
                    int aCount = count / 4;
                    int bCount = (count % 4) / 2;
                    appendPolyomino(sb, "AAAA", aCount);
                    appendPolyomino(sb, "BB", bCount);
                    count = 0;
                }
                sb.append('.');
            }
        }

        if (count > 0) {
            if (count % 2 != 0) {
                System.out.println("-1");
                return;
            }
            int aCount = count / 4;
            int bCount = (count % 4) / 2;
            appendPolyomino(sb, "AAAA", aCount);
            appendPolyomino(sb, "BB", bCount);
        }

        System.out.print(sb.toString());
    }

    private static void appendPolyomino(StringBuilder sb, String pattern, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(pattern);
        }
    }
}

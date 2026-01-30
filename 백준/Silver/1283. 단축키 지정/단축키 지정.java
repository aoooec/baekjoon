import java.io.*;
import java.util.*;

public class Main {
    static boolean isAlpha(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    static int alphaIdxLower(char c) {
        char lower = Character.toLowerCase(c);
        return lower - 'a';
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[26];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] arr = line.toCharArray();

            int chosen = -1;

            for (int j = 0; j < arr.length; j++) {
                if (j == 0 || arr[j - 1] == ' ') {
                    if (!isAlpha(arr[j])) continue;
                    int idx = alphaIdxLower(arr[j]);
                    if (!used[idx]) {
                        used[idx] = true;
                        chosen = j;
                        break;
                    }
                }
            }

            if (chosen == -1) {
                for (int j = 0; j < arr.length; j++) {
                    if (!isAlpha(arr[j])) continue;
                    int idx = alphaIdxLower(arr[j]);
                    if (!used[idx]) {
                        used[idx] = true;
                        chosen = j;
                        break;
                    }
                }
            }

            if (chosen == -1) {
                sb.append(line);
            } else {
                for (int j = 0; j < arr.length; j++) {
                    if (j == chosen) sb.append('[');
                    sb.append(arr[j]);
                    if (j == chosen) sb.append(']');
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
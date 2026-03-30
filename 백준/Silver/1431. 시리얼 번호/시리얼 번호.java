import java.io.*;
import java.util.*;

public class Main {
    static class Serial implements Comparable<Serial> {
        String serial;
        int sum;

        Serial(String s) {
            this.serial = s;
            this.sum = calculateSum(s);
        }

        static int calculateSum(String s) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    sum += c - '0';
                }
            }

            return sum;
        }

        @Override
        public int compareTo(Serial o) {
            if (this.serial.length() != o.serial.length()) {
                return this.serial.length() - o.serial.length();
            }
            if (this.sum != o.sum) {
                return this.sum - o.sum;
            }

            return this.serial.compareTo(o.serial);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Serial[] serials = new Serial[N];
        for (int i = 0; i < N; i++) {
            serials[i] = new Serial(br.readLine());
        }

        Arrays.sort(serials);

        for (Serial serial : serials) {
            sb.append(serial.serial).append('\n');
        }

        System.out.print(sb);
    }
}
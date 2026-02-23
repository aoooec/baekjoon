import java.io.*;
import java.util.*;

public class Main {
    static class Student implements Comparable<Student> {
        private int a, b;

        Student(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Student o) {
            if (this.b != o.b) return this.b - o.b;
            return this.a - o.a;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        final int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Student[] students = new Student[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                students[i] = new Student(a, b);
            }

            Arrays.sort(students);

            boolean[] used = new boolean[N + 1];
            int cnt = 0;

            for (Student s : students) {
                for (int book = s.a; book <= s.b; book++) {
                    if (!used[book]) {
                        used[book] = true;
                        cnt++;
                        break;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}
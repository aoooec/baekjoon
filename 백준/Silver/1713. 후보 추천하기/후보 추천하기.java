import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100;
    static int gIdx = 0;

    static class Student implements Comparable<Student> {
        int c = 0, idx = 0, num;
        boolean isRegist = false;

        Student(int num) {
            this.num = num;
        }

        void recommend() {
            this.c++;
        }

        void remove() {
            this.c = 0;
            this.idx = 0;
            isRegist = false;
        }

        void regist() {
            this.c = 1;
            this.idx = gIdx++;
            this.isRegist = true;
        }

        @Override
        public int compareTo(Student o) {
            if (this.c == o.c) {
                return this.idx - o.idx;
            }

            return this.c - o.c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        Student[] students = new Student[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            students[i] = new Student(i);
        }

        PriorityQueue<Student> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int x = Integer.parseInt(st.nextToken());
            Student s = students[x];

            if (s.isRegist) {
                pq.remove(s);
                s.recommend();
                pq.add(s);
            } else {
                if (pq.size() == N) {
                    Student old = pq.poll();
                    old.remove();
                }
                s.regist();
                pq.add(s);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll().num);
        }

        Collections.sort(result);

        for (int num : result) {
            sb.append(num).append(' ');
        }

        System.out.print(sb);
    }
}
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new LinkedList<>();
        List<Integer> A = new ArrayList<>(); 
        List<Integer> B = new ArrayList<>(); 
        List<Integer> C = new ArrayList<>(); 

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if(type == 1) {
                int studentNum = Integer.parseInt(st.nextToken());
                int favoriteMenu = Integer.parseInt(st.nextToken());
                queue.add(new int[]{studentNum, favoriteMenu}); 
            } else {
                int servedMenu = Integer.parseInt(st.nextToken());
                int[] student = queue.poll();
                if(student[1] == servedMenu) {
                    A.add(student[0]);
                } else {
                    B.add(student[0]);
                }
            }
        }
        br.close();

        while(!queue.isEmpty()) {
            C.add(queue.poll()[0]);
        }

        Collections.sort(A);
        Collections.sort(B);
        Collections.sort(C);

        bw.write(A.isEmpty() ? "None \n" : A.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
        bw.write(B.isEmpty() ? "None \n" : B.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
        bw.write(C.isEmpty() ? "None" : C.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");

        bw.flush();
        bw.close();
    }
}
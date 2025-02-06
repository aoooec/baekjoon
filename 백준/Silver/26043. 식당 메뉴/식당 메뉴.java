import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); 

        Queue<int[]> queue = new LinkedList<>(); 
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
        }

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
                    list.get(0).add(student[0]);
                } else {
                    list.get(1).add(student[0]);
                }
            }
        }
        br.close();

        while(!queue.isEmpty()) {
            list.get(2).add(queue.poll()[0]);
        }

       for(int i = 0; i < 3; i++) {
           Collections.sort(list.get(i));

           if(list.get(i).isEmpty()) {
               bw.write("None");
           } else {
               for(int StudentNum: list.get(i)) {
                   bw.write(StudentNum + " ");
               }
           }

           bw.newLine();
       }

        bw.flush();
        bw.close();
    }
}
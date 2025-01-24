import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNM = br.readLine().split(" ");
        int N = Integer.parseInt(inputNM[0]);
        int M = Integer.parseInt(inputNM[1]);
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            int count = Integer.parseInt(br.readLine());
            String[] students = br.readLine().split(" ");

            for(int j = 0; j < count; j++) {
                if(map.containsKey(students[j])) {
                    map.put(students[j], map.get(students[j]) + 1);
                } else {
                    map.put(students[j], 1);
                }
            }
        }

        int count = 0;

        for (int value: map.values()) {
            if(value >= M) {
                count++;
            }
        }

        System.out.println(count);
    }
}
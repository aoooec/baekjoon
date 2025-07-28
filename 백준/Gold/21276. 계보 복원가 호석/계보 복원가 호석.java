import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Map<String, Integer> nameToIdx = new HashMap<>(); // 이름으로 배열 인덱스 찾음
    static String[] idxToName; // 인덱스로 이름 찾음
    static int[] inDegree; // 위상정렬을 위한 진입차수 배열
    static List<Integer>[] children; // 자식 리스트
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine()); // 1~1000
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String[] names = new String[N];
        for(int i = 0; i < N; i++) {
            names[i] = st.nextToken();
        }
        Arrays.sort(names); // 출력을 위한 정렬
        idxToName = new String[N];
        for(int i = 0; i < N; i++) {
            nameToIdx.put(names[i], i); // 이름 -> 인덱스 찾기
            idxToName[i] = names[i]; // 인덱스 -> 이름 찾기
        }
        inDegree = new int[N];
        children = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int child = nameToIdx.get(st.nextToken());
            int parent = nameToIdx.get(st.nextToken());
            inDegree[child]++;
            children[parent].add(child);
        }
        List<Integer> roots = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(inDegree[i] == 0) {
                roots.add(i);
                q.add(i);
            }
        }

        List<Integer>[] result = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            result[i] = new ArrayList<>();
        }
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next: children[curr]) {
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    result[curr].add(next);
                    q.add(next);
                }
            }
        }

        sb.append(roots.size()).append("\n");
        List<String> rootNames = new ArrayList<>();
        for(int r: roots) rootNames.add(idxToName[r]);
        sb.append(String.join(" ", rootNames)).append("\n");
        for(int i = 0; i < N; i++) {
            List<Integer> childList = result[i];
            List<String> childNames = new ArrayList<>();
            for(int c: childList) childNames.add(idxToName[c]);
            Collections.sort(childNames);
            sb.append(idxToName[i]).append(" ").append(childNames.size());
            for(String cn: childNames) {
                sb.append(" ").append(cn);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
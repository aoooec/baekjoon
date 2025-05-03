import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1~200000
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        list = new int[N];
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken()); // 1~100000
        }
        int k = (N - 1) / 2;
        int mid = quickSelect(0, N - 1, k); // 중앙값 찾기
        System.out.print(mid);
    }

    /**
     * left, right 인덱스 값을 받아 partition을 나누고 정렬
     * k는 찾으려는 중앙 인덱스값 */
    static int quickSelect(int left, int right, int k) {
        if (left == right) return list[left]; //

        int pivotIndex = partition(left, right); // 반환된 피봇 인덱스

        if (k == pivotIndex) return list[k]; // k(전체 배열의 중앙 인덱스)와 일치하면 -> 정렬 바로 종료
        else if (k < pivotIndex) return quickSelect(left, pivotIndex - 1, k); // 크면 -> 더 작은 범위만 탐색
        else return quickSelect(pivotIndex + 1, right, k); // 작으면 -> 더 큰 범위만 탐색
    }

    static int partition(int left, int right) {
        int pivot = list[right]; // 가장 끝 인덱스를 피봇으로 잡고
        int i = left;
        for (int j = left; j < right; j++) {
            if (list[j] < pivot) { // 피봇보다 j번째 값이 작은 경우
                swap(i, j); // list[i]와 list[j]의 위치를 변경 (정렬 범위 안에 넣기)
                i++; // 정렬된 안전 범위 인덱스의 값을 증가
            }
        }
        swap(i, right); // 현재 범위에서의 중앙에 피봇을 위치시킴
        return i; // 중앙 인덱스 반환
    }

    static void swap( int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }
}
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length) return 1;
        else if (arr2.length > arr1.length) return -1;
        else {
            int sum1 = 0;
            int sum2 = 0;
            for(int i = 0; i < arr1.length; i++) {
                sum1 += arr1[i];
            }
            for(int i = 0; i < arr2.length; i++) {
                sum2 += arr2[i];
                if(sum2 > sum1) return -1;
            }
            if(sum1 == sum2) return 0;
            return 1;
        }
    }
}
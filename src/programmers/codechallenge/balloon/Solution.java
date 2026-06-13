package programmers.codechallenge.balloon;

import java.util.*;

class Solution {
    public int solution(int[] a) {
        int ans = 2;
        int n = a.length;
        if(n == 1){
            return a[0];
        }
        //왼쪽에서 가장 큰 요소만 남김
        int[] left = new int[n];
        //오른쪽에서 시작해서 가장 작은 요소만 남김
        int[] right = new int[n];

        left[0] = a[0];
        right[n - 1] = a[n - 1];

        //left 채우기,
        for(int i = 1; i < n; i++){
            left[i] = Math.min(left[i - 1], a[i]);
        }
        //right 채우기
        for(int i = n - 2; i >= 0; i--){
            right[i] = Math.min(right[i + 1], a[i]);
        }


        //i - 1 번째까지 그냥 가다가 i번째에서 작은 값을 선택한다. 그 뒤는 다시 큰 값을 선택한다.
        for(int i = 1; i < n - 1; i++){
            if(left[i - 1] < a[i] && right[i + 1] < a[i]){
                continue;
            }
            ans++;
        }

        return ans;
    }
}
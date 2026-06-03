package programmers.dp.change;

import java.util.*;

class Solution {
    int DIVIDE = 1_000_000_007;
    public int solution(int n, int[] money) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        Arrays.sort(money);
        //money에 있는 돈들을 gap으로 둬서 for문 돌리면서 arr에 그것만 넣는걸로 먼저 채움
        //그럼 arr에는 단일 조합만 있을 것이고
        //그런 다음 돈 추가해서 넣는거지
        for(int mon : money){
            for(int i = mon; i <= n; i++){
                arr[i] = (arr[i] + arr[i - mon]) % DIVIDE;
            }
        }

        return arr[n] % DIVIDE;
    }
}

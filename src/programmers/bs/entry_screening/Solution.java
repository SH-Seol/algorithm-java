package programmers.bs.entry_screening;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long top = (long) n * times[times.length - 1];
        long low = 0;
        long mid = 0;
        long ans = 0;
        while(low <= top){
            mid = (top + low) / 2;
            //mid time에서 값을 파악했을 때 즉, 각 times별로 mid / times[i]를 더해주고 값을 넘으면 true
            long tmp = 0;
            //tmp에 해당 시간 mid 동안 얼마나 많은 사람 처리할 수 있는지 저장
            for(int i = 0; i < times.length; i++){
                tmp += mid / times[i];
            }
            //해당 시간 동안 처리한 사람 tmp보다 처리해야하는 사람의 수 n이 더 큰 경우
            //tmp를 키우기 위해 low를 mid로 수정
            if(n > tmp){
                low = mid + 1;
            }
            else{
                ans = mid;
                top = mid - 1;
            }
        }
        return ans;
    }
}
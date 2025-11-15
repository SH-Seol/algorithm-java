package programmers.queue.process;

import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        int[] tmp = new int[priorities.length];

        //우선순위 배열 복사
        for(int i = 0; i < tmp.length; i++){
            tmp[i] = priorities[i];
        }
        //배열 정렬 1 2 2 3
        Arrays.sort(tmp);
        int idx = tmp.length - 1;
        //q에 값 넣기 [idx 값, 우선순위 값]
        for(int i = 0; i < priorities.length; i++){
            q.add(new int[]{i, priorities[i]});
        }
        //q에서 하나씩 빼면서 tmp의 제일 위의 값과 비교하면서
        //q에 값을 인덱스와 같이 넣어야겠다.
        while(idx >= 0){
            //값을 꺼냄
            int[] ps = q.poll();
            //꺼낸 값의 우선순위가 가장 높은 경우 값을 다시 넣지 않고 idx 값을 1 감소한다.
            //이 때 만약 ps[0]값이 location과 같으면 break;
            if(ps[1] == tmp[idx]){
                answer++;
                if(ps[0] == location){
                    break;
                }
                idx--;
            }
            //꺼낸 값의 우선순위가 가장 높지 않은 경우 값을 다시 넣는다
            else{
                q.add(ps);
            }
        }

        return answer;
    }
}

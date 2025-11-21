package programmers.queue.defensegame;

import java.util.*;

import java.util.*;

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int solution(int n, int k, int[] enemy) {
        // 진행하면서 pq에 상대 적 값을 받고 만약 n - enem 이 음수면 pq에 있는 값 하나 값 빼고 k값 빼기
        int round = 0;
        for(int enem : enemy){
            if(n < enem && k == 0){
                break;
            }
            pq.add(enem);
            round++;
            if(n < enem){
                //enemy 값이 너무 커서 pq에 있는 가장 큰 값을 n - enem이 0 이상일 수 있도록 진행
                while(n <= enem){
                    if(pq.isEmpty() || k == 0){
                        break;
                    }
                    n += pq.poll();
                    k--;
                }
            }
            n -= enem;
        }
        return round;
    }
}

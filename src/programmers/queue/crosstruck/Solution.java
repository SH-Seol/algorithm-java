package programmers.queue.crosstruck;

import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //bridge_length가 위에 올라갈 수 있는 트럭 개수
        ArrayList<Integer> passed = new ArrayList<>();
        Queue<int[]> bridge = new LinkedList<>();
        int t = 0;
        int tw = 0;
        int idx = 0;
        //다리를 지난 트럭의 수가 총 트럭의 수보다 적을 때만 돌아가는 while문
        while(passed.size() < truck_weights.length){
            t++;
            //다리에 트럭이 있을 때
            if(tw != 0){
                //bridge의 선두에 달리고 있는 트럭이 다리를 빠져나가야할 경우
                //bridge에서 제거하고 tw에 truck의 무게를 제거하고 passed에 추가한다.
                if(t - bridge.peek()[1] == bridge_length){
                    int truck = bridge.poll()[0];
                    passed.add(truck);
                    tw -= truck;
                }
            }
            //다리에 다음 트럭이 들어올 수 있을 때
            if(idx < truck_weights.length && tw + truck_weights[idx] <= weight){
                //다리에 트럭을 추가하고 tw에 트럭의 무게를 추가한다.
                bridge.add(new int[]{truck_weights[idx], t});
                tw += truck_weights[idx];
                idx++;
            }
        }
        return t;
    }
}
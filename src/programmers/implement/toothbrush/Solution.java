package programmers.implement.toothbrush;

import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    int[] answer;
    String[] ref;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        ref = referral;
        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i], i);
        }
        for(int i = 0; i < seller.length; i++){
            //young, john ... 의 인덱스넘버
            //map에서는 enroll에서의 idx를 가져온다. sell에서는 referral의 name을 찾고
            int idx = map.get(seller[i]);
            int money = amount[i] * 100;
            sell(money, idx);
        }

        //이제 seller별로 map에서 찾아서 enroll해서 answer 에 90% 더해주고, 10%는 다시 메소드 호출해서 예..
        return answer;
    }
    //재귀로 하는게 사실 맞는지는 모르겠는데 일단 맞다고 생각한다. 금액, index 넘버정도인가
    //일단 위에서 for문으로 돌리면서
    void sell(int money, int idx){
        if(money / 10 == 0){
            answer[idx] += money;
            return;
        }
        //받고 referral의 idx를 찾고 걔한테 10% 금액 넘겨주면 됨. 남은건 그냥 얘가 저장하면 되고
        int rest = money / 10;
        answer[idx] += money - rest;
        //바로 위가 민호면 그냥 값만 저장 후 리턴
        if(ref[idx].equals("-")){
            return;
        }
        int next = map.get(ref[idx]);
        sell(rest, next);
    }
}
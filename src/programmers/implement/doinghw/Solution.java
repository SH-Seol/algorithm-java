package programmers.implement.doinghw;

import java.util.*;

import java.util.*;

class Solution {

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        //가장 최근에 멈춘 과제부터 시작
        Stack<String[]> rest = new Stack<>();
        int res = 0;

        //plans를 시간 순으로 정렬한다.
        Arrays.sort(plans, Comparator.comparingInt(a -> {
            String[] t = a[1].split(":");
            return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }));

        //시간을 모두 분으로 전환하고 앞의 과목 끝나는 시간과 뒤의 과목 시작 시간을 비교한다.
        for(int i = 0; i < plans.length - 1; i++){
            String[] prev = plans[i][1].split(":");
            int prevTime = Integer.parseInt(prev[0]) * 60 + Integer.parseInt(prev[1]);
            int prT = prevTime + Integer.parseInt(plans[i][2]);

            String[] curr = plans[i + 1][1].split(":");
            int crT = Integer.parseInt(curr[0]) * 60 + Integer.parseInt(curr[1]);

            //앞에 작업이 미리 끝나는 경우
            if(prT <= crT){
                answer[res] = plans[i][0];
                res++;
                int restT = crT - prT;
                //남은 시간동안 rest에서 꺼내와서 작업
                while(restT != 0 && !rest.isEmpty()){
                    String[] sub = rest.pop();
                    int subT = Integer.parseInt(sub[1]);
                    //작업을 온전히 끝낼 수 있을만큼 시간이 남은 경우
                    if(restT >= subT){
                        restT -= subT;
                        answer[res] = sub[0];
                        res++;
                    }
                    //작업을 일부 마무리 할 수 있는 경우
                    else{
                        sub[1] = String.valueOf(subT - restT);
                        restT = 0;
                        rest.add(sub);
                    }
                }
            }
            //앞에 작업이 하다가 중간에 다음 작업 진행해야 하는 경우
            else{
                rest.add(new String[]{plans[i][0], String.valueOf(prT - crT)});
            }
        }
        //rest에 이것 저것 다 하고 이제 마지막 값을 넣어줘야한다.
        answer[res] = plans[plans.length - 1][0];
        res++;

        //그냥 비교하면서 시간 남으면 그 때 rest에서 꺼내서 남은 시간만큼 하고 끝나면 answer에 넣고
        //안끝나면 시간 차감해서 다시 빼고..

        while(!rest.isEmpty()){
            String[] ans = rest.pop();
            answer[res] = ans[0];
            res++;
        }



        return answer;
    }
}
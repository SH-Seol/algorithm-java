package programmers.implement.ubaksuyeol;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //우박수열 저장 배열
    List<Double> recs = new ArrayList<>();
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        // 우박함수 진행 및 리스트에 저장
        rec((double) k);
        //값 저장
        for(int i = 0; i < ranges.length; i++){
            //시작점보다 끝점이 먼저인 경우
            if(ranges[i][0] > recs.size() + ranges[i][1] - 1){
                answer[i] = -1.0;
                continue;
            }
            //시작점과 끝점이 같은 경우
            if(ranges[i][0] == recs.size() + ranges[i][1] - 1){
                answer[i] = 0.0;
                continue;
            }
            //그 외 경우 계산 시작
            answer[i] = calc(ranges[i][0], recs.size() + ranges[i][1] - 1);
        }
        return answer;
    }
    //우박수 그리기
    public void rec(double n){
        recs.add(n);
        if(n == 1.0){
            return;
        }
        if(n % 2 == 1.0){
            rec(n * 3 + 1.0);
        }
        else{
            rec(n / 2);
        }
    }
    //시작 인덱스와 끝 인덱스를 받음 시작은 그냥 그 다음 점과 차이를 가져오는 용도일 뿐
    public double calc(int start, int end){
        double res = 0.0;
        double sp = recs.get(start);
        for(int i = start + 1; i <= end; i++){
            //이전 값이 더 큰 경우
            res += (recs.get(i) + sp) / 2;
            sp = recs.get(i);
        }
        return res;
    }
}
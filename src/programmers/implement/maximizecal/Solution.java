package programmers.implement.maximizecal;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public long solution(String expression) {
        // + - * 순이라 하자
        char[][] ops = {{'+','-','*'}, {'+','*','-'}, {'-','*','+'},{'-','+','*'}, {'*','+','-'}, {'*','-','+'}};
        List<Long> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        long answer = 0;
        //값 저장 과정
        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                nums.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                operators.add(expression.charAt(i));
            }
            else{
                sb.append(expression.charAt(i));
            }
        }
        nums.add(Long.parseLong(sb.toString()));
        for(int i = 0; i < 6; i++){
            char[] hr = ops[i];
            //우선순위대로 그냥 연산자 돌면서 hr[0]이면 그거 먼저 쫙 하고 그 다음 hr[1]이면 쫙 하고 마지막 hr[2]이면 쫙 하고
            List<Long> tempNums = new ArrayList<>(nums);
            List<Character> tempOperators = new ArrayList<>(operators);
            for(int j = 0; j < 3; j++){
                if(hr[j] == '*'){
                    int idx = 0;
                    while(idx < tempOperators.size()){
                        if(tempOperators.get(idx) == hr[j]){
                            tempNums.set(idx, tempNums.get(idx) * tempNums.get(idx + 1));
                            tempNums.remove(idx + 1);
                            tempOperators.remove(idx);
                        }
                        else{
                            idx++;
                        }

                    }
                }
                else if(hr[j] == '-'){
                    int idx = 0;
                    while(idx < tempOperators.size()){
                        if(tempOperators.get(idx) == hr[j]){
                            tempNums.set(idx, tempNums.get(idx) - tempNums.get(idx + 1));
                            tempNums.remove(idx + 1);
                            tempOperators.remove(idx);
                        }
                        else{
                            idx++;
                        }
                    }
                }
                else{
                    int idx = 0;
                    while(idx < tempOperators.size()){
                        if(tempOperators.get(idx) == hr[j]){
                            tempNums.set(idx, tempNums.get(idx) + tempNums.get(idx + 1));
                            tempNums.remove(idx + 1);
                            tempOperators.remove(idx);
                        }
                        else{
                            idx++;
                        }
                    }
                }
            }
            answer = Math.max(answer, Math.abs(tempNums.get(0)));
        }
        return answer;
    }
}

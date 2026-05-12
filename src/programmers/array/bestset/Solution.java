package programmers.array.bestset;

class Solution {
    //자연수 n개 숫자 합 s
    public int[] solution(int n, int s) {
        //숫자 15에 6이면
        if(n > s){
            return new int[]{-1};
        }

        int[] answer = new int[n];
        int tmp = s / n;
        int rest = s % n;
        for(int i = n - 1; i >= 0; i--){
            if(rest != 0){
                answer[i] = tmp + 1;
                rest--;
            }
            else{
                answer[i] = tmp;
            }

        }
        return answer;
    }
}
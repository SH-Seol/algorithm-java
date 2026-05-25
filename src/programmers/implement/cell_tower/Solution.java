package programmers.implement.cell_tower;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;

        for(int i = 0; i < stations.length; i++){
            //이미 있던 역과 시작 지점의 거리 차이가 w보다 크면 그 안에 내용들이 들어가야한다.
            int gap = stations[i] - w - start;
            if(gap > 0){
                if(gap % (2 * w + 1) != 0){
                    answer += gap / (2 * w + 1) + 1;
                }
                else{
                    answer += gap / (2 * w + 1);
                }
            }
            start = stations[i] + w + 1;
        }
        //마지막 처리
        start -= 1;
        if(start < n){
            int last = 0;
            if((n - start) % (2 * w + 1) == 0){
                last = (n - start) / (2 * w + 1);
            }
            else{
                last = (n - start) / (2 * w + 1) + 1;
            }

            answer += last;
        }

        return answer;
    }
}

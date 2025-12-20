package programmers.pccp.puzzlechallenge;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 100000;
        int end = 0;
        for(int i = 0; i < diffs.length; i++){
            start = Math.min(diffs[i], start);
            end = Math.max(end, diffs[i]);
        }
        //이분탐색
        while(start < end) {
            int lev = (start + end) / 2;
            //limit 이내로 값을 계산해내는 level인 경우
            if(calculate(diffs, times, limit, lev)){
                end = lev;
            }
            //limit 이내로 계산하지 못하는 level인 경우
            else{
                start = lev + 1;
            }
        }
        return start;
    }
    public boolean calculate(int[] diffs, int[] times, long limit, int lev) {
        long lim = 0;
        long prev = 0;
        for (int i = 0; i < diffs.length; i++) {
            if(lev < diffs[i]) {
                lim += (diffs[i] - lev) * (prev + times[i]);
            }
            lim += times[i];
            prev = times[i];
        }
        return lim <= limit;
    }
}

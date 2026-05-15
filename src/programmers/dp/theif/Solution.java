package programmers.dp.theif;

class Solution {
    //방문하면 -1
    long[][] sum;
    public long solution(int[] money) {
        long answer = 0;
        int l = money.length;
        sum = new long[l][2];
        //0번 시작 및 1번 시작
        sum[0][0] = money[0];
        sum[1][1] = money[1];
        sum[2][0] = l == 3 ? money[2] : money[2] + sum[0][0];
        sum[2][1] = money[2];

        if(l == 3){
            return Math.max(money[0], Math.max(money[1], money[2]));
        }
        if(l == 4){
            return Math.max(money[0] + money[2], money[1] + money[3]);
        }

        for(int i = 3; i < l; i++){
            sum[i][0] = Math.max(sum[i - 2][0], sum[i - 3][0]) + money[i];
            sum[i][1] = Math.max(sum[i - 2][1], sum[i - 3][1]) + money[i];
        }

        answer = Math.max(sum[l - 1][1], sum[l - 2][1]);
        answer = Math.max(answer, sum[l - 2][0]);
        answer = Math.max(answer, sum[l - 3][0]);

        return answer;
    }
}

//1이 100 2가 10 3이 20 4가 500 5가 10이면 1, 3, 5 보다 1, 4가 더 많이 먹음
//0시작이면 n-1은 도달하면 안됨
//이전 값에서 2칸 건너 뛰거나3칸 건너뛰기
//0에서 시작한건 true로 두고 시작

package programmers.dfsbfs.targetnumber;
/*
* 프로그래머스 DFS/BFS 타겟 넘버 문제
* */
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    public int dfs(int[] numbers, int target, int count, int curSum) {
        //numbers는 받은 숫자 리스트, target은 타겟넘버, count는 현재 위치 인덱스값, curSum은 지금까지의 값
        //마지막까지 도달했을 때, 이 값이 타겟넘버면 1을 리턴, 아니면 0을 리턴
        if(numbers.length == count){
            if(target == curSum){
                return 1;
            }
            else{
                return 0;
            }
        }
        int answer = 0;
        //한놈은 +한 값을 보내고, 다른 한 놈은 -한 값을 보내서 그 다음  인덱스의 넘버에 대한 값에 계산을 해야한다
        answer += dfs(numbers, target, count+1, curSum + numbers[count]);
        answer += dfs(numbers, target, count+1, curSum - numbers[count]);

        return answer;
    }
}

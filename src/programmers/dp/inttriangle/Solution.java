package programmers.dp.inttriangle;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] ans = new int[triangle.length][triangle.length];
        ans[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(j == 0){
                    ans[i][j] = ans[i - 1][j] + triangle[i][j];
                }
                else{
                    ans[i][j] = Math.max(ans[i - 1][j] + triangle[i][j], ans[i - 1][j - 1] + triangle[i][j]);
                }
            }
        }
        for(int i = 0; i < triangle.length; i++){
            answer = Math.max(answer, ans[triangle.length - 1][i]);
        }
        return answer;
    }
}

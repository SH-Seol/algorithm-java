package programmers.recursive.hanoi;

import java.util.ArrayList;

public class Solution {
    static ArrayList<int[]> sol = new ArrayList<>();
    public int[][] solution(int n) {
        int[][] answer = new int[(int) Math.pow(2, n) - 1][2];

        hanoi(n, 1, 3);

        for(int i = 0; i < sol.size(); i++) {
            answer[i] = sol.get(i).clone();
        }
        return answer;
    }
    //arraylist에 추가하는게 낫지 않나?
    public static void hanoi(int n, int start, int end) {
        if(n == 1){
            sol.add(new int[]{start, end});
            return;
        }
        hanoi(n - 1, start, 6-start-end);
        sol.add(new int[]{start, end});
        hanoi(n-1, 6-start-end, end);
    }
}

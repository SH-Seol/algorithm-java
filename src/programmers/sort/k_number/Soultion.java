package programmers.sort.k_number;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            Arrays.fill(answer, i, i + 1, result(array, commands[i]));
        }
        return answer;
    }

    public int result(int[] arr, int[] command){
        //arr를 command[0], command[1]을 통해 자르고
        int[] tmp = Arrays.copyOfRange(arr, command[0] - 1,command[1]);
        Arrays.sort(tmp);
        return tmp[command[2] - 1];

    }
}
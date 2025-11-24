package programmers.implement.howtoqueue;

import java.util.*;
class Solution {
    boolean[] visited;
    int[] result;
    long[] factorial;
    public int[] solution(int n, long k) {
        visited = new boolean[n];
        result = new int[n];
        factorial = new long[n];
        factorial[0] = 1;
        for(int i = 1; i < n; i++){
            factorial[i] = factorial[i-1] * i;
        }
        queueing(k, 0, n);
        return result;
    }
    public void queueing(long k, int depth, int n){
        if(depth == n){
            return;
        }
        long rest = k % factorial[n - depth - 1];
        k /= factorial[n - depth - 1];
        if(rest == 0){
            k--;
            rest = factorial[n - depth - 1];
        }
        int cnt = 0;
        int num = 0;
        while(true){
            if(!visited[num]){
                if(cnt == k){
                    break;
                }
                cnt++;
            }
            num++;
        }
        visited[num] = true;
        result[depth] = num + 1;
        queueing(rest, depth + 1, n);
    }
}

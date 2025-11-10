package programmers.graph.taxifee;

import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        //지점 n개 s는 시작, a는 경유, b는 도착이라 하자 fares는 비용
        int[][] arr = new int[n + 1][n + 1];
        int inf = Integer.MAX_VALUE;

        //기본 값 채우기
        for(int i = 1; i <= n; i++){
            Arrays.fill(arr[i], inf);
            arr[i][i] = 0;
        }
        for(int i = 0; i < fares.length; i++){
            arr[fares[i][0]][fares[i][1]] = fares[i][2];
            arr[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        //플로이드 알고리즘
        //1번을 거쳤을 때의 최단거리, 1,2번을 거쳤을 때의 최단거리... 해서 1,2,3,...,n을 거쳤을 때의 최단거리
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n;j++){
                for(int k = 1; k <= n; k++){
                    if(arr[j][i] == inf || arr[i][k] == inf){
                        continue;
                    }
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        int answer = arr[s][a] + arr[a][b];
        for(int i = 1; i <= n; i++){
            if(arr[s][i] == inf || arr[i][a] == inf || arr[i][b] == inf){
                continue;
            }
            answer = Math.min(arr[s][i] + arr[i][a] + arr[i][b], answer);
        }

        return answer;
    }
}

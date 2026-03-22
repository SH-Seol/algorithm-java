package programmers.codechallenge.secretcode;

import java.util.*;

class Solution {
    HashSet<int[]> hs = new HashSet<>();
    public int solution(int n, int[][] q, int[] ans) {
        int[] tmp = new int[5];
        //hs에 생성 가능한 리스트들을 다 넣음
        bt(1, n, 0, tmp, ans, q);


        return hs.size();
    }

    //depth는 1부터 n까지 지금 위치가 몇인지, cnt는 몇개의 수를 추가했는지
    public void bt(int depth, int n, int cnt, int[] arr, int[] ans, int[][] q){
        //개수를 다 채웠을 경우 q를 돌면서 ans의 개수와 비교하며 모든 조건 통과하면 추가, 아니면 return
        if(cnt == 5){
            //만들어진 arr와 q의 각 요소들을 뽑아서 비교
            for(int i = 0; i < q.length; i++){
                if(!match(arr, q[i], ans[i])){
                    return;
                }
            }
            hs.add(arr.clone());
            return;
        }
        //depth + 1 부터 n까지 값을 추가하고 배열을 넘기거나, 추가하지 않고 배열을 넘긴다.
        for(int i = depth; i <= n; i++){
            //값을 추가하고 배열을 넘긴다
            arr[cnt] = i;
            bt(i + 1, n, cnt + 1, arr, ans, q);
        }
    }

    public boolean match(int[] tmp, int[] lst, int n){
        int cnt = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(tmp[i] == lst[j]){
                    cnt++;
                }
            }
        }

        return cnt == n;
    }
}

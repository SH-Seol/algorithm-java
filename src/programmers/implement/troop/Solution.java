package programmers.implement.troop;

import java.util.*;

class Solution {
    List<Integer>[] arr;
    int[] dist;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        //그냥 destination을 시작으로 roads map에 박아놓고 연결된 곳만 visited처리해서 하면 되잖아?
        arr = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            arr[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        for(int i = 0; i < roads.length; i++){
            int from = roads[i][0];
            int to = roads[i][1];
            arr[from].add(to);
            arr[to].add(from);
        }

        //destination의 값을 시작으로 dist가 -1이면 방문 안한거임
        Queue<int[]> q = new ArrayDeque<>();
        dist[destination] = 0;
        q.add(new int[]{destination, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cd = cur[0];
            int cdis = cur[1];
            List<Integer> ls = arr[cd];
            for(int i = 0; i < ls.size(); i++){
                if(dist[ls.get(i)] != -1){
                    continue;
                }
                dist[ls.get(i)] = cdis + 1;
                q.add(new int[]{ls.get(i), cdis + 1});
            }
        }


        int[] answer = new int[sources.length];

        for(int i = 0; i < sources.length; i++){
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
}

package programmers.graph.farnode;

import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int[] dist;
    Queue<Integer> q = new ArrayDeque<>();
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        visited[1] = true;
        q.add(1);
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : graph[cur]){
                if(visited[next]){
                    continue;
                }
                visited[next] = true;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }

        }
        int answer = 0;
        int max = 0;

        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }

        for(int d : dist){
            if(d == max){
                answer++;
            }
        }
        return answer;
    }
}

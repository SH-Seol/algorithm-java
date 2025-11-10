package programmers.bf.elecdiv;

class Solution {
    public int solution(int n, int[][] wires) {
        int[][] graph = new int[n + 1][n + 1];
        int[] sum = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for(int[] w : wires) {
            graph[w[0]][w[1]] = 1;
            graph[w[1]][w[0]] = 1;
        }//graph에 간선 있는지 여부 체크

        dfs(1, graph, sum, visited);
        int answer = n;
        for(int i = 1; i <= n; i++) {//9-sum[i] sum[i]의 차이의 절대값이 가장 작은것
            sum[i]++;

            answer = Math.min(answer, Math.abs(n - 2*sum[i]));
        }
        return answer;
    }
    int dfs(int node, int[][]graph, int[] sum, boolean[] visited) {
        visited[node] = true;
        int count = 0;
        for(int i = 1; i < graph.length; i++) {
            if(graph[node][i] == 1 && !visited[i]) {
                count += 1 + dfs(i, graph, sum, visited);
            }
        }
        sum[node] = count;
        return count;
    }
}
package programmers.dfsbfs.travelroute;

import java.util.*;

class Solution {
    String[] answer;
    boolean[] visited;
    String[][] tickets;
    boolean found = false;
    public String[] solution(String[][] t) {
        tickets = t;
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        answer = new String[tickets.length + 1];
        visited = new boolean[tickets.length + 1];

        dfs("ICN", 0, answer);

        return answer;
    }
    void dfs(String ap, int depth, String[] path){
        if(found){
            return;
        }
        path[depth] = ap;
        if(depth == tickets.length){
            found = true;
            return;
        }
        for (int i = 0; i < tickets.length; i++) {

            if (visited[i]) continue;

            if (!tickets[i][0].equals(ap)) continue;

            visited[i] = true;

            dfs(
                    tickets[i][1],
                    depth + 1,
                    path
            );

            visited[i] = false;
        }
    }
}

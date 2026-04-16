package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ13023 {
    static int node, vertex = 0;
    static List<Set<Integer>> arr = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        vertex = Integer.parseInt(st.nextToken());
        visited = new boolean[node];
        for(int i = 0; i < node; i++){
            arr.add(new HashSet<>());
        }
        for(int i = 0; i < vertex; i++){
            st = new StringTokenizer(br.readLine());
            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());

            arr.get(friend1).add(friend2);
            arr.get(friend2).add(friend1);
        }
        for(int i = 0; i < node; i++){
            visited[i] = true;
            if(dfs(i, 0) == 1){
                System.out.println(1);
                return;
            }
            visited[i] = false;
        }
        System.out.println(0);
    }
    static int dfs(int num, int depth){
        if(depth >= 4){
            return 1;
        }
        //시작하는 사람과 연결된 간선의 개수만큼
        for(int n : arr.get(num)){
            //도착지에 이미 갔었다면 넘어간다
            if(!visited[n]){
                visited[n] = true;
                if(dfs(n, depth + 1) == 1){
                    return 1;
                }
                visited[n] = false;
            }
            //도착지에 간적이 없다면 방문한 후 해당 위치에 dfs를 돌린다.

        }
        return 0;
    }
}

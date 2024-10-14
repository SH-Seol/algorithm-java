package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2606 {

    static int m;
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        arr = new int[m+1][m+1];
        visited = new boolean[m+1];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        dfs(1);
        System.out.println(result);
    }
    public static void dfs(int a){
        visited[a] = true;
        for(int i = 1; i <= m; i++){
            if(arr[a][i] == 1 && !visited[i]){
                result++;
                dfs(i);
            }
        }
    }
}

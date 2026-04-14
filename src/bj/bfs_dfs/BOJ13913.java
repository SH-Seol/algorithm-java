package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ13913 {
    static StringBuilder sb = new StringBuilder();
    static int s, d;
    static Queue<int[]> q;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws Exception{
        //q를 가지고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();

        Arrays.fill(visited, -1);
        visited[s] = s;
        q.add(new int[]{s, 0});

        bfs();

        System.out.println(sb);

    }
    //도착지까지 가는데, visited를 두고 다음으로 넘어갈 때 visited[next] = now 로 해두는 것.
    //그래서 도착하면 이제 역추적을 해야하는데 나의 visited값은 before이므로 visited[now] = -1이 될 때까지 값을 모두 모은다.
    static void bfs(){
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int loc = tmp[0];
            int t = tmp[1];

            //도착한 경우 역추적 해야한다.
            if(loc == d){
                int now = loc;
                Stack<Integer> st = new Stack<>();
                sb.append(t).append("\n");
                while(now != s){
                    st.add(now);
                    now = visited[now];
                }
                st.add(s);
                while(!st.isEmpty()){
                    sb.append(st.pop()).append(" ");
                }
                return;
            }

            //tmp가 이제 10, 1 처럼 될건데 10의 다음 값에 10이 들어가야함.
            //범위 내에 방문 안한 곳이어야만 방문한다.
            if(loc + 1 < 100001 && visited[loc + 1] == -1){
                visited[loc + 1] = loc;
                q.add(new int[]{loc + 1, t + 1});
            }
            if(loc - 1 >= 0 && visited[loc - 1] == -1){
                visited[loc - 1] = loc;
                q.add(new int[]{loc - 1, t + 1});
            }
            if(loc * 2 < 100001 && visited[loc * 2] == -1){
                visited[loc * 2] = loc;
                q.add(new int[]{loc * 2, t + 1});
            }
        }

    }
}

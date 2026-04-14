package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ17071 {
    static int n, m;
    static Queue<Integer> q = new ArrayDeque<>();
    static boolean[][] visited = new boolean[500001][2];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        if(n == m){
            System.out.println(0);
            return;
        }

        q.add(n);
        visited[n][0] = true;
        //동생은 계속해서 앞으로 간다. n만큼
        //그리고 못 찾으면 -1을 반환한다.
        System.out.println(bfs());

    }
    static int bfs(){
        //동생 이동시키고 수빈이 이동시키고
        int time = 1;
        //time % 2 해서 값을 파악한다. 그 다음 visited를 건들면 된다.
        //생각해보니 그 t에 맞는 수빈이의 이동 반경이 있는데 그걸 신경을 써줘야한다.
        //q가 빌 동안이 아니라 q사이즈를 가지고 그 time에 맞는 이동을 진행을 한 뒤 파악해야한다.
        while(!q.isEmpty()){
            //동생이 이동했는데 범위를 넘어가면 -1을 리턴한다.
            m += time;
            if(m > 500000){
                return -1;
            }
            if(visited[m][time % 2]){
                return time;
            }

            int ts = q.size();

            for(int i = 0; i < ts; i++){
                //동생이 정상범위 내에 있다면 수빈이를 이동시킨다. 단 이 때도 범위를 파악해야한다.
                int loc = q.poll();

                //이동했을 떄 동생을 찾으면 그냥 리턴한다.
                if(loc + 1 == m || loc - 1 == m || loc * 2 == m){
                    return time;
                }

                if(loc + 1 <= 500000 && !visited[loc + 1][time % 2]){
                    q.add(loc + 1);
                    visited[loc + 1][time % 2] = true;
                }
                if(loc - 1 >= 0 && !visited[loc - 1][time % 2]){
                    q.add(loc - 1);
                    visited[loc - 1][time % 2] = true;
                }
                if(loc * 2 <= 500000 && !visited[loc * 2][time % 2]){
                    q.add(loc * 2);
                    visited[loc * 2][time % 2] = true;
                }
            }

            time++;
        }

        return -1;
    }
}

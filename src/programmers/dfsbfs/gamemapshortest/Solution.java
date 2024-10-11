package programmers.dfsbfs.gamemapshortest;

import java.util.Queue;
import java.util.LinkedList;

class Solution {

    //이동방향 설정
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    int answer = -1;

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        bfs(maps, visited);

        return answer;
    }

    //1이 길, 0이 벽
    public void bfs(int[][]maps, boolean[][]visited){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0,1));

        //끝에 도달할 때까지
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            //현재위치
            int curX = cur.x;
            int curY = cur.y;

            //끝점 도달
            if(curX == maps.length-1 && curY == maps[0].length -1){
                answer = cur.cnt;
                return;
            }

            for(int i = 0; i < 4; i++){
                int mX = curX + dx[i];
                int mY = curY + dy[i];

                //out of index, visited, or wall
                if(mX < 0 || mY < 0 || mX > maps.length-1 || mY > maps[0].length-1|| visited[mX][mY] || maps[mX][mY] == 0){
                    continue;
                }
                //normal case
                else{
                    queue.add(new Node(mX, mY, cur.cnt + 1));
                    visited[mX][mY] = true;
                }
            }
        }

    }

    public class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
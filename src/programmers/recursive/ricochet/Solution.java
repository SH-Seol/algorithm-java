package programmers.recursive.ricochet;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    char[][] arr;
    int cnt = 0;
    boolean[][] isVisited;
    boolean find = false;
    Queue<int[]> q = new LinkedList<>();
    int gx, gy, rx, ry = 0;
    public int solution(String[] board) {
        arr = new char[board.length][board[0].length()];
        isVisited = new boolean[board.length][board[0].length()];
        //r, g 값 찾아서 저장. 값 설정
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                arr[i][j] = board[i].charAt(j);
                if(arr[i][j] == 'G'){
                    gx = i;
                    gy = j;
                }
                if(arr[i][j] == 'R'){
                    rx = i;
                    ry = j;
                }
            }
        }
        //bfs 시작
        bfs(rx, ry);
        int answer = cnt == 0 ? -1 : cnt;

        return answer;
    }
    public void bfs(int x, int y){
        q.add(new int[]{x, y, 0});
        isVisited[x][y] = true;
        int ans = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cr = cur[2];
            if(cx == gx && cy == gy){
                cnt = cr;
                break;
            }
            //상 벽이거나 범위 외일 때 까지 x를 깎는다
            for(int i = cx; i >= 0; i--){
                if(arr[i][cy] == 'D'){
                    if(!isVisited[i + 1][cy]){
                        isVisited[i + 1][cy] = true;
                        q.add(new int[]{i + 1, cy, cr + 1});
                    }
                    break;
                }
                if(i == 0){
                    if(!isVisited[i][cy]){
                        isVisited[i][cy] = true;
                        q.add(new int[]{i, cy, cr + 1});
                        break;
                    }
                }
            }
            //하
            for(int i = cx; i < arr.length; i++){
                if(arr[i][cy] == 'D'){
                    if(!isVisited[i - 1][cy]){
                        isVisited[i - 1][cy] = true;
                        q.add(new int[]{i-1, cy, cr + 1});
                    }
                    break;
                }
                if(i == arr.length - 1){
                    if(!isVisited[i][cy]){
                        isVisited[i][cy] = true;
                        q.add(new int[]{i, cy, cr + 1});
                    }
                }
            }
            //좌
            for(int i = cy; i >= 0; i--){
                if(arr[cx][i] == 'D'){
                    if(!isVisited[cx][i + 1]){
                        isVisited[cx][i + 1] = true;
                        q.add(new int[]{cx, i + 1, cr + 1});
                    }
                    break;
                }
                if(i == 0){
                    if(!isVisited[cx][i]){
                        isVisited[cx][i] = true;
                        q.add(new int[]{cx, i, cr + 1});
                    }
                }
            }
            //우
            for(int i = cy; i < arr[0].length; i++){
                if(arr[cx][i] == 'D'){
                    if(!isVisited[cx][i - 1]){
                        isVisited[cx][i - 1] = true;
                        q.add(new int[]{cx, i - 1, cr + 1});
                    }
                    break;
                }
                if(i == arr[0].length - 1){
                    if(!isVisited[cx][i]){
                        isVisited[cx][i] = true;
                        q.add(new int[]{cx, i, cr + 1});
                    }
                }
            }
        }
    }
}
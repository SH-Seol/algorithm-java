package programmers.dfsbfs.travelisland;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    int[][] map;
    boolean[][] isVisited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int cnt = 0;
    List<Integer> list = new ArrayList<>();
    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        isVisited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(!(maps[i].charAt(j) == 'X')){
                    map[i][j] = Integer.parseInt(String.valueOf(maps[i].charAt(j)));
                }
            }
        }
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(!isVisited[i][j] && map[i][j] != 0){
                    bfs(i, j);
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        if(list.size() == 0){
            answer = new int[]{-1};
        }
        Arrays.sort(answer);
        return answer;
    }
    public void bfs(int x, int y){
        if(map[x][y] == 0 || isVisited[x][y]) {
            return;
        }
        isVisited[x][y] = true;
        cnt+= map[x][y];
        for(int i = 0; i < 4; i++){
            if(x + dx[i] < 0 || x + dx[i] >= map.length ||
                    y + dy[i] < 0 || y + dy[i] >= map[0].length ||
                    isVisited[x + dx[i]][y + dy[i]]){
                continue;
            }
            bfs(x + dx[i], y + dy[i]);
        }
    }
}
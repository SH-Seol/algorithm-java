package programmers.dfsbfs.distancechecking;

class Solution {
    int[] answer = new int[5];
    char[][] map = new char[5][5];
    boolean[][] visited = new boolean[5][5];
    boolean flag = false;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int[] solution(String[][] places) {
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    map[j][k] = places[i][j].charAt(k);
                }
            }
            //설정 완료 그냥 p찾으면 2번만 넘어가보는 bfs나 dfs 아무거나 구현하면 됨
            flag = false;
            find: for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(map[j][k] == 'P'){
                        visited = new boolean[5][5];
                        dfs(0, j, k, j, k);
                        if(flag){
                            break find;
                        }
                    }
                }
            }
            answer[i] = flag ? 0 : 1;
        }
        return answer;
    }
    public void dfs(int cnt, int x, int y, int sx, int sy){
        if(flag == true){
            return;
        }
        if(x < 0 || y < 0 || x >= 5 || y >= 5){
            return;
        }
        if(map[x][y] == 'X' || visited[x][y]){
            return;
        }
        if(cnt != 0){
            if(map[x][y] == 'P'){
                flag = true;
                return;
            }
        }
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            if(cnt + 1 == 3){
                break;
            }
            if(x + dx[i] == sx && y + dy[i] == sy){
                continue;
            }
            dfs(cnt + 1, x + dx[i], y + dy[i], sx, sy);
        }
    }
}

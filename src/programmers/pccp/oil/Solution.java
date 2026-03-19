package programmers.pccp.oil;

import java.util.*;
class Solution {
    int[][] visited;//방문 여부 알려주는 시추판
    int[][] newLand;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int num = 1;
    HashMap<Integer, Integer> hm = new HashMap<>(); //각 시추스팟의 크기 저장
    HashSet<Integer>[] ls;//land 구역에 시추 꽂을 때 몇번 시추스팟을 걸치는지 저장

    public int solution(int[][] land) {
        visited = new int[land.length][land[0].length];//각 위치에 맞는
        newLand = land;//기름이 있으면 1이고 없으면 0임
        ls = new HashSet[land[0].length];
        for(int i = 0; i < land[0].length; i++){
            ls[i] = new HashSet<>();
        }
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[i].length; j++){
                if(land[i][j] == 1 && visited[i][j] == 0){
                    int size = bfs(i, j, num);
                    hm.put(num, size);
                    num++;
                }
            }
        }
        //값 도출 과정
        int answer = 0;
        for(int i = 0; i < ls.length; i++){
            int temp = 0;
            if(ls[i].isEmpty()){
                continue;
            }
            for(int s : ls[i]){
                if(hm.containsKey(s)){
                    temp += hm.get(s);
                }
            }
            answer = Math.max(answer, temp);
        }
        return answer;
    }

    //num은 시추 스팟 넘버링 1부터 시작
    public int bfs(int x, int y, int num){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        ls[y].add(num);
        visited[x][y] = num;
        int cnt = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                //범위가 벗어난 경우
                if(nx >= newLand.length || nx < 0 || ny < 0 || ny >= newLand[0].length){
                    continue;
                }
                //방문했거나 기름이 없는 경우
                if(visited[nx][ny] != 0 || newLand[nx][ny] == 0){
                    continue;
                }
                //그 외에는 방문
                visited[nx][ny] = num;
                q.add(new int[]{nx, ny});
                ls[ny].add(num);
                cnt++;
            }
        }

        return cnt;
    }
}

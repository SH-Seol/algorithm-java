package programmers.codechallenge.cars;

class Solution {
    char[][] chars;
    boolean[][] visited;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int ans = 0;
    public int solution(String[] storage, String[] requests) {
        chars = new char[storage.length][];
        for(int i = 0; i < storage.length; i++){
            chars[i] = storage[i].toCharArray();
        }
        ans = chars.length * chars[0].length;
        visited = new boolean[chars.length][chars[0].length];
        for(int i = 0; i < requests.length; i++){
            //지게차
            if(requests[i].length() == 1){
                for(int j = 0; j < chars.length; j++){
                    forklift(requests[i].charAt(0), j, 0);
                    forklift(requests[i].charAt(0), j, chars[0].length - 1);
                }
                for(int j =0; j < chars[0].length; j++){
                    forklift(requests[i].charAt(0), 0, j);
                    forklift(requests[i].charAt(0), chars.length - 1, j);
                }
            }
            //크레인을 사용해야할 경우
            else{
                crane(requests[i].charAt(0));
            }
            visited = new boolean[chars.length][chars[0].length];
        }
        return ans;
    }

    public void forklift(char ch, int x, int y){
        if(x < 0 || y < 0 || x >= chars.length || y >= chars[0].length || visited[x][y]){
            return;
        }
        if(chars[x][y] == '-'){
            visited[x][y] = true;
            for(int i = 0; i < 4; i++){
                forklift(ch, x + dx[i], y + dy[i]);
            }
        }
        else if(chars[x][y] != ch){
            return;
        }
        else if(chars[x][y] == ch){
            chars[x][y] = '-';
            visited[x][y] = true;
            ans--;
            return;
        }

    }

    public void crane(char ch){
        for(int i = 0; i < chars.length; i++){
            for(int j = 0; j < chars[0].length; j++){
                if(chars[i][j] == ch){
                    chars[i][j] = '-';
                    ans--;
                }
            }
        }
    }
}
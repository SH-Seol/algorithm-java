package bj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16935 {
    static int n, m, t;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; i++){
            int command = Integer.parseInt(st.nextToken());
            map = simul(command);
        }
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
    static int[][] simul(int c){
        int[][] tmpMap;
        int n = map.length;
        int m = map[0].length;
        //1번 상하반전
        if(c == 1){
            //n= 6이면 0~5까지 012 543 바꿔주면 된다. i = 0; i < n/2; i++
            tmpMap = new int[n][m];
            for(int i = 0; i < n/2; i++){
                for(int j = 0; j < m; j++){
                    tmpMap[i][j] = map[n - i - 1][j];
                    tmpMap[n - i - 1][j] = map[i][j];
                }
            }
        }
        //2번 좌우반전
        else if(c == 2){
            //m = 8이면 0~7까지 0123 7654 바꿔주면 된다.i = 0; i < m/2; i++
            tmpMap = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j< m/2; j++){
                    tmpMap[i][j] = map[i][m - 1 - j];
                    tmpMap[i][m - 1 - j] = map[i][j];
                }
            }

        }
        //3번 오른쪽 90도
        else if(c == 3){
            tmpMap = new int[m][n];//8 x 6 사이즈
            //배열 새로 만들고 그냥 딥카피하는게 맞겠는데 ㅋㅋ
            //map[i][j]가 tmpMap의 끝으로 가는 기묘한 그러므로 0,0 -> 0, 5 | 0, 7 -> 7, 5
            //1,0 ->0, 4 | 1, 3 -> 3, 4 로 간다.
            //즉 y의 위치가 그대로 x로 가고 x의 위치가 n-x의 위치로 가네
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    tmpMap[j][n - 1 - i] = map[i][j];
                }
            }
        }
        //4번 왼쪽 90도
        else if(c == 4){
            tmpMap = new int[m][n];
            //여긴 반대로 0,0 -> 7, 0 | 1, 0 -> 7, 1 || 0, 2 -> 5, 0
            //2, 1 -> 6, 2
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    tmpMap[m - 1 - j][i] = map[i][j];
                }
            }
        }
        //5번 시계방향으로 n/2 x m/2 배열을 이동
        else if(c == 5){
            tmpMap = new int[n][m];
            //이거 각자 객체로 나누고 붙인다음에 아니면 for문 4번 돌리는건데
            //2사분면은 1사분면으로
            for(int i = 0; i < n/2; i++){
                for(int j = 0; j < m/2; j++){
                    tmpMap[i][j + m/2] = map[i][j];
                }
            }
            //1사분면을 4사분면으로
            for(int i = 0; i < n/2; i++){
                for(int j = m/2; j < m; j++){
                    tmpMap[i + n/2][j] = map[i][j];
                }
            }
            //4 -> 3
            for(int i = n/2; i < n; i++){
                for(int j = 0; j < m/2; j++){
                    tmpMap[i - n/2][j] = map[i][j];
                }
            }
            for(int i = n/2; i < n; i++){
                for(int j = m/2; j < m; j++){
                    tmpMap[i][j - m/2] = map[i][j];
                }
            }
        }
        //6번 반시계방향으로 m/2 x n/2 배열을 이동
        else{
            tmpMap = new int[n][m];
            //
            for(int i = 0; i < n/2; i++){
                for(int j = 0; j < m/2; j++){
                    tmpMap[i + n/2][j] = map[i][j];
                }
            }
            for(int i = 0; i < n/2; i++){
                for(int j = m/2; j < m; j++){
                    tmpMap[i][j - m/2] = map[i][j];
                }
            }
            for(int i = n/2; i < n; i++){
                for(int j = 0; j < m/2; j++){
                    tmpMap[i][j + m/2] = map[i][j];
                }
            }
            for(int i = n/2; i < n; i++){
                for(int j = m/2; j < m; j++){
                    tmpMap[i - n/2][j] = map[i][j];
                }
            }
        }
        return tmpMap;
    }

}

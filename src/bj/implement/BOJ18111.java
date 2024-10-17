package bj.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int m;
        int b;
        int max = 0;
        int min = 256;
        int std = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());//먼저 가지고 있는 블록 수
        int[][] arr = new int[n][m];
        // 값 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        int [][] arr1 = new int[max-min+1][2];
        for(int i = min; i <= max; i++) {//최소가 32, 최대가 64면 i는 33개만큼 돌아감 여기의 값이 기준이 될 것
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(arr[j][k] >= i){//해당 인덱스의 값이 더 큰 경우 즉 블록을 제거해야하는 경우
                        arr1[i-min][0] += 2*(arr[j][k] - i);//시간 추가
                        arr1[i-min][1] -= arr[j][k] - i;//필요 블록수에 일단 제거
                    }
                    else{//블록을 쌓는 경우
                        arr1[i-min][0] += (i - arr[j][k]);//추가 시간 추가
                        arr1[i-min][1] += (i - arr[j][k]);//필요 블록수 추가
                    }
                }
            }
            if(i > min){//잘못됨
                if(arr1[i-min][0] <= arr1[i-min-1][0]){//걸리는 시간 비교 현재가 더 시간이 적게 걸리는 경우
                    std = i;
                }
            }
            else{
                std = min;
            }
        }
        //우리가 알고 싶은건 채워야할 때 즉 최종 값이 쌓아야할 필요가 있는 경우 필요 블록수보다 b가 더 크면 된다.
        if(b >= arr1[std-min][1]){//1
            System.out.printf("%d %d", arr1[std-min][0], std);
        }
        else{//블록이 적은 상황, 최대한 블록을 사용해보는 방법으로 가야한다.다시, std보다 작은 값에서 최대로 블록 사용한 값을 주면 된다.
            if(std-min == 0){
                System.out.printf("%d %d", arr1[std-min][0], std);
            }
            else{
                for(int i = std-min-1; i >= 0; i--){
                    if(arr1[i][1] <= b){
                        System.out.printf("%d %d", arr1[i][0], i + min);
                        break;
                    }
                }
            }
        }
    }
}

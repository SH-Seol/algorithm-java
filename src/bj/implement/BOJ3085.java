package bj.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3085 {
    //전역변수는 사용하지 말자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        boolean flag = false;
        char[][] arr = new char[n][n];

        //아이템 채우는 과정
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }
        res = count(arr, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i < n-1){
                    swap(arr, i, j, i+1, j);
                    res = Math.max(res, count(arr, n));
                    if(res == n){
                        flag = true;
                        break;
                    }
                    swap(arr, i, j, i+1, j);
                }

                if(j < n-1){
                    swap(arr, i, j, i, j+1);
                    res = Math.max(res, count(arr, n));
                    if(res == n){
                        flag = true;
                        break;
                    }
                    swap(arr, i, j, i, j+1);
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(res);
    }
    //swap 함수
    public static void swap(char[][]arr , int i, int j, int k, int l) {
        //i, j 현재, k, l 이후
        char tmp = arr[i][j];
        arr[i][j] = arr[k][l];
        arr[k][l] = tmp;
    }
    //count 함수
    public static int count(char[][]arr, int n){
        int res = 0;
        //가로
        for(int i = 0; i < n; i++){
            int cntX = 1;
            int cntY = 1;
            for(int j = 0; j < n-1; j++){
                if(arr[i][j] == arr[i][j+1]){
                    cntX++;
                }
                else{
                    res = Math.max(res, cntX);
                    cntX = 1;
                }

                if(arr[j][i] == arr[j+1][i]){
                    cntY++;
                }
                else{
                    res = Math.max(res, cntY);
                    cntY = 1;
                }
            }
            res = Math.max(res, cntX);
            res = Math.max(res, cntY);
        }
        return res;
    }

}

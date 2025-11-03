package bj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        int[] tmp = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){//처음 값 그대로 받기
            tmp[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());
            arr[0] = Math.min(tmp[1] + first, tmp[2] + first);
            arr[1] = Math.min(tmp[0] + second, tmp[2] + second);
            arr[2] = Math.min(tmp[0] + third, tmp[1] + third);
            tmp[0] = arr[0];
            tmp[1] = arr[1];
            tmp[2] = arr[2];
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            result = Math.min(result, arr[i]);
        }

        System.out.println(result);
        br.close();
    }
}

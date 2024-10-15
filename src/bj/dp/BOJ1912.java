package bj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    static int[] arr;
    static int[] memo;
    static int[] tmp;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        memo = new int[m];
        tmp = new int[m];

        memo[0] = tmp[0] = arr[0];

        //내가 필요로 하는 것 이전값과 현재값을 더하는, 따라서 memo가 필요함
        //그리고 memo값들을 비교해서 더 큰 값을 저장하기 위한 tmp가 필요
        for (int i = 1; i < m; i++) {
            memo[i] = Math.max(arr[i] + memo[i - 1], arr[i]);
            tmp[i] = Math.max(tmp[i-1], memo[i]);
        }

        System.out.println(tmp[m-1]);
    }
}

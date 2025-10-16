package bj.bt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ15663 {
    static boolean[] isUsed;//숫자 사용 여부 파악
    static int n, m;
    static int[] arr;//숫자들 받을 array
    static int[] res;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        isUsed = new boolean[n];
        res = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        result(0);
        System.out.println(sb.toString());
    }
    static void result(int depth){
        if(depth == m){
            for(int i = 0; i < m; i++){
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev = -1;
        for(int i = 0; i < n; i++){
            if(isUsed[i] || arr[i] == prev){
                continue;
            }
            prev = arr[i];
            isUsed[i] = true;
            res[depth] = arr[i];
            result(depth+1);
            isUsed[i] = false;
            res[depth] = 0;
        }
    }
}

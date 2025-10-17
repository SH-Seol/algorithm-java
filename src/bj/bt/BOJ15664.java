package bj.bt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15664 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        res = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        result(0, 0);

        System.out.println(sb.toString());
    }
    static void result(int depth, int start){
        if(depth == m){
            for(int i = 0; i < m; i++){
                sb.append(res[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev = -1;
        for(int i = start; i < n; i++){
            if(prev == arr[i]){//이전 값과 같은 값이 온 경우
                continue;
            }
            res[depth] = arr[i];
            prev = arr[i];
            result(depth + 1, i + 1);
        }
    }
}

package bj.bt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ15665 {
    static int n,m;
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static Object[] arr;
    static Object[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        res = new Object[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        arr = set.toArray();
        Arrays.sort(arr);
        result(0);
        System.out.println(sb.toString());
    }
    static void result(int depth){
        if(depth == m){//개수를 다 채운 경우
            for(int i = 0; i < m; i++){
                sb.append(res[i].toString());
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        //같은 수를 여러번 골라도 되는데, 중복은 발생하면 안된다
        for(int i = 0; i < arr.length; i++){
            res[depth] = arr[i];
            result(depth+1);
            res[depth] = null;
        }
    }
}

package bj.bt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15666 {
    static int n,m;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> sorted = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        sorted = list.stream().distinct().sorted()
                .toList();;//중복 요소 제거 후 정렬

        result(0, 0);

        System.out.println(sb.toString());
    }
    static void result(int depth, int start){
        if(depth == m){
            for(int i : arr){
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < sorted.size(); i++){
            arr[depth] = sorted.get(i);
            result(depth+1, i);
        }
    }
}

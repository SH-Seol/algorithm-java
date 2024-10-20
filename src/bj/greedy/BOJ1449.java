package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1449 {
    public static void main(String[] args) throws IOException {
        int num;
        int tape;
        double start = 0;
        int result = 0;

        //값을 받고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        tape = Integer.parseInt(st.nextToken());

        float[] spot = new float[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            spot[i] = Integer.parseInt(st.nextToken());
        }

        //값을 정렬하고
        Arrays.sort(spot);
        start = spot[0] - 0.5;//시작점
        //순차적으로 넘기고
        for(int i = 0; i < num; i++) {
            if(start + tape < spot[i]){
                result++;
                start = spot[i] - 0.5;
            }
            if(i == num-1){
                result++;
            }
        }

        System.out.println(result);
    }
}

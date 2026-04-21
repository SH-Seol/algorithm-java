package bj.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961 {
    static int n, sour = 0;
    static int bitter = 1;
    static int[] bits;
    static int[] sours;
    //bitter는 곱하고 sour은 더하고
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        bits = new int[n];
        sours = new int[n];
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            bits[i] = Integer.parseInt(st.nextToken());
            sours[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < (1 << n); i++){
            bitter = 1;
            sour = 0;
            for(int j  = 0; j < n; j++){
                //true면 포함
                if((i & (1 << j)) != 0){
                    bitter *= bits[j];
                    sour += sours[j];
                }
            }
            result = Math.min(result, Math.abs(bitter - sour));
        }
        System.out.println(result);
    }
}

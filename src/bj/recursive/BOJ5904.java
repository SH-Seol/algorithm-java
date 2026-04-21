package bj.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5904 {
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long tmp = 3;
        int cnt = 0;

        while(n >= tmp){
            cnt++;
            tmp = tmp * 2 + cnt + 3;
        }
        //9인 경우 cnt = 1, tmp = 10일 것

        System.out.println(rec(cnt, n, tmp));
    }
    //몇층인지, 몇번째인지
    static char rec(int cnt, long at, long tmp){
        //9인 경우 half = 3
        long half = (tmp - (cnt + 3)) / 2; // 25, 2의 경우 10
        //앞부분인 경우
        if(at <= half){
            return rec(cnt - 1, at, half);
        }
        //뒷부분인 경우 9 -> 2
        else if(at > tmp - half){
            return rec(cnt - 1, at - half - cnt - 3, half);
        }
        //중간에 있을 때
        else{
            if(at - half == 1){
                return 'm';
            }
            else{
                return 'o';
            }
        }
    }
}

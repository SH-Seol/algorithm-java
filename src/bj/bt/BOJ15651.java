package bj.bt;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ15651 {
    static int length, count;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        count = sc.nextInt();
        arr = new int[count];
        backtracking( 0);

        bw.flush();
        bw.close();
    }
    static void backtracking(int cnt) throws IOException {
        if(cnt == count){
            for(int val: arr){
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0; i<length; i++){
            arr[cnt] = i + 1;
            backtracking(cnt + 1);
        }
    }
}

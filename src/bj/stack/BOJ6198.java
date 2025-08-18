package bj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int towerNum = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        long res = 0;

        for(int i=0;i<towerNum;i++){
            int num = Integer.parseInt(br.readLine());
            while(!stack.isEmpty()&&stack.peek()[0] <= num){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(new int[]{num,1});
            }
            else{
                res += stack.peek()[1];
                stack.push(new int[]{num,stack.peek()[1] + 1});
            }

        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}

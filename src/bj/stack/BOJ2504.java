package bj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int res = 0;
        int tmp = 1;
        boolean isContinuous = false;
        String st = br.readLine();
        for (int i = 0; i < st.length(); i++) {
            //스택이 비었는데 닫는 괄호가 들어오는 경우
            if(stack.isEmpty() && (st.charAt(i) == ']' || st.charAt(i) == ')')){
                res = 0;
                break;
            }
            //스택이 비어져 있지 않은 경우 닫는 괄호가 들어오는 경우
            else if(!stack.isEmpty() && st.charAt(i) == ']'){
                if(stack.peek() == '('){
                    res = 0;
                    break;
                }
                else{//짝이 맞은 경우
                    stack.pop();
                    if(!isContinuous){
                        res += tmp;
                    }
                    tmp /= 3;
                    isContinuous = true;
                }
            }
            else if(!stack.isEmpty() && st.charAt(i) == ')'){
                if(stack.peek() == '['){
                    res = 0;
                    break;
                }
                else{
                    stack.pop();
                    if(!isContinuous){
                        res += tmp;
                    }
                    tmp /= 2;
                    isContinuous = true;
                }
            }
            //여는 괄호가 들어오는 경우
            else{
                if(st.charAt(i) == '['){
                    tmp *= 3;
                    stack.push(st.charAt(i));
                    isContinuous = false;
                }
                else if(st.charAt(i) == '('){
                    tmp *= 2;
                    stack.push(st.charAt(i));
                    isContinuous = false;
                }
            }
        }
        res = !stack.isEmpty() ? 0 : res;
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}

package bj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10799 {
    //(가 )가 바로 앞에 왔었거나 처음 들어오는 경우는 가중치에 변화가 없다. ( 가 연속으로 늘어나면 tmp를 늘린다.
    //)가 와서 끊기면 tmp를 더해주고 다음에 다시 또 )가 오면 1을 더해주고 tmp에 1을 빼준다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tmp = 0;
        int res = 0;
        boolean isContinue = true;

        String letters = br.readLine();

        for(int i=0;i<letters.length();i++){
            char c = letters.charAt(i);
            if(c == ')'){
                if(isContinue){
                    res++;
                    tmp--;
                }
                else{
                    res  += tmp;
                    isContinue = true;
                }
            }
            else if(c == '('){
                if(isContinue){
                    isContinue = false;
                }
                else{
                    tmp++;
                }
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}

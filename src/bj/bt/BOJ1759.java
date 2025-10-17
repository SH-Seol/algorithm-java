package bj.bt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    static int n,m;
    static char[] chars;
    static char[] res;
    static int ja = 0;
    static int mo = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());//비밀번호 길이 4
        m = Integer.parseInt(st.nextToken());//알파벳 개수 6
        chars = new char[m];//조합 가능한 알파벳 모음
        res = new char[n];//조합된 알파벳 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        result(0, 0);
        System.out.println(sb.toString());
    }
    static void result(int depth, int start){//증가배열에 맞춰 내용 추가만 하면 됨 추가로 aeiou1개 이상, 자음 2개 이상이라 한다 ㅋㅋ
        //depth 다 채웠을 때 자음 모음 개수 확인하고 넘기면 됨
        if(depth == n){//
            if(ja > 1 && mo > 0){
                for(int i = 0; i < n; i++){
                    sb.append(res[i]);
                }
                sb.append("\n");
            }
            return;
        }
        char prev = ' ';
        boolean isMo = false;
        for(int i = start; i < m; i++){//원인 발견, ja, mo가 증가만 함 값이 빠지면 줄어들기도 해야함
            res[depth] = chars[i];
            prev = chars[i];
            if(prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u'){
                mo++;
                isMo = true;
            }
            else{
                ja++;
                isMo = false;
            }
            result(depth+1, i + 1);//depth + 1은 값을 넣고 다음으로 보낸 내용 안넣었으면 그냥 for문으로 다음으로 넘어가는게 맞음
            if(isMo){
                mo--;
            }
            else{
                ja--;
            }
        }
    }
}

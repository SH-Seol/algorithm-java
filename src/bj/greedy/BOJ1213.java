package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int n = arr.length;//4
        int mid = (n-1)/2;//중앙값
        int isOdd = 0;
        char[] result = new char[n];
        int count = 0;

        int[]cnt = new int[26];//알파벳 개수
        for (int i = 0; i < n; i++) {
            cnt[arr[i] - 'A']++;
        }
        for(int i = 0; i < 26; i++){
            int tmp = cnt[i] / 2;
            if(cnt[i] == 0){
                continue;
            }
            else if(cnt[i] == 1){
                isOdd++;
                if(result[mid] != '\u0000'){
                    break;
                }
                else{
                    result[mid] = (char)(i+'A');
                }
            }
            else{
                if(cnt[i] % 2 == 1){
                    isOdd++;
                    if(result[mid] != '\u0000'){
                        break;
                    }
                    else{
                        result[mid] = (char)(i+'A');
                        for(int j = count; j < count + tmp; j++){
                            result[j] = (char) (i + 'A');
                            result[n-1-j] = (char) (i + 'A');
                        }
                    }
                }//짝수
                else{
                    for(int j = count; j < count + tmp; j++){
                        result[j] = (char) (i + 'A');
                        result[n-1-j] = (char) (i + 'A');
                    }
                }
            }
            count += tmp;
        }
        if(isOdd > 1){
            System.out.println("I'm Sorry Hansoo");
        }
        else{
            System.out.println(new String(result));
        }
    }
}

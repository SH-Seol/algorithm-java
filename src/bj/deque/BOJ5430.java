package bj.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String commands;
        char[] commandsList;
        Deque<String> deque;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        boolean isReverse;
        boolean isError;

        for(int i = 0; i < n; i++) {
            isReverse = false;
            isError = false;
            commands = br.readLine();//RDD
            commandsList = commands.toCharArray();
            int length = Integer.parseInt(br.readLine());//4
            String numsStr = br.readLine();//[1,2,3,4]
            if(length != 0){
                numsStr = numsStr.substring(1, numsStr.length() - 1);//1,2,3,4
                String[] sp = numsStr.split(",");
                deque = new LinkedList<>();
                for(String s : sp){
                    deque.addLast(s);
                }
            }
            else{
                deque = new LinkedList<>();
            }

            //commands 읽어가며 작업 시작
            for(int j = 0; j < commandsList.length; j++){
                if(commandsList[j] == 'R'){
                    isReverse = !isReverse;
                }
                else if(commandsList[j] == 'D'){
                    if(deque.isEmpty()){
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    else if(isReverse){
                        deque.removeLast();
                    }
                    else{
                        deque.removeFirst();
                    }
                }
            }
            int size = deque.size();
            if(isReverse && !isError){
                sb.append("[");
                for(int j = 0; j < size; j++){
                    sb.append(deque.removeLast());
                    if(j != size - 1){
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
            else if(!isReverse && !isError){
                sb.append("[");
                for(int j = 0; j < size; j++){
                    sb.append(deque.removeFirst());
                    if(j != size - 1){
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

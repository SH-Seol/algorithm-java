package bj.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ12100 {
    static int result = 0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[] moves = new int[5];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//map 다 채움
        move(map, moves, 0);
        System.out.println(result);
    }
    public static void move(int[][]map, int[] moves, int depth){
        if(depth == 5){
            //tmp map 하나 선언해야 map이 안망가짐
            int[][] tmpMap = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    tmpMap[i][j] = map[i][j];
                }
            }
            for(int i = 0; i < 5; i++){
                if(moves[i] == 0){
                    right(tmpMap);
                }
                else if(moves[i] == 1){
                    left(tmpMap);
                }
                else if(moves[i] == 2){
                    down(tmpMap);
                }
                else if(moves[i] == 3){
                    up(tmpMap);
                }
            }
            //여기서 가장 큰 값 결정해야함
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    result = Math.max(result, tmpMap[i][j]);
                }
            }
            return;
        }
        for(int i = 0; i < 4; i++){
            moves[depth] = i;
            move(map, moves, depth + 1);
        }
    }
    public static void right(int[][] map){
        //0,m~ n,m의 좌표쪽으로 몰아야함. 즉 x, m부터 시작해서 왼쪽값과 같으면 더해주고 해당 위차값 0으로 초기화
        //222면 -> 4 0 2 -> 4 2 0..2를 먼저 스택에 넣고 4가 들어오면 그냥 넣고 224면 4 4 0이 되어야함
        Stack<Integer> stack;
        Stack<Boolean> isAdd;
        for(int i = 0; i < n; i++){
            stack = new Stack<>();
            isAdd = new Stack<>();
            for(int j = n-1; j >= 0; j--){//stack에 값 집어넣기
                if(map[i][j] == 0){//맵에서 값이 0이면 넣지 않는다
                    continue;
                }
                if(stack.isEmpty()){//스택이 비어있는 경우
                    stack.push(map[i][j]);
                    isAdd.push(false);
                }
                else{
                    if(stack.peek() == map[i][j] && !isAdd.peek()){
                        stack.pop();
                        stack.push(map[i][j] * 2);
                        isAdd.pop();
                        isAdd.push(true);
                    }
                    else{//stack의 peek값과 map의 값이 같지 않은 경우는 그냥 넣어준다.
                        stack.push(map[i][j]);
                        isAdd.push(false);
                    }
                }
            }
            for(int j = 0; j < n; j++){//stack에 값을 빼면서 값을 수정하기 222였으면 이제 4 2 이렇게 2개가 들어가있을 것
                map[i][j] = n - j > stack.size() ? 0 : stack.pop();
            }
        }
    }

    public static void left(int[][] map){
        Stack<Integer> stack;
        Stack<Boolean> isAdd;
        for(int i = 0; i < n; i++){
            stack = new Stack<>();
            isAdd = new Stack<>();
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0){
                    continue;
                }
                if(stack.isEmpty()){
                    stack.push(map[i][j]);
                    isAdd.push(false);
                }
                else{
                    if(stack.peek() == map[i][j] && !isAdd.peek()){
                        stack.pop();
                        stack.push(map[i][j] * 2);
                        isAdd.pop();
                        isAdd.push(true);
                    }
                    else{//stack의 peek값과 map의 값이 같지 않은 경우는 그냥 넣어준다.
                        stack.push(map[i][j]);
                        isAdd.push(false);
                    }
                }
            }
            for(int j = n-1; j >= 0; j--){
                map[i][j] = (j >= stack.size()) ? 0 : stack.pop();
            }
        }
        //왼쪽부터 시작해서 오른쪽 값 같으면
    }
    public static void down(int[][] map){
        Stack<Integer> stack;
        Stack<Boolean> isAdd;
        for(int j = 0; j < n; j++){
            stack = new Stack<>();
            isAdd = new Stack<>();
            for(int i = n-1; i >= 0; i--){
                if(map[i][j] == 0){
                    continue;
                }
                if(stack.isEmpty()){
                    stack.push(map[i][j]);
                    isAdd.push(false);
                }
                else{
                    if(stack.peek() == map[i][j] && !isAdd.peek()){
                        stack.pop();
                        stack.push(map[i][j] * 2);
                        isAdd.pop();
                        isAdd.push(true);
                    }
                    else{//stack의 peek값과 map의 값이 같지 않은 경우는 그냥 넣어준다.
                        stack.push(map[i][j]);
                        isAdd.push(false);
                    }
                }
            }
            for(int i = 0; i < n; i++){
                map[i][j] = n - i > stack.size() ? 0: stack.pop();
            }
        }

    }
    public static void up(int[][] map){
        Stack<Integer> stack;
        Stack<Boolean> isAdd;
        for(int j = 0; j < n; j++){
            stack = new Stack<>();
            isAdd = new Stack<>();
            for(int i = 0; i < n; i++){
                if(map[i][j] == 0){
                    continue;
                }
                if(stack.isEmpty()){
                    stack.push(map[i][j]);
                    isAdd.push(false);
                }
                else{
                    if(stack.peek() == map[i][j] && !isAdd.peek()){
                        stack.pop();
                        stack.push(map[i][j] * 2);
                        isAdd.pop();
                        isAdd.push(true);
                    }
                    else{//stack의 peek값과 map의 값이 같지 않은 경우는 그냥 넣어준다.
                        stack.push(map[i][j]);
                        isAdd.push(false);
                    }
                }
            }
            for(int i = n-1; i >= 0; i--){
                map[i][j] = i + 1 > stack.size() ? 0: stack.pop();
            }
        }

    }
}

package bj.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ15686 {
    static int lines, remain;
    static List<int[]> house;
    static List<int[]> chicken;
    static int minDist = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lines = sc.nextInt();
        remain = sc.nextInt();

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        int tmp;

        for(int i=1; i<=lines; i++) {
            for(int j = 1; j<=lines; j++) {
                tmp = sc.nextInt();
                //치킨집이면 치킨집 리스트에 추가
                if(tmp == 2){
                    chicken.add(new int[]{i, j});
                }
                //집이면 집 리스트에 추가
                if(tmp == 1){
                    house.add(new int[]{i, j});
                }
            }
        }
        combination(0, 0, new ArrayList<>());
        System.out.println(minDist);
    }

    static void combination(int start, int cnt, List<int[]> arr){
        //arr에 치킨집이 원하는 양 만큼 채워졌을 경우
        if(cnt == remain){
            minDist = Math.min(minDist, getChickenDist(arr));
            return;
        }
        for(int i=start; i<chicken.size(); i++) {
            //arr에 현재 위치한 치킨집을 추가
            arr.add(chicken.get(i).clone());
            //다음으로 넘어감
            combination(i+1, cnt + 1, arr);
            //백트래킹
            arr.remove(arr.size()-1);
        }

    }
    static int getChickenDist(List<int[]> list){
        //집에서 치킨집까지 거리 저장하는 리스트
        int result = 0;
        //각 집별로 가장 가까운 치킨집과의 거리를 구해서 이 값을 결과에 더함
        for(int i = 0; i < house.size(); i++) {
            int distance = Integer.MAX_VALUE;
            for(int j = 0; j < list.size(); j++) {
                distance = Math.min(distance, Math.abs(list.get(j)[0] - house.get(i)[0]) + Math.abs(list.get(j)[1] - house.get(i)[1]));
            }
            result += distance;
        }
        return result;
    }
}

package programmers.array.DataAnalysis;

import java.util.ArrayList;
import java.util.Arrays;

public class Soulution {
    //어떤 정보를 기준으로 데이터를 뽑을지 ext, 뽑아낼 정보의 기준값 val_ext, 정보 정렬 기준 sort_by, 오름차순 정렬
    //data에서 ext값이 val_ext보다 작은 데이터만 뽑기
    //데이터는 항상 한 개 이상 존재
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        ArrayList<int[]> list = new ArrayList<>();

        //데이터 뽑아내는 작업
        if(ext.equals("code")){
            for (int i = 0; i < data.length; i++) {
                if(data[i][0] < val_ext){
                    list.add(new int[]{data[i][0], data[i][1], data[i][2], data[i][3]});
                }
            }
        }
        else if(ext.equals("date")){
            for(int i = 0; i < data.length; i++){
                if(data[i][1] < val_ext){
                    list.add(new int[]{data[i][0], data[i][1], data[i][2], data[i][3]});
                }
            }
        }
        else if(ext.equals("maximum")){
            for(int i = 0; i < data.length; i++){
                if(data[i][2] < val_ext){
                    list.add(new int[]{data[i][0], data[i][1], data[i][2], data[i][3]});
                }
            }
        }
        else if(ext.equals("remain")){
            for(int i = 0; i < data.length; i++){
                if(data[i][3] < val_ext){
                    list.add(new int[]{data[i][0], data[i][1], data[i][2], data[i][3]});
                }
            }
        }

        answer = list.toArray(new int[list.size()][]);

        if(sort_by.equals("code")){
            Arrays.sort(answer, (a, b) -> Integer.compare(a[0], b[0]));
        }
        else if(sort_by.equals("date")){
            Arrays.sort(answer, (a, b) -> Integer.compare(a[1], b[1]));
        }
        else if(sort_by.equals("maximum")){
            Arrays.sort(answer, (a, b) -> Integer.compare(a[2], b[2]));
        }
        else if(sort_by.equals("remain")){
            Arrays.sort(answer, (a, b) -> Integer.compare(a[3], b[3]));
        }
        return answer;
    }
}

package programmers.implement.wallpaper;

public class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = 49;
        int minY = 49;
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < wallpaper.length; i++) {
            String paper = wallpaper[i];
            for(int j = 0; j < paper.length(); j++) {
                if(paper.charAt(j) == '#') {
                    minX = Math.min(minX, j);
                    minY = Math.min(minY, i);
                    maxX = Math.max(maxX, j);
                    maxY = Math.max(maxY, i);
                }
            }
        }
        int[] answer = {minY, minX, maxY + 1, maxX + 1};
        return answer;
    }
}

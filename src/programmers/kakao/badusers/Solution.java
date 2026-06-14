package programmers.kakao.badusers;

import java.util.*;

class Solution {
    //백트래킹인듯?
    boolean[] visited;
    String[] users;
    String[] bans;
    Set<List<String>> set = new HashSet<>();
    List<String> lst = new ArrayList<>();
    public int solution(String[] user_id, String[] banned_id) {
        //어떻게 구성해?
        //음..user_id에 맞춰서 ban을 훑다가 맞으면 방문처리 해놓고 넘기고 방문처리 안한채로도 넘기고
        visited = new boolean[user_id.length];
        users = user_id;
        bans = banned_id;
        bt(0);
        return set.size();
    }
    boolean match(String str, String ban){
        if(str.length() != ban.length()){
            return false;
        }

        for(int i = 0; i < str.length(); i++){
            if(ban.charAt(i) == '*'){
                continue;
            }
            if(str.charAt(i) != ban.charAt(i)){
                return false;
            }
        }
        return true;
    }
    //ban 배열 있어야하고 이걸 전체로 두고

    void bt(int bi){
        // bi가 밴 크기보다 크면 다 채웠다는 의미
        if(bi >= bans.length){
            List<String> copy = new ArrayList<>(lst);

            copy.sort(Comparator.naturalOrder());
            set.add(copy);
            return;
        }
        //마지막 bi까지 오면 맞는 놈을 찾으면 answer++하고 return해주면 된다.
        //ban에 맞춰 user를 돌린다
        for(int i = 0; i < users.length; i++){
            //ui에 해당요소가 사용이 됐으면 그냥 continue이고
            if(visited[i]){
                continue;
            }
            //매칭되면 채운거랑 안채운거 둘 다 해줘야함
            if(match(users[i], bans[bi])){
                visited[i] = true;
                lst.add(users[i]);
                bt(bi + 1);
                visited[i] = false;
                lst.remove(lst.size() - 1);
            }
        }
    }
}
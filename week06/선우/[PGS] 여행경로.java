// import java.util.*;
// class Solution {
//     String[] answer;
//     int count = 0;
//     public String[] solution(String[][] tickets) {
//         String[] answer = new String[tickets.length];
//         findNext(tickets,"ICN",answer, count);
//         return answer;
//     }
//     void findNext(String[][] tickets, String next, String[] answer, int count){
//         answer[count] = next;
//         List<String> list = new ArrayList<>();      
//         for(int i = 0; i < tickets.length ; i++){
//             if(tickets[i][0].equals(next)){
//                 list.add(tickets[i][1]);
//             }
//         }
//         Collections.sort(list);
//         if(list.isEmpty()){
//             return;
//         }
//         String next1 = list.remove(0);
//         findNext(tickets,next1,answer,count+1);
//     }
// }
import java.util.*;

class Solution {

    boolean[] visited;
    String[] answer;

    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];
        answer = new String[tickets.length + 1];

        dfs(tickets, "ICN", 0);

        return answer;
    }

    boolean dfs(String[][] tickets, String current, int depth) {

        answer[depth] = current;

        if(depth == tickets.length) {
            return true;
        }

        for(int i = 0; i < tickets.length; i++) {
Arrays.sort(tickets, (a,b) -> {
    if(a[0].equals(b[0]))
        return a[1].compareTo(b[1]);
    return a[0].compareTo(b[0]);
});

            if(!visited[i] && tickets[i][0].equals(current)) {

                visited[i] = true;

                if(dfs(tickets, tickets[i][1], depth + 1))
                    return true;

                visited[i] = false; // 백트래킹
            }
        }

        return false;
    }
}

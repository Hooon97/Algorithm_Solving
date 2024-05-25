import java.util.*;

class Solution {
    static boolean[] visit;
    static Deque<String> routeList;
    static ArrayList<String> ansList;
    
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        visit = new boolean[tickets.length];
        routeList = new ArrayDeque<>();
        ansList = new ArrayList<>();
        Arrays.sort(tickets, (String[] o1, String[] o2) -> {
            if(o1[0].equals(o2[0]))
                return o1[1].compareTo(o2[1]);
            else
                return o1[0].compareTo(o2[0]);
        });
        
        DFS("ICN", tickets);
        for(int i = 1; i<answer.length; i++)
            answer[i] = ansList.get(i-1);
        answer[0] = "ICN";
        return answer;
    }
    public void DFS(String st, String[][] tickets){
        if(routeList.size() == tickets.length){
            while(!routeList.isEmpty()){
                ansList.add(routeList.poll());
            }
            return;
        }
        
        for(int i = 0; i<tickets.length; i++){
            String[] ticket = tickets[i];
            if(ansList.size() != 0) return;
            if(visit[i]) continue;
            if(st.equals(ticket[0])){
                visit[i] = true;
                routeList.addLast(ticket[1]);
                
                DFS(ticket[1], tickets);
                
                visit[i] = false;
                routeList.pollLast();
            }}
        
    }
}
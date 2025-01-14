import java.util.*;

class Solution {
    /*
        1. 각 로봇별 이동 경로를 DFS 탐색, 저장.
        2. 도출된 이동 경로를 재 시뮬레이션하며, 충돌 횟수 판단.
        
        O(MN^2 + MN)
    */
    static int[][] map;
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        map = new int[102][102];
        for(int i = 1; i<=points.length; i++){
            int[] point = points[i-1];
            map[point[0]][point[1]] = i;
        }
        
        List<int[]>[] traceList = new ArrayList[routes.length];
        for(int i = 0; i<routes.length; i++){
            traceList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<routes.length; i++){
            getPath(traceList[i], routes[i], points);
        }
        
        // 충돌 횟수 카운트
        int maxLength = 0;
        for(int i = 0; i<traceList.length; i++){
            maxLength = Math.max(maxLength, traceList[i].size());
        }
        
        for(int i = 0; i<maxLength; i++){
            Map<String, Integer> pathCheck = new HashMap<>();
            for(int j = 0; j<traceList.length; j++){
                if(traceList[j].size() <= i) continue;
                int[] curPoint = traceList[j].get(i);
                String path = String.valueOf(curPoint[0]+"|"+curPoint[1]);
                pathCheck.put(path, pathCheck.getOrDefault(path, 0)+1);
            }
            for(String key : pathCheck.keySet()){
                if(pathCheck.get(key) > 1) answer++;
            }
        }
        
        return answer;
    }
    public void getPath(List<int[]> trace, int[] route, int[][] points){
        for(int i = 1; i<route.length; i++){
            int[] startPoint = points[route[i-1]-1];
            int[] endPoint = points[route[i]-1];
            
            initMap(points);
            Robot robot = getDirectPath(startPoint, endPoint);
            if(trace.size() > 0) trace.remove(trace.size()-1);
            trace.addAll(robot.trace);
        }
    }
    
    public Robot getDirectPath(int[] st, int[] ed){
        Robot robot = new Robot(st[0], st[1], new ArrayList<>());
        int r = st[0];
        int c = st[1];
        while(r != ed[0]){
            if(r > ed[0]){
                r--;
            } else{
                r++;
            }
            robot.trace.add(new int[]{r,c});
        }
        
        while(c != ed[1]){
            if(c > ed[1]){
                c--;
            } else {
                c++;
            }
            robot.trace.add(new int[]{r,c});
        }
        return robot;
    }
    
    public void initMap(int[][] points){
        map = new int[102][102];
        for(int i = 1; i<=points.length; i++){
            int[] point = points[i-1];
            map[point[0]][point[1]] = i;
        }
        return;
    }
    
    public Robot getBfsPath(int[] st, int[] ed){
        Robot firstRobot = new Robot(st[0], st[1], new LinkedList<>());
        Queue<Robot> q = new LinkedList<>();
        q.add(firstRobot);
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        while(!q.isEmpty()){
            Robot robot = q.poll();
            if(robot.r == ed[0] && robot.c == ed[1]){
                return robot;
            }
            
            for(int i = 0; i<4; i++){
                int drs = robot.r + dr[i];
                int dcs = robot.c + dc[i];
                if(drs < 0 || drs > 100 || dcs < 0 || dcs > 100) continue;
                if(drs == ed[0] && dcs == ed[1]){
                    robot.trace.add(new int[]{drs, dcs});
                    return robot;
                }
                if(map[drs][dcs] != 0) continue;
                
                map[drs][dcs] = -1;
                q.add(new Robot(drs, dcs, robot.trace));
            }
        }
        
        // 해당 경로 조회 시 잘못된 종료
        return new Robot(-1, -1, new LinkedList<>());
    }
    
    class Robot{
        int r;
        int c;
        List<int[]> trace = new LinkedList<>();
        Robot(int r, int c, List<int[]> trace){
            this.r = r;
            this.c = c;
            for(int[] t : trace){
                this.trace.add(t);
            }
            this.trace.add(new int[]{r,c});
        }
    }
}
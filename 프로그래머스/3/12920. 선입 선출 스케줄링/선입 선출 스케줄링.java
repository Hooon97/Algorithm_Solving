class Solution {
    /*
        t = 5 | 6 3 2 = 10
        t = 6 | 7 4 3 = 14
        t = 7 | 8 4 3 = 15
        
        시간과 해당 시간동안 할당될 수 있는 일의 양은 선형적으로 증가하지 않는다.
    */
    public int solution(int n, int[] cores) {
        int answer = 0;
        int time = 0;
        int task = 0;
        
        int left = 0;
        int right = n*10000;
        while(left <= right){
            int mid = (left+right)/2;
            int doneWork = calDoneWork(cores, mid);
            
            if(doneWork < n){
                left = mid+1;
            } else if(doneWork >= n){
                right = mid-1;
                time = mid; // 작업 시간
                task = doneWork; // 시간 내 작업된(중인) 일의 양
            }
        }
        
        task -= n;
        // 주어진 시간과 작업량으로 종결 지점을 찾아야 함.
        for(int i = cores.length-1; i>=0; i--){
            if(time%cores[i] == 0){
                if(task == 0){
                    answer = i+1;
                }
                task--;
            }
        }
        
        return answer;
    }
    // 해당 시간동안 수행할 수 있는 일의 양
    public int calDoneWork(int[] cores, int time){
        int result = 0;
        for(int core : cores) result += time/core+1;
        return result;
    }
}
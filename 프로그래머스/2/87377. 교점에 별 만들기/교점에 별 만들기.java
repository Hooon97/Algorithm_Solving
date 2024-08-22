import java.util.*;

class Solution {
    long minX, maxX;
    long minY, maxY;
    public String[] solution(int[][] line) {
        /*
            1. 각 직선들의 교점 중 x,y 둘 다 정수인 점만 저장한다.
            1-1. 저장할 때 x,y의 최대, 최소 값을 각각 기억한다.
            2. y,x 순으로 오름차순 정렬한다.
            3. x,y의 최소~최대만큼 순회하며 답안을 생성한다.
        */
        
        minX = maxX = minY = maxY = Long.MIN_VALUE;
        List<long[]> dotList = getDotList(line);
        String[] answer = new String[(int)(maxY-minY+1)];
        char[][] answerArr = new char[answer.length][(int)(maxX-minX+1)];
        for(int i = 0; i<answerArr.length; i++)
            Arrays.fill(answerArr[i], '.');
        
        Collections.sort(dotList, new Comparator<long[]>(){
            @Override
            public int compare(long[] a, long[] b){
                if(a[1] == b[1]) return a[0] > b[0] ? 1 : -1;
                else return a[1] > b[1] ? 1 : -1;
            }
        });
        
        for(long[] dot : dotList){
            answerArr[(int)(dot[1]-minY)][(int)(dot[0]-minX)] = '*';
        }
        
        for(int i = 0; i<answerArr.length; i++){
            answer[answerArr.length-1-i] = new String(answerArr[i]);
        }

        return answer;
    }
    public List<long[]> getDotList(int[][] line){
        List<long[]> result = new ArrayList<>();
        
        for(int i = 0; i<line.length; i++){
            for(int j = i+1; j<line.length; j++){
                long[] cross = doMath(line[i], line[j]);
                if(cross[2] != 0 || cross[3] != 0) continue;
                
                long[] intDot = new long[]{cross[0], cross[1]};
                updateMinMax(intDot);
                result.add(intDot);
                
            }
        }
        
        return result;
    }
    
    private long[] doMath(int[] a, int[] b){
        long A = a[0];
        long B = a[1];
        long E = a[2];
        long C = b[0];
        long D = b[1];
        long F = b[2];
        
        if(A*D-B*C == 0){
            return new long[]{0,0,1,1};
        }
        
        long x = (B*F-E*D) / (A*D-B*C);
        long y = (E*C-A*F) / (A*D-B*C);
        long p = (B*F-E*D) % (A*D-B*C);
        long q = (E*C-A*F) % (A*D-B*C);
        
        return new long[] {x,y,p,q};
    }
    
    private void updateMinMax(long[] a){
        minX = minX == Long.MIN_VALUE ? a[0] : Math.min(minX, a[0]);
        maxX = Math.max(maxX, a[0]);
        minY = minY == Long.MIN_VALUE ? a[1] : Math.min(minY, a[1]);
        maxY = Math.max(maxY, a[1]);
    }
}
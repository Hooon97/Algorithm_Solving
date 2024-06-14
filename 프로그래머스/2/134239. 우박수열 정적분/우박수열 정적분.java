import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        double[] sum = getAccumulateSum(Double.valueOf(k));
        int count = sum.length-1;
        
        for(int i = 0; i<ranges.length; i++){
            int[] range = ranges[i];
            int st = range[0];
            int ed = count + range[1];
            if(ed < st) answer[i] = -1.0;
            else answer[i] = sum[ed] - sum[st];
        }
        
        return answer;
    }
    
    public double[] getAccumulateSum(Double k){
        List<Double> sumList = new ArrayList<>();
        double prev = k;
        double pro = k;
        sumList.add(0.0);
        while(pro != 1){
            double tmp = pro;
            if(pro % 2 == 0){
                prev = pro;
                pro = tmp/2;
            } else{
                prev = pro;
                pro = tmp*3+1;
            }
            //누적합
            sumList.add(sumList.get(sumList.size()-1) + (prev+pro)/2);
        }
        
        double[] sumArr = new double[sumList.size()];
        for(int i = 0; i<sumList.size(); i++)
            sumArr[i] = sumList.get(i);
        
        return sumArr;
    }
}
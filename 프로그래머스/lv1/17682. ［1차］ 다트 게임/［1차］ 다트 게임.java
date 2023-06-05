class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] value = new int[3];
        String[] dart = dartResult.split("");
        int index = -1;
        for(int i = 0; i<dart.length; i++){
            if(dart[i].matches("[0-9]")){
                index++;
                value[index] = Integer.valueOf(dart[i]);
                if(dart[i+1].matches("[0-9]")){
                    i++;
                    value[index] = 10;
                }
            }
            
            switch(dart[i]){
                case "D" : value[index] = (int)Math.pow(value[index], 2);
                    break;
                case "T" : value[index] = (int)Math.pow(value[index], 3);
                    break;
                case "#" : value[index] *= -1;
                    break;
                case "*" :
                    value[index] *= 2;
                    if(index-1 >= 0) value[index-1] *= 2;
                    break;
            }
        }
        
        for(int i : value) answer += i;
        
        return answer;
    }
}
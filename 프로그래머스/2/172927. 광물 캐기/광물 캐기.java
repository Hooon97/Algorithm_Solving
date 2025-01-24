import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int dia = 0;
        int iron = 0;
        int stone = 0;
        int max = 0;
        for(int i = 0; i<3; i++) max += picks[i];

        List<Mineral> list = new LinkedList<>();
        for(int i = 1; i<=minerals.length; i++){
            if(max == 0) break;
            if(minerals[i-1].equals("diamond")) dia++;
            else if(minerals[i-1].equals("iron")) iron++;
            else stone++;
            
            if( i % 5 == 0 || i == minerals.length){
                list.add(new Mineral(dia, iron, stone));
                dia = 0;
                iron = 0;
                stone = 0;
                max--;
            }
        }
        
        Collections.sort(list, (o1,o2) -> {
            if(o1.dia == o2.dia){
                if(o1.iron == o2.iron){
                    return o2.stone - o1.stone;
                } else{
                    return o2.iron - o1.iron;
                }
            } else{
                return o2.dia - o1.dia;
            }
        });
        
        int idx = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<picks[i]; j++){
                if(idx >= list.size()) return answer;
                Mineral mineral = list.get(idx++);
                if(i == 0){
                    answer += mineral.dia;
                    answer += mineral.iron;
                    answer += mineral.stone;
                } else if(i == 1){
                    answer += mineral.dia * 5;
                    answer += mineral.iron;
                    answer += mineral.stone;
                } else if(i == 2){
                    answer += mineral.dia * 25;
                    answer += mineral.iron * 5;
                    answer += mineral.stone;
                }
            }
        }
        
        return answer;
    }
    
    class Mineral{
        int dia;
        int iron;
        int stone;
        Mineral(int dia, int iron, int stone){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }
}
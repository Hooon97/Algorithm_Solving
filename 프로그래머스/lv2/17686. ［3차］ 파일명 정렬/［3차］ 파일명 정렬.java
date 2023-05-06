import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files,(o1,o2) -> {
            //head 정리
            String o1Head = getHead(o1);
            String o2Head = getHead(o2);
            if(!o1Head.equals(o2Head)){
                return o1Head.compareTo(o2Head);
            }
            else{
                //number 정리
                int o1Number = getNumber(o1);
                int o2Number = getNumber(o2);
                return o1Number - o2Number;
            }
        });  
        
        
        return files;
    }
    public String getHead(String name){
        StringBuilder sb = new StringBuilder();
        char[] tmp = name.toLowerCase().toCharArray();
        for(char c : tmp){
            if(c >= '0' && c <= '9')
                break;
            sb.append(c);
        }
        return sb.toString();
    }
    public int getNumber(String name){
        StringBuilder sb = new StringBuilder();
        int numStart = 0;
        for(int i = 0; i<name.length(); i++){
            if(name.charAt(i) >= '0' && name.charAt(i) <= '9'){
                numStart = i;
                break;
            }
        }
        
        for(int i = numStart; i<name.length(); i++){
            if(name.charAt(i) >= '0' && name.charAt(i) <= '9'){
                sb.append(name.charAt(i));   
                continue;
            }
            break;
        }
        return Integer.valueOf(sb.toString());
    }
}
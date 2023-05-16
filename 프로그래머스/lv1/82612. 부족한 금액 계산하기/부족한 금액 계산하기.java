import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        long tmp = 0;
        for(int i = 1; i<count+1; i++) tmp += i*price;
        if(tmp - money < 0){
            return 0;
        }
        else return tmp - money;

    }
}
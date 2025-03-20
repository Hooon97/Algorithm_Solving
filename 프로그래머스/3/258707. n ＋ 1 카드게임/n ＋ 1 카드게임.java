import java.util.*;

class Solution {
    /*
        1. 숫자는 고유하므로 set에 저장한다.
        2. 스타팅 숫자를 제외하고 2개씩 얻는 숫자들을...꼭 그 라운드에서 구입 판단을 해야할까?
        3. 라운드를 진행하다가 숫자가 부족해지면, 이전 라운드에서 샀던 걸로 취급하자.
        4. 일종의 메모이제이션..?
    */
    
    Set<Integer> startCards, newCards;
    int SIZE, TARGET, answer;
    public int solution(int coin, int[] cards) {
        answer = 0;
        SIZE = cards.length;
        TARGET = cards.length+1;
        startCards = new HashSet<>();
        newCards = new HashSet<>();
        for(int i = 0; i<SIZE/3; i++) startCards.add(cards[i]);
        Hand(coin, cards, SIZE/3, 1);
        
        return answer;
    }
    public void Hand(int coin, int[] cards, int pos, int Round){
        if(pos >= SIZE){
            answer = Math.max(answer, Round);
            return;
        }
        int num1 = cards[pos++];
        int num2 = cards[pos++];
        newCards.add(num1);
        newCards.add(num2);
        if(noCoin()){
            Hand(coin, cards, pos, Round+1);
        } else if(oneCoin(coin)){
            Hand(coin-1, cards, pos, Round+1);
        } else if(twoCoin(coin)){
            Hand(coin-2, cards, pos, Round+1);
        } else{
            answer = Math.max(answer, Round);
        }
        
        return;
    }
    
    public boolean twoCoin(int coin){
        if(coin < 2) return false;
        
        for(int nCard : newCards){
            if(newCards.contains(TARGET - nCard)){
                newCards.remove(nCard);
                newCards.remove(TARGET - nCard);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean oneCoin(int coin){
        if(coin < 1) return false;
        
        for(int nCard : newCards){
            if(startCards.contains(TARGET - nCard)){
                startCards.remove(TARGET - nCard);
                newCards.remove(nCard);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean noCoin(){
        for(int card : startCards){
            if(startCards.contains(TARGET - card)){
                startCards.remove(card);
                startCards.remove(TARGET - card);
                return true;
            }
        }
        return false;
    }
}
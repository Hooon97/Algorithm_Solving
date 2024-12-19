class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        swap(wallet);
        swap(bill);
        
        while(bill[0] > wallet[0] || bill[1] > wallet[1]){
            if(bill[0] > bill[1]){
                bill[0] /= 2;
            } else{
                bill[1] /= 2;
            }
            
            swap(wallet);
            swap(bill);
            answer++;
        }
        
        return answer;
    }
    
    public void swap(int[] arr){
        int min = Math.min(arr[0], arr[1]);
        int max = Math.max(arr[0], arr[1]);
        
        arr[0] = min;
        arr[1] = max;
    }
}
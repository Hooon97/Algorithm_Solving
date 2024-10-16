class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] >= 'a' && arr[i] <= 'z'){
                arr[i] = (char)(arr[i] + n);
                if(arr[i] > 'z') arr[i] = (char)('a' + arr[i]%'z' - 1);
            } else if(arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[i] = (char)(arr[i] + n);
                if(arr[i] > 'Z') arr[i] = (char)('A' + arr[i]%'Z' - 1);
            }
        }
        return new String(arr);
    }
}
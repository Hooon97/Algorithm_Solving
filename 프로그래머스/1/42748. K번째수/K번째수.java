import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i<commands.length; i++){
            int st = commands[i][0];
            int ed = commands[i][1];
            int idx = commands[i][2];
            
            int[] cArr = new int[ed-st+1];
            for(int j = 0; j<cArr.length; j++)
                cArr[j] = array[st+j-1];
            // Arrays.sort(cArr);
            quickSort(cArr, 0, cArr.length-1);
            answer[i] = cArr[idx-1];
        }
        
        return answer;
    }
    
    public void quickSort(int[] arr, int st, int ed){
        if(ed <= st) return;
        
        int pivotIndex = partition(arr, st, ed);
        
        quickSort(arr, st, pivotIndex-1);
        quickSort(arr, pivotIndex+1, ed);
        
    }
    
    public int partition(int[] arr, int st , int ed){
        int pivot = arr[st];
        
        int left = st;
        int right = ed;
        
        while(left < right){
            while(left < right && arr[right] > pivot) right--;
            while(left < right && arr[left] <= pivot) left++;
            
            swap(arr, left, right);
        }
        
        swap(arr, st, left);
        
        return left;
    }
    
    public void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
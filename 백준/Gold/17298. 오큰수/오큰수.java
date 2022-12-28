import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		int[] ans = new int[N];
		for(int i = 0; i<N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		for(int i = 1; i<N; i++) {
			while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				ans[stack.pop()] = numbers[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) ans[stack.pop()] = -1;
		for(int i = 0; i<N; i++) sb.append(ans[i]+" ");
		System.out.print(sb.toString());
		
		br.close();
	}
}

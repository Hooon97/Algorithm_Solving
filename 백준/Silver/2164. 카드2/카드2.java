import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<N+1; i++) q.add(i);
		
		while(q.size() > 1) {
			q.poll();
			int cur = q.poll();
			q.add(cur);
		}
		System.out.print(q.poll());
		
	}
}

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2)) return Math.abs(o1) - Math.abs(o2);
				else if( Math.abs(o1) == Math.abs(o2)) return o1-o2;
				else return -1;
			}});
		
		for(int i = 0; i<N; i++) {
			int a = sc.nextInt();
			if(a == 0) {
				if(pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll()+"\n");
			}
			else
				pq.add(a);
		}
		System.out.print(sb.toString());
		sc.close();
	}
}

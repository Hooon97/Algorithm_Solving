import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Num {
		int idx;
		int val;

		public Num(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			PriorityQueue<Num> maxQ = new PriorityQueue<>(new Descending());
			//기본적으로 오름차순이긴 한데, Num 객체 생성해서 넣었으므로 오버라이딩 해줘야함
			PriorityQueue<Num> minQ = new PriorityQueue<>(new Aescending());
			int N = sc.nextInt();
			boolean[] visited = new boolean[N];
			
			//작업순서
			for (int i = 0; i < N; i++) {
				String ord = sc.next();
				switch (ord) {
				case "I":
					int n = sc.nextInt();
					Num num = new Num(i, n);
					maxQ.add(num);
					minQ.add(num);
					break;
				case "D":
					int b = sc.nextInt();
					if (b == 1) {
						if (!maxQ.isEmpty()) {
							// 최댓값 삭제
							Num cur = maxQ.poll();
							visited[cur.idx] = true;
						}
					} else {
						// 최솟값 삭제
						if(!minQ.isEmpty()) {
							Num cur = minQ.poll();
							visited[cur.idx] = true;
						}
					}
					break;
				}
				// 결과값 출력
				// 최댓값 - 최소값  or EMPTY
				// 먼저 maxQ와 minQ의 남은 값을 idx에 맞춰주자.
				while(!maxQ.isEmpty()) {
					if(!visited[maxQ.peek().idx])
						break;
					else
						maxQ.poll();
				}
				while(!minQ.isEmpty()) {
					if(!visited[minQ.peek().idx])
						break;
					else
						minQ.poll();
				}
			} //작업 순서 끝
			
			if(minQ.isEmpty() || maxQ.isEmpty())
				System.out.println("EMPTY");
			else //아니면
				System.out.println(maxQ.peek().val + " " + minQ.peek().val);
		
		}

		sc.close();
	}

	static class Descending implements Comparator<Num> {
		@Override
		public int compare(Num o1, Num o2) {
			if (o1.val < o2.val)
				return 1;
			else
				return -1;
		}
	}
	
	static class Aescending implements Comparator<Num> {
		@Override
		public int compare(Num o1, Num o2) {
			if (o1.val < o2.val)
				return -1;
			else
				return 1;
		}

	}
	
}

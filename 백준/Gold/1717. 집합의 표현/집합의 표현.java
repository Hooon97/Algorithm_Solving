import java.util.Scanner;

public class Main {
	public static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); //최대 수의 크기
		int M = sc.nextInt(); //연산의 개수
		parent = new int[N+1];
		for(int i = 0; i<N+1; i++) parent[i] = i;
		for(int i = 0; i<M; i++) {
			int quest = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(quest == 0) {
				union(a,b);
			}
			else {
				if(checkSame(a,b)) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.print(sb.toString());
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if( a != b) {
			parent[b]=a;
		}
	}
	static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return true;
		else return false;
	}
}

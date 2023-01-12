import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int treeHeight = 0;
		int length = N;
		while( length != 0) {
			length /= 2;
			treeHeight++;
		}
		
		int treeSize = (int)Math.pow(2, treeHeight+1);
		int leftNodeStartIndex = treeSize/2 -1;
		tree = new long[treeSize+1];
		for(int i = leftNodeStartIndex+1; i<=leftNodeStartIndex+N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		setTree(treeSize-1);
		for(int i = 0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			if(a==1) changeVal(leftNodeStartIndex+s,e);
			else if(a==2) {
				s += leftNodeStartIndex;
				e += leftNodeStartIndex;
				sb.append(getSum(s,(int)e)+"\n");
			}
			else return;
		}
		System.out.print(sb.toString());
	}
	static long getSum(int s, int e) {
		long partSum = 0;
		while(s<=e) {
			if(s%2 == 1) {
				partSum += tree[s];
				s++;
			}
			if(e%2 == 0) {
				partSum += tree[e];
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return partSum;
	}
	static void changeVal(int index, long val) {
		long diff = val - tree[index];
		while(index > 0) {
			tree[index] = tree[index] + diff;
			index /= 2;
		}
	}
	static void setTree(int i) {
		while(i != 1) {
			tree[i/2] += tree[i];
			i--;
		}
	}
}

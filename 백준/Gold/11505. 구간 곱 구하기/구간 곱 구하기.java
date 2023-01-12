import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static int MOD;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int treeHeight = 0;
		int length = N;
		while(length != 0) {
			length /= 2;
			treeHeight++;
		}
		int treeSize = (int) Math.pow(2, treeHeight+1);
		int leftNodeStratIndex = treeSize/2-1;
		MOD = 1000000007;
		tree = new long[treeSize+1];
		for(int i = 0; i<tree.length; i++) tree[i] = 1;
		for(int i = leftNodeStratIndex+1; i<=leftNodeStratIndex+N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		setTree(treeSize-1);
		for(int i = 0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			if(a==1) changeVal(leftNodeStratIndex+s,e);
			else if(a==2) {
				s += leftNodeStratIndex;
				e += leftNodeStratIndex;
				sb.append(getMul(s,(int)e)+"\n");
			}
			else return;
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	static long getMul(int s, int e) {
		long partMul = 1;
		while(s <= e) {
			if(s%2 == 1) {
				partMul = partMul * tree[s] % MOD;
				s++;
			}
			if(e%2 == 0) {
				partMul = partMul * tree[e] % MOD;
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return partMul;
	}
	
	static void changeVal(int index, long val) {
		tree[index] = val;
		while(index > 1) {
			index /= 2;
			tree[index] = tree[index*2]%MOD * tree[index*2+1]%MOD;
		}
	}
	
	static void setTree(int i) {
		while(i != 1) {
			tree[i/2] = tree[i/2] * tree[i]%MOD;
			i--;
		}
	}
}

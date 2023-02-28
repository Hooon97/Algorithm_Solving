import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	static HashMap<String, Integer> frd;
	static int[] parent;
	static int[] cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());
		for(int t = 0; t<T; t++) {
			int N = Integer.valueOf(br.readLine());
			parent = new int[N*2];
			cnt = new int[N*2];
			for(int i = 0; i<N*2; i++) parent[i] = i;
			Arrays.fill(cnt, 1);
			
			frd = new HashMap<>();
			int idx = 0;
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String one = st.nextToken();
				String two = st.nextToken();
				if(!frd.containsKey(one)) {
					frd.put(one, idx++);
				}
				if(!frd.containsKey(two)) {
					frd.put(two, idx++);
				}
				
				int ans = Union(Find(frd.get(one)), Find(frd.get(two)));
				sb.append(ans+"\n");
			}
		}
		System.out.print(sb.toString());
	}
	static int Union(int a, int b) {
		a = Find(a);
		b = Find(b);
		if(a == b) return cnt[a];
		else {
			if(a < b) {
				parent[b] = a;
				cnt[a] += cnt[b];
				return cnt[a];
			}
			else {
				parent[a] = b;
				cnt[b] += cnt[a];
				return cnt[b];
			}
		}
	}
	static int Find(Integer one) {
		if(parent[one] == one) return one;
		else return parent[one] = Find(parent[one]);
	}
}
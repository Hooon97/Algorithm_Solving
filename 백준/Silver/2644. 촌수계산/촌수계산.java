import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] relation;
	static boolean[] checked;
	static int res = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int L = Integer.valueOf(br.readLine());
		relation = new ArrayList[L+1];
		checked = new boolean[L+1];
		for(int i = 1; i<L+1; i++) relation[i] = new ArrayList<>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int targetOne = Integer.valueOf(st.nextToken());
		int targetTwo = Integer.valueOf(st.nextToken());
		
		int t = Integer.valueOf(br.readLine());
		
		
		for(int i = 0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.valueOf(st.nextToken());
			int son = Integer.valueOf(st.nextToken());
			relation[parent].add(son);
			relation[son].add(parent);
		}
		
		dfs(targetOne, targetTwo, 0);
		System.out.print(res);
	}
	static public void dfs(int st, int ed, int count) {
		if(st == ed) {
			res = count;
			return;
		}
		
		checked[st] = true;
		for(int i = 0; i<relation[st].size(); i++) {
			int next = relation[st].get(i);
			if(!checked[next]) dfs(next, ed, count+1);
		}
	}
}

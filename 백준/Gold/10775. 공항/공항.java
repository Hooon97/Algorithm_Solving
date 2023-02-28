import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		parent = new int[Integer.valueOf(br.readLine().trim())+1];
		for(int i = 0; i<parent.length; i++) parent[i] = i;
		int T = Integer.valueOf(br.readLine().trim());
		int count = 0;
		for(int i = 0; i<T; i++) {
			int g_airplane = Integer.valueOf(br.readLine().trim());
			int root = Find(g_airplane);
			if(root != 0) {
				Union(root, root-1);
				count++;
			}
			else break;
		}
		System.out.print(count);
	}
	static void Union(int a, int b) {
		a = Find(a);
		b = Find(b);
		if(a == b) return;
		else parent[a] = b;
	}
	static int Find(int a) {
		if(parent[a] == a) 
			return a;
		else {
			return parent[a] = Find(parent[a]);
		}
	}
	
}

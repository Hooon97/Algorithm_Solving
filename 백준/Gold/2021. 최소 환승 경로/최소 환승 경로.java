import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<Integer>[] stations;
	static ArrayList<Integer>[] lines;
	static boolean[] visitStation;
	static boolean[] visitLine;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken()); //역의 개수
		int L = Integer.valueOf(st.nextToken()); //노선의 개수
		stations = new ArrayList[N+1];
		visitStation = new boolean[N+1];
		lines = new ArrayList[L+1];
		visitLine = new boolean[L+1];
		
		for(int i = 1; i<N+1; i++) stations[i] = new ArrayList<>();
		for(int i = 1; i<L+1; i++) lines[i] = new ArrayList<>();
		
		for(int i = 1; i<L+1; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int curStat = Integer.valueOf(st.nextToken());
				if(curStat == -1) break;
				stations[curStat].add(i);
				lines[i].add(curStat);
			}
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.valueOf(st.nextToken());
		int end = Integer.valueOf(st.nextToken());
		System.out.println(findTransCount(start, end));
	}
	private static int findTransCount(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visitStation[start] = true;
		for(int c : stations[start]) {
			pq.add(new Node(start, c, 0));
		}
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(node.station == end) {
				return node.count;
			}
			
			for(int nS : lines[node.line]) {
				if(visitStation[nS]) continue;
				visitStation[nS] = true;
				pq.add(new Node(nS, node.line, node.count));
				
				for(int nL : stations[nS]) {
					if(visitLine[nL]) continue;
					visitLine[nL] = true;
					pq.add(new Node(nS, nL, node.count+1));
				}
			}
		}
		
		return -1;
	}
}

class Node implements Comparable<Node>{
	int station;
	int line;
	int count;
	Node(int station, int line, int count){
		this.station = station;
		this.line = line;
		this.count = count;
	}
	
	public int compareTo(Node o) {
		return this.count-o.count;
	}
}

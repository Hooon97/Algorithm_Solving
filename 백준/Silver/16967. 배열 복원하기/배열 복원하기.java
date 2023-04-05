import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.valueOf(st.nextToken());
		int W = Integer.valueOf(st.nextToken());
		int X = Integer.valueOf(st.nextToken());
		int Y = Integer.valueOf(st.nextToken());
		int[][] map = new int[H+X][W+Y];
		
		for(int i = 0; i<map.length; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 0;
			while(st.hasMoreTokens()) {
				map[i][j++] = Integer.valueOf(st.nextToken());
			}
		}
		
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				map[i+X][j+Y] -= map[i][j];
			}
		}
		
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}


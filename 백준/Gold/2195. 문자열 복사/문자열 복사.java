import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		// target 값을 하나씩 이동해가면서 더해가고, blocks에 포함되어 있는지 확인
		// 포함되어 있으면 다음 인덱스부터 검사
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String blocks = br.readLine();
		String target = br.readLine();
		int count = 0;
		int curIndex = 0;
		for(int i = 0; i<target.length(); i++) {
			if(blocks.indexOf(target.substring(curIndex, i+1)) != -1) continue;
			else {
				curIndex = i;
				count++;
			}
		}
		
		System.out.print(++count);
		br.close();
	}
}

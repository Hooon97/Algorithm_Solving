import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	/*
	 * 입력받은 문자열의 0번 인덱스부터 다음 인덱스의 문자와 비교한다.
	 * 이전 문자가 다음 문자보다 작으면 다음 문자는 앞에 붙인다.
	 * 이전 문자가 다음 문자보다 크면 다음 문자는 뒤에 붙인다.
	 * 끝에 있는 문자를 앞이나 뒤에 붙이는 것은, 뒤집거나 뒤집지 않는 것과 동일하게 작용한다.
	 * 즉, n번째 연산의 결과값은 n개의 문자가 사전순으로 배열되었음을 의미한다.
	 * 연산이 전체 길이만큼 진행되면 모든 문자가 사전순으로 배열되었다.
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String originString = br.readLine();
		sb.append(originString.charAt(0));
		
		for(int i = 1; i<originString.length(); i++) {
			if(sb.charAt(0) < originString.charAt(i))
				sb = sb.append(originString.charAt(i));
			else {
				StringBuilder tmp = new StringBuilder();
				tmp.append(originString.charAt(i));
				tmp.append(sb);
				sb = tmp;
			}
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}

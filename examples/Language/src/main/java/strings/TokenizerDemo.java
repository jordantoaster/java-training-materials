package strings;

import java.util.StringTokenizer;

public class TokenizerDemo {

	public static void main(String[] args) {
		String str = "abc#def?ghi@jkl";
		String delims = "#?@";
		StringTokenizer st = new StringTokenizer(str,delims);

		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}

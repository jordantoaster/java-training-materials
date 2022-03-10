package strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexWithSubMatches {

	public static void main(String[] args) {
		String data = "ABCdef#GHIjkl#MNOpqr#STUvwx#YZA";
		
		//Three uppercase letters followed by three lowercase letters
		// capturing the uppercase letters as the first subgrouping
		// and the lowercase letters as the second
		printMatchesWithSubGroupings(data,"([A-Z]{3})([a-z]{3})",2);
	}
	private static void printMatchesWithSubGroupings(String data, String regex, int numSubGroups) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(data);
		System.out.println("Matches for " + regex + " are:");
		while(m.find()) {
			System.out.println("\t" + m.group() + " with subgroups:");
			for(int i=1;i<=numSubGroups;i++) {
				System.out.println("\t\t" + m.group(i));
			}
		}
	}
}

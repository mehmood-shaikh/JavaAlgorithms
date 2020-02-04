import java.util.Arrays;
import java.util.List;


public class WordBreakDP {
	public static void main(String[] args)
	{
		// List of Strings to represent dictionary
		// we can also use trie or Set to store dictionary
		List<String> dict = Arrays.asList("this", "th", "is", "famous",
									"Word", "break", "b", "r", "e", "a", "k",
									"br", "bre", "brea", "ak", "proble");

		// input String
		String str = "Wordbreakproblem";

		// look-up array to store solutions to sub-problems
		// lookup[i] stores if substring str[n-i..n) can be segmented or not
		int[] lookup = new int[str.length() + 1];
		Arrays.fill(lookup, -1);

		if (wordBreak(dict, str, lookup))
			System.out.print("String can be segmented");
		else
			System.out.print("String can't be segmented");
	}

	private static boolean wordBreak(List<String> dict, String str, int[] lookup) {
		System.out.println("Outside   : "+str);
		int n=str.length();
		if(n==0)
			return true;
		if(lookup[n]==-1){
			System.out.println("        Inside : "+str);
			lookup[n]=0;
			for(int i=n;i>0;i--){
				String prefix=str.substring(0,i);
				if(dict.contains(prefix) && wordBreak(dict,str.substring(i),lookup)){
					lookup[n]=1;
					return true;
				}
			}
		}
		else if(lookup[n]==0)
			return false;
		else 
			return true;
		return false;
	}
}

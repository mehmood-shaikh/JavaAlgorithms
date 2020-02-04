
public class StringPermConst {

	public static void main(String[] args) {
		String sample="ABAB";
		
		perm("",sample);

	}

	private static void perm(String parsedStr, String remStr) {
		if(remStr.length()==0){
			System.out.println(parsedStr);
			return;
		}
		
		for(int i=0;i<remStr.length();i++)
		{
			if(parsedStr.length()>0 && parsedStr.charAt(parsedStr.length()-1)=='A' && remStr.charAt(i)=='B')
				continue;
			perm(parsedStr+remStr.charAt(i),remStr.substring(0,i)+remStr.substring(i+1));
		}
	}

}

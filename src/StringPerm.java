
public class StringPerm {

	public static void main(String[] args) {
		String sample="abbc";
		permutation("",sample);

	}

	private static void permutation(String parsedStr,String remStr) {
		//System.out.println("ParsedStr : "+parsedStr);
		if(remStr.length()==0){
			System.out.println(parsedStr);
			return;
		}
			
		for(int i=0;i<remStr.length();i++){
			permutation(parsedStr+remStr.charAt(i),remStr.substring(0,i)+remStr.substring(i+1));
		}
		
	}

}

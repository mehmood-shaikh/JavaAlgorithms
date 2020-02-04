import java.util.Stack;


public class StringBurst {
	public static void main(String[] args) 
    { 
		String s="aabbcdddccab";
		int n=3;
		System.out.println("Output : "+findStringBurst(s,3));
    }

	private static String findStringBurst(String s, int k) {
		int count=1;
		char prev=s.charAt(0);
		Stack<Character> retStr=new Stack<>();
		retStr.push(prev);
		for(int i=1;i<s.length();i++){
			char curr=s.charAt(i);
			if(curr==prev){
				retStr.push(curr);
				count++;		
			}else{
				if(count>=k){
					while(retStr.peek()==prev){
						retStr.pop();
					}
					int j=retStr.size();
					if(j>0){
						prev=retStr.peek();
						count=0;
						while(j!=0 && retStr.get(j-1)==prev){
							count++;
							j--;
						}
						i--;
						continue;
					}
				}else{
					count=1;
					prev=s.charAt(i);
					retStr.push(curr);
				}
			}
		}
		String str="";
		for(Character c:retStr)
			str+=c;
		return str;
	}

}

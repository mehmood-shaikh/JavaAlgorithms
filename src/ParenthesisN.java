import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;


public class ParenthesisN {

	public static void main(String[] args) {
		//Scanner scan= new Scanner(new InputStreamReader(System.in));
		String input=new String("(()))())()())(()()))");
		int n=input.length();
		char[] inputArr= input.toCharArray();
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<n;i++){
			if(inputArr[i]=='('){
				inputArr[i]='0';
				st.push(i);
			}else if(!st.empty()){
				inputArr[i]='1';
				inputArr[st.pop()]='1';
			}else{
				inputArr[i]='0';
			}
		}
		int max=0, count=0;
		for(int i=0;i<n;i++){
			if(inputArr[i]=='0'){
				if(max<count)
					max=count;
				count=0;
			}else{
				count++;
			}
		}
		if(max<count)
			max=count;
		System.out.println(input);
		System.out.println(inputArr);
		System.out.println(max);	
	}
	
	
}

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;


public class Parenthesis {

	public static void main(String[] args) {
		//Scanner scan= new Scanner(new InputStreamReader(System.in));
		String input=new String("((()(()())(()()))");
		int n=input.length();
		System.out.println(isValidNew(input));
		/*boolean[][] arr= new boolean [n+2][n+1];
		int max=0;
		for(int i=0;i<=input.length()+1;i++){
			arr[i][0]=true;
		}
		for(int size=2;size<=n;size=size+2){
			for(int i=0;i+size<=input.length();i++){
				if((arr[i][size-2] && input.charAt(i+size-2)=='(' && input.charAt(i+size-1)==')' )
					||(arr[i+1][size-2] && input.charAt(i)=='(' && input.charAt(i+size-1)==')' )
					||(arr[i+2][size-2] && input.charAt(i)=='(' && input.charAt(i+1)==')' )
			 	){
					arr[i][size]=true;
				}else{
					for(int j=2;j<size;j=j+2){
						if(arr[i][j] && arr[i+j][size-j])
							arr[i][size]=true;
					}
				}
				if(arr[i][size])
					max=size>max?size:max;
			}
		}
		System.out.println(input);
		for(int size=2;size<=n;size=size+2){
			for(int i=0;i+size<=input.length();i++){
				System.out.println(input.substring(i,i+size) +" : "+arr[i][size]);
			}
		}
		System.out.println(max);	*/
	}
	
	static boolean isValidNew(String input){
		Stack<Character> st=new Stack<Character>();
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)=='('){
				st.push('(');
			}
			else{
				if(st.empty())
					return false;
				else 
					st.pop();
			}
		}
		if(st.empty())
			return true;
		return false;
	}
	
	static boolean isValid(String subStr){
		char curr;
		Stack<Character> st=new Stack<Character>();
		for(int i=0;i<subStr.length();i++){
			curr=subStr.charAt(i);
			switch(curr){
			case ')':
				if(!st.empty()){
					st.pop();
				}else{
					return false;
				}
				break;
			case '(':
				st.push('(');
				break;
			}
		}
		if(st.size()==0)
			return true;
		else 
			return false;
	}
	
}

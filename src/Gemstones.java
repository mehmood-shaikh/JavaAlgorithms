import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Gemstones {

	public static void main(String[] args) {
		List<String> al= Arrays.asList("akbcquwirgjbdvmncda","abdqwejiquwhjbzce","qoiwinmzmxbcjhiqdqwdjkla","mznxbcjhqiqkwhdkabsjcb");
		int[] gem =new int[26];
		
		for(String st:al){
			boolean[] flag=new boolean[26];
			for(char ch:st.toCharArray()){
				int i=ch-'a';
				if(!flag[i]){
					gem[i]++;
					flag[i]=true;
				}
			}
		}
		for(int i=0;i<26;i++){
			if(gem[i]==al.size())
				System.out.print((char)(i+'a')+ ", ");
		}

	}

}

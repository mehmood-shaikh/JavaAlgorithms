import java.util.ArrayList;


public class WordBreak {

	public static void main(String[] args) {
		String str="scdbynenmpa";       
		
		ArrayList<String> al=new ArrayList<String> ();
		al.add("scd");
		al.add("rjmowfrx");
		al.add("jybldbe");
		al.add("scdbyne");
		al.add("dyggxxp");
		al.add("lorel");
		al.add("nmpa");
		al.add("qfwkho");
		al.add("kmcoqhnw");
		al.add("kuewhsqmgb");
		System.out.println(find(str,al));
	}

	private static boolean find(String str, ArrayList<String> al) {
		if(str.equals(""))
			return true;
		System.out.println("str : "+str);
		for(String str1:al){
			System.out.print(str1+ ", ");
		}
		System.out.println();
		for(int i=0;i<str.length();i++){
			for(int size=1;size<=str.length()-i;size++){
				String subStr=str.substring(i,i+size);
				int index=-1, count=0;
				for(String str1:al){
					if(str1.equals(subStr)){
						index=count;
						break;
					}
					count++;
				}
				if(index!=-1){
					al.remove(index);
					if(find(str.substring(i+size),al))
						return true;
					al.add(subStr);
				}
			}
		}
		
		
		return false;
	}

}

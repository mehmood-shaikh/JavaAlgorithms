import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;


public class SortArr {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<String> li=new ArrayList<String>(); 
		while(sc.hasNextLine()){
			String str=sc.nextLine();
			if(str.equals(""))
				break;
			li.add(str);
			
		}
		/*li.add("abc:10");
		li.add("xyz:11");
		li.add("a:20");
		li.add("ac:100");
		li.add("abc:15");
		li.add("d:10");*/
		dispTop(li);

	}


	static void dispTop(List<String> li){
		HashMap<String, Integer>hm=new HashMap<String, Integer>();
		String[] str= new String[2];
		for(String fullSt:li){
			str=fullSt.split(":");
			Integer i;
			if(hm.containsKey(str[0])){
				i=hm.get(str[0])+Integer.parseInt(str[1]);
			}else{
				i=Integer.parseInt(str[1]);
			}
			hm.put(str[0],i);
		}
		List<Entry<String,Integer>> sl = new ArrayList(hm.entrySet());
		Collections.sort(sl, new Comparator<Entry<String,Integer>>(){
					public int compare(Entry<String,Integer> e1, Entry<String,Integer> e2){
						return e2.getValue()-e1.getValue();
					}
				});
		for(Entry<String,Integer> e:sl){
			System.out.println(e.getKey() +" : "+e.getValue());
		}
	}
}

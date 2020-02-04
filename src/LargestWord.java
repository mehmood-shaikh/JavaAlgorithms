import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;


public class LargestWord {

	public static void main(String[] args) {
		String[] dict={"lr", "m", "lrm", "hcdar", "wk" };//{"geeksgeeks","geeksfor"};
		String str="hcdarlrm";
		TreeMap<Integer,ArrayList<String>> hm=new TreeMap<Integer,ArrayList<String>>(Collections.reverseOrder());
		int len=0;
		for(int i=0;i<dict.length;i++){
			ArrayList<String> al;
			len=dict[i].length();
			if(!hm.containsKey(len)){
				hm.put(len, new ArrayList<String> ());
			}
			al=hm.get(len);
			al.add(dict[i]);
		}
		Iterator<Entry<Integer,ArrayList<String>>> itr=hm.entrySet().iterator();
		boolean notFound=true;
		while(itr.hasNext() && notFound){
			Entry<Integer,ArrayList<String>> e=itr.next();
			if(e.getKey()>str.length()){
				continue;
			}
			for(String dictStr:e.getValue()){
				if(isValid(dictStr,str)){
					System.out.println(dictStr);
					notFound=false;
					break;
				}
			}
		}
		

	}

	private static boolean isValid(String dictStr, String str) {
		//System.out.println(dictStr+"    :     "+str);
		int dlen=dictStr.length(), slen=str.length();
		int i=0,j=0;
		while(i<dlen && j<slen){
			if(dictStr.charAt(i)==str.charAt(j)){
				i++;
			}
			j++;
		}
		if(i==dlen)
			return true;
		else
			return false;
	}

}

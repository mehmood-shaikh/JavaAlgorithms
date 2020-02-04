import java.util.HashMap;
import java.util.Map.Entry;


public class gcdOne {
	public static void main(String[] args) {
		int arr[]={5,11,14,20};
		int cost[]={4,1,2,4};
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		hm.put(arr[0],cost[0]);
		int gcd=0;
		for(int i=1;i<arr.length;i++){
			HashMap<Integer,Integer> oldHm=new HashMap<Integer,Integer>(hm);
			for(Entry<Integer,Integer> e : oldHm.entrySet()){
				gcd=getGcd(e.getKey(),arr[i]);
				System.out.println("e.getKey() : "+e.getKey()+"   arr[i] : "+arr[i]+"    gcd : "+gcd);
				if(hm.containsKey(gcd)){

					System.out.println("hm.get(gcd) : "+hm.get(gcd)+"   e.getValue(): "+e.getValue()+"    cost[i] : "+cost[i]);
					hm.put(gcd,Math.min(hm.get(gcd),e.getValue()+cost[i]));
					
				}else{
					hm.put(gcd, e.getValue()+cost[i]);
				}
			}
		}
		if(hm.containsKey(1))
			System.out.println(hm.get(1));
		else
			System.out.println(-1);
	}

	private static int getGcd(int a, int b) {
		if(b==0){
			return a;
		}
		return getGcd(b,a%b);
	}
}

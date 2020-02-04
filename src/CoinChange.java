
public class CoinChange {
	static int s=4;
	static int N=3;
	static int c[]= {1,2,3};
	public static void main(String args[]){
		
		int count=calc(N,s);
		System.out.println(count);
		count=calcRec(0,s);
		System.out.println(count);
	}

	private static int calcRec(int n, int s) {
		System.out.println("n: "+n+", s :"+s);
		if(s==0)
			return 1;
		else if(s<0)
			return 0;
		int sum=0;
		for(int i=n;i<N;i++){
			sum+=calcRec(i,s-c[i]);
		}
		return sum;
	}

	private static int calc( int m, int n) {
		
		int table[]=new int[s+1];
		table[0]=1;
		for(int i=0;i<N;i++){
			for(int j=c[i];j<=s;j++){
				table[j]+=table[j-c[i]];
			}
		}
		for(int j=0;j<=s;j++)
			System.out.print(table[j]+" ");
		System.out.println();
		return table[s];
	}
}

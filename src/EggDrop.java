
public class EggDrop {

	public static void main(String[] args) {
		int e=2,n=100;
		int result=0;
		int res[][]=new int[e][n];
		int max=0, min=Integer.MAX_VALUE;
		for(int i=0;i<e;i++){
			for(int j=0;j<n;j++){
				if(j==0){
					res[i][j]=1;
					continue;
				}else if(i==0){
					res[i][j]=j;
					continue;
				}
				min=Integer.MAX_VALUE;
				for(int k=1;k<=j;k++){
					max=Math.max(res[i][j-k],res[i-1][k-1]) +1;
					if(max<min)
						min=max;
				}
				res[i][j]=min;
			}
		}
		for(int i=0;i<e;i++){
			for(int j=0;j<n;j++){
				System.out.print(res[i][j]+"  ");
			}
			System.out.println();
		}
	}

}

import java.util.Arrays;


public class SeiveOfEratosthenes {

	public static void main(String[] args) {
		int arr[]={1,4,5,7,3,4,74,9,13,27,35,17,19,31,0};
		prime(arr);
	}

	private static void prime(int[] arr) {
		int max=Integer.MIN_VALUE;
		for(int i:arr){
			if(max<i)
				max=i;
		}
		boolean a[]=new boolean[max+1];
		Arrays.fill(a, true);
		a[0]=a[1]=false;
		int i=2;
		for(;i*i<=max;i++){
			if(a[i]){
				for(int j=i*i;j<=max;j=j+i)
					a[j]=false;
			}
		}
		for(int j=0;j<arr.length;j++){
			if(a[arr[j]])
				System.out.print(arr[j]+", ");
		}
	}

}

import java.util.Arrays;


public class MergeSort {
	public static void main(String arg[]){
		int[] arr={3,1,2,5,6,7,1,32,4,6,7,8,90,0,5,8,5};
		divide(arr,0,arr.length-1);
		System.out.println(display(arr));
		
	}
	
	static void divide(int arr[], int low, int high){
		int mid=(low+high)/2;
		if(low!=high){
			divide(arr,low,mid);
			divide(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}
	
	static String display(int arr[]){
		StringBuffer sb=new StringBuffer("");
		for(int i=0;i<arr.length;i++)
			sb.append(arr[i]+", ");
		return sb.toString();
	}

	static void merge(int[] arr, int low, int mid, int high) {
		int i=0,j=0,k=low;
		int arrA[]=Arrays.copyOfRange(arr, low, mid+1);
		int arrB[]=Arrays.copyOfRange(arr,  mid+1,high+1);
		try {
			while(i<=(mid-low) && j<=(high-mid-1)){
				if(arrB[j]<arrA[i]){
					arr[k]=arrB[j];
					j++;
				}else{
					arr[k]=arrA[i];
					i++;
				}
				k++;
			}
			while(i<=mid-low){
				arr[k]=arrA[i];
				i++;
				k++;
			}
			while(j<=(high-mid-1)){
				arr[k]=arrB[j];
				j++;
				k++;
			}
		} catch (Exception e) {
			System.out.println("arr A : "+display(arrA));
			System.out.println("arr B : "+display(arrB));
			System.out.println("arr : "+display(arr));
			System.out.println("low : "+low+", mid : "+mid+", high : "+high);
			System.out.println("i : "+i+", j : "+j+", k : "+k);
			//e.printStackTrace();
			throw e;
		}
			
		
	}
}

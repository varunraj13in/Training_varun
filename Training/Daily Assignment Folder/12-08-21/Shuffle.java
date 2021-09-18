import java.util.Arrays;
import java.util.Random;

public class Shuffle {
	
	static void swap(int a[],int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void reverse(int a[],int low,int high){
		for(int i = low,j = high;i<j;i++,j--){
			swap(a,i,j);
		}
	}
	static void rightRotate(int a[], int k, int n){
		reverse(a,n-k,n-1);
		reverse(a,0,n-k-1);
		reverse(a,0,n-1);
	}
	
	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5 };
		int n = 3;
		rightRotate(a, n, a.length);
		System.out.println(Arrays.toString(a));
	}

}

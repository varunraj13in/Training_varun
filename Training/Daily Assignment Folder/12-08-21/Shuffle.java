import java.util.Arrays;
import java.util.Random;

public class Shuffle {
	
	static void swap(int a[],int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void ShuffleArray(int a[],int n){
		Random x = new Random();
		
		for(int i = n-1;i>0;i--){
			int j = x.nextInt(i+1);
			swap(a,i,j);
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5 };
		int n = a.length;
		ShuffleArray(a,n);
	}

}

package selfpractice;

public class RemoveElementAtIndex {

	public static void main(String[] args) {		
		int[] arr = {10,20,30,40,50,60,70,80};
		int index = 5;	
		
		if(index < arr.length-1) {
			for(int i = index; i < arr.length; i++){
				if(i+1 < arr.length)
					arr[i] = arr[i+1];
			}	
			for(int i=0; i< arr.length-1; i++){
				System.out.print(arr[i] + " ");
			}
		} else {
			System.out.println("Index Not Present");
		}
	}

}

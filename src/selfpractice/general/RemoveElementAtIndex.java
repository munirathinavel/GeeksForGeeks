package selfpractice.general;

public class RemoveElementAtIndex {

	public static void main(String[] args) {		
		int[] arr = {10,20,30,40,50,60,70,80};
		int index = 5;	
		
		//Here we are not deleting element at index, just shifting rest elements and 
		//over-writing the value at index
		if(index < arr.length-1) {
			for(int i = index; i < arr.length; i++){
				if(i+1 < arr.length) {	//Edge case when shifting last element in array
					arr[i] = arr[i+1];	//Shift elements
				}
			}	
			//Print the shifted array elements
			for(int i=0; i < arr.length-1; i++){
				System.out.print(arr[i] + " ");
			}
		} else {
			System.out.println("Index Not Present");
		}
	}

}

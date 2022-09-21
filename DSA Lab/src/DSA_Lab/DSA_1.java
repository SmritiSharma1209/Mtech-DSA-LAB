// write a menu driven program to create an array of n elements as per the user's 
//choice insert, delete, traverse, update, search, sort the array continuue till the user wants to stop



package DSA_Lab;
import java.util.Scanner;

public class DSA_1 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the size of Array");
		int n=s.nextInt();
		int arr[]= new int[n];
		System.out.println("Enter the elements of Array");
		for (int i=0;i<n;++i) {
			arr[i]=s.nextInt();
			
		}
		
		char ch='Y';
		System.out.println("Choose from the below menu which operation is to be performed");
		System.out.println("1. Insertion");
		System.out.println("2. Deletion");
		System.out.println("3. Printing the Array");
		System.out.println("4. Updation");
		System.out.println("5. Searching an element");
		System.out.println("6. Sorting the Array");
		
		
		
		while(ch=='Y') {
			
		System.out.println("Enter the choice");	
		int x= s.nextInt();
		
		switch(x) {
		
		case 1: System.out.println("Enter the number to be inserted");   //Insertion
		        int number=s.nextInt();
		        System.out.println("Enter the position where the number should be inserted: ");
		        int position=s.nextInt();
		        if(position<=0 || position>arr.length) {
		        	System.out.println("Invalid operation ");
		        }else {
			    int ans[]=insert(arr, number ,position);    
		        System.out.println("The updated Array is: ");
		        for(int i=0;i<ans.length;++i) {
		        	System.out.print(ans[i] + " ");
		        }
		        System.out.println();
		       }
		         
		        break;
		
		
		
		case 2:  
                 System.out.println("Enter the position where the number should be deleted: ");
                 int indexVal =s.nextInt();
                 if(indexVal<=0 || indexVal>arr.length) {
        	         System.out.println("Invalid operation ");
                 }
                 else {
	                 int ans[]=delete(arr, indexVal);    
                     System.out.println("The updated Array is: ");
                     for(int i=0;i<ans.length;++i) {
     		        	System.out.print(ans[i] + " ");
     		         }
                     System.out.println();
                  }
                 break;
                 
		
		case 3: System.out.println("The Array is: ");  //Traversing
		        for(int i=0;i<arr.length;++i) {
		        	System.out.print(arr[i] + " ");
		        }
		        System.out.println();
		        
		        break;
		
		case 4:  System.out.println("Enter the number to be inserted: ");     //Updation
                 int num=s.nextInt();
                 System.out.println("Enter the position where the number should be updated: ");
                 int pos=s.nextInt();
                 if(pos<=0 || pos>arr.length) {
        	         System.out.println("Invalid operation ");
                   }else{
                	  int ans[]= update(arr,num,pos );
                	  System.out.println("The updated Array is: ");
                	  for(int i=0;i<ans.length;++i) {
      		        	System.out.print(ans[i] + " ");
      		        }
                	  System.out.println();
                 }
                  break;
                 
                	   
		case 5:  System.out.println("Enter the number to be searched: ");       //Searching
                 int a=s.nextInt();
                 int index= search(arr, a);
                 if(index!=-1) {
                	 System.out.println("The number is found at position " + index+1);
                 }else {
                	 System.out.println("Element is not found");
                 }
                 break;
                 
                  
		case 6: System.out.println("The sorted array is : ");        //Sorting
		        quick_Sort(arr, 0, arr.length-1);
		        for(int i=0;i<arr.length;++i) {
		        	System.out.print(arr[i] + " ");
		        }
		        System.out.println();
		        
		        break;
		
			
	}
		System.out.println("Do you want to Continue?? /n Press 'Y' for Yes , Press 'N' for No ");
		ch=s.next().charAt(0);
		
		
    }	
}
	
	
	public static int[] insert(int arr[], int num, int pos) {
		int arr2[]= new int[arr.length+1];
		if(pos-1==0) {
			arr2[0]=num;
			for(int i=1;i<arr2.length;++i) {
				arr2[i]=arr[i-1];
			}
			
		}
		else if(pos-1==arr.length) {
			arr2[arr.length]=num;
			for(int i=0;i<arr.length-1;++i) {
				arr2[i]=arr[i];
			}
			
			
		}
		else {
			for(int i=0;i<pos-1; ++i) {
				arr2[i]=arr[i];
			}
			arr2[pos-1]=num;
			
			for(int i=pos; i<arr2.length;++i) {
				arr2[i]=arr[i-1];
				
			}
			
		}
		
		return arr2;
		
		
	}
	
	
	public static int[] update(int arr[], int num ,int pos) {
		
		arr[pos-1]=num;
		return arr;
		
	}
	
	
	public static int search(int arr[], int num) {
		int lo=0;
		int high=arr.length-1;
		int pos=-1;
		
		while(lo<=high) {
			
			int mid=(lo+high)/2;
			
			if(arr[mid]==num) {
				mid=pos;
			}
			else if(num>arr[mid]) {
				lo=mid+1;
			}
			else if(num<arr[mid]) {
				high=mid-1;
			}
		}
		
		return pos;
		
	}


    public static void quick_Sort(int arr[], int lo, int hi) {
    	
    	if(lo>hi) {
    		return;
    	}
    	
    	int pivot=arr[hi];
    	int PivotPos=partition(arr,pivot,lo,hi);
    	quick_Sort(arr, lo, PivotPos-1);
    	quick_Sort(arr, PivotPos+1, hi);
    	
    }

	
	
	public static void swap(int arr[], int i, int j) {
    	int temp=arr[i];
    	arr[i]=arr[j];
    	arr[j]=temp;
    }
	
	
	
	public static int partition(int arr[], int pivot, int lo, int hi) {
		
    	int i=lo;
    	int j=lo;
    	
    	while(i<=hi) {
    		if(arr[i]>pivot) {
    			i++;
    		}else {
    			swap(arr,i ,j);
    			i++;
    			j++;
    		}
    	}
    	return j-1;
    }
    
    
    public static int[] delete(int arr[], int pos) {
    	int arr2[]= new int[arr.length-1];
    	
    	if(pos-1==0) {
    		for(int i=1;i<arr.length;++i) {
    			arr2[i-1]=arr[i];
    		}
    	}else if(pos==arr.length) {
    		for(int i=0;i<arr.length-1;++i) {
    			arr2[i]=arr[i];
    		}
        }else{
        	for(int i=0;i<pos-1;++i) {
        		arr2[i]=arr[i];
        	}
        	for(int i=pos-1;i<arr2.length;++i) {
        		arr2[i]=arr[i+1];
        	}
        }
    	  return arr2;
    }


}

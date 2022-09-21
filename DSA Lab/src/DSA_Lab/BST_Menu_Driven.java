package DSA_Lab;
import java.util.*;


public class BST_Menu_Driven {


public static TreeNode input(int arr[], int lo, int hi) {
		
		if(lo>hi) {
			return null;
		}
		
		int mid=(lo+hi)/2;
		
		int data=arr[mid];
	
		TreeNode lc=input(arr, lo, mid-1);
		TreeNode rc=input(arr, mid+1,hi);
		
		TreeNode root= new TreeNode(data,lc,rc);
		
		return root;
		
	}
	
	
public static TreeNode Insert(TreeNode root, int data) {
		
		if(root==null) {
			TreeNode newNode= new TreeNode(data,null,null);
			return newNode;
		}
		
		if(data>root.data) {
			root.right= Insert(root.right,data);
		}
		
		else if (data< root.data) {
			root.left=Insert(root.left,data);
		}
		else {
			//Do Nothing
		}
		
		return root;
		
		
	}
	

public static int Max(TreeNode root) {
	
	 if(root.right!=null) {
   	  return Max(root.right);
     }
	 else {
   	  return root.data;
     }
}
	
	
public static int Min(TreeNode root) {
	
 if(root.left!=null) {
  	  return Min(root.left);
    }else {
  	  return root.data;
    }
	
}
	
	
public static void InOrder(TreeNode root) {
	
	if(root==null) {
		return;
	}
	
	InOrder(root.left);
	System.out.print(root.data + " ");
	InOrder(root.right);
}

public static void PreOrder(TreeNode root) {
	
	if(root==null) {
		return;
	}
	
	System.out.print(root.data + " ");
	PreOrder(root.left);
	PreOrder(root.right);
}

public static void PostOrder(TreeNode root) {
	
	if(root==null) {
		return;
	}
	
	PostOrder(root.left);
    PostOrder(root.right);
    System.out.print(root.data + " ");
}

public static TreeNode delete(TreeNode root, int val) {
	
	if(root==null) {
		return null;
	}
	
	if (root.data >val) {
		root.left=delete(root.left,val);
	}
	else if (root.data <val) {
		root.right=delete(root.right,val);
	}
	else {
		
		if(root.left!=null && root.right!=null) {
			int leftMax=Max(root.left);
			root.data=leftMax;
			root.left=delete(root.left,leftMax);
			return root;
			
		}
		else if (root.left!=null && root.right==null) {
			return root.left;
		}
		
		else if(root.left==null && root.right!=null) {
			return root.right;
		}
		
		else {
			return null;
		}
	}
	
	return root;
}
	
	
public static void main(String[] args) {
	
	Scanner s= new Scanner(System.in);
	//System.out.println("Enter the Elements of the Tree");
	int arr[]= {12,25,37,50,62,75,87};
	TreeNode root= input(arr,0,arr.length-1);
	InOrder(root);
	System.out.println();

	System.out.println("Choose from the below menu which operation is to be performed");
	System.out.println("1. Insert in the Tree");
	System.out.println("2. Find Min of the Tree");
	System.out.println("3. Find Max of the Tree");
	System.out.println("4. Print Inorder");
	System.out.println("5. Print PreOrder");
	System.out.println("6. Print PostOrder");
	System.out.println("7. Delete From tree");
	
	char ch= 'Y';
	
	while(ch=='Y'|| ch=='y') {
		
		System.out.println("Enter the operation number");
		int option=s.nextInt();
		
		switch(option) {
		    
		case 1 : System.out.println("Enter the value to be inserted");
		          int num=s.nextInt();
			      root= Insert(root, num);
			      InOrder(root);
			      break;
			      
		case 2 : System.out.println("The min. value is  "+ Min(root));
		         break;
		         
		case 3: System.out.println("The max. value is " + Max(root));
		        break;
		         
		case 4: System.out.println("The Inorder Traversal is ");
		        InOrder(root);
		        System.out.println();
		        break;
	
		case 5: System.out.println("The PreOrder Traversal is ");
		        PreOrder(root);
                System.out.println();
                break;
                
		case 6: System.out.println("The Postorder Traversal is ");
                PostOrder(root);
                System.out.println();
                break;
                
		case 7: System.out.println("Enter the element to be deleted ");
		        int n= s.nextInt();
		        root=delete(root,n);
                 InOrder(root);
                 break;
		  }
		
		System.out.println("Do you want to continue?? Y/N ");
		ch=s.next().charAt(0);
	
	}
    
}

	}



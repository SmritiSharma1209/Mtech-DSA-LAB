package DSA_Lab;
import java.util.Scanner;

public class DSA_2 {
	
	public static Node<Integer>input(){
		Scanner s =new Scanner(System.in);
		Node<Integer> head= null;
		Node<Integer>tail=null;
		System.out.print("Enter the values");
		int data= s.nextInt();
		
		while(data!=-1) {
			Node<Integer>newNode=new Node(data);
			if(head==null) {
				head=newNode;
				tail=head;
			}
			else {
				Node<Integer>temp=head;
				while(temp.next!=null) {
					temp=temp.next;
				}
				temp.next=newNode;
				temp=temp.next;
				tail=temp;
			}
			
			data=s.nextInt();
		}
		
		return head;
		
		
	}
	
	public static int size(Node<Integer>head) {
		int size=0;
		Node<Integer>temp=head;
		while(temp!=null) {
			size++;
			temp=temp.next;
		}
		return size;
	}
	
	public static Node<Integer> insert_at_beg(Node<Integer>head,int val){
		Node<Integer>newNode=new Node<>(val);
		if(head==null) {
			head=newNode;
		}else {
			 newNode.next=head;
			 head=newNode;
		}
		return head;
		
	}
	
	
	public static Node<Integer> insert_at_end(Node<Integer>head, int val){
		Node<Integer> newNode=new Node<>(val);
		
		if(head==null) {
			head=newNode;
		} else {
			  Node<Integer>temp=head;
			  while(temp.next!=null) {
				   temp=temp.next;
			   }
			    temp.next=newNode;
			    temp=newNode;
		    }
		  return head;
	  }
	
	
	public static Node<Integer> insert_in_between(Node<Integer> head, int pos, int val){
		
		Node<Integer> newNode=new Node<>(val);
		Node<Integer>temp=head;
		int size=size(head);
		
		if(head==null) {
			head=newNode;
			return head;
		}
		
	    
		
		if(pos>size+1) {
			System.out.println("Inavlid position");
		}
		else if(pos==1) {
			newNode.next=head;
			head=newNode;
		}
		else {
			
			temp=head;
			size=1;
			while(size!=pos-1) {
				size++;
				temp=temp.next;
			}
			newNode.next=temp.next;
			temp.next=newNode;		
			
		}
		
		return head;
	}

	
	public static void print(Node<Integer>head) {
		System.out.println("The LL is: ");
		Node<Integer> temp=head;
		while(temp!=null) {
			System.out.print(temp.data+ " ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	
	public static Node<Integer> Delete(Node<Integer> head, int pos){
		
		if(head==null) {
			System.out.print("The LL is empty ");
			return null;
		}
		
		Node<Integer>temp=head;
		int size=size(head);
		
		
		if(pos>size) {
			System.out.println("Invalid position");
			return head;
		}
		
		else if(pos==1) {
			
			head=head.next;
			return head;
		}
		else {
			temp=head;
			size=1;
			while(size!=pos-1) {
				temp=temp.next;
				size++;
				
			}
			temp.next=temp.next.next;
		}
		
		return head;
		
	}
	
	
	public static Node<Integer> Update(Node<Integer> head, int val , int pos){
		
		
		if(head==null) {
			System.out.println("The List is empty ..Value can't be updated");
			return head; 
		}
		
		int size=size(head);
		Node<Integer>temp=head;
		
		if(pos>size) {
			
			System.out.println("Invalid Position");
			return head;
			
		}else {
			
			size=1;
			while(size!=pos) {
				temp=temp.next;
				size++;
			}
			temp.data=val;
		}
		
		return head;
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the Elements in the LL");
		Node<Integer>head=input();
		System.out.println("Choose from the below menu which operation is to be performed");
		System.out.println("1. Insertion in the beginning of the LL");
		System.out.println("2. Insertion at the end of the LL");
		System.out.println("3. Insertion in between of the LL");
		System.out.println("4. Updation of the LL");
        System.out.println("5. Deletion in the LL");
		System.out.println("6. Printing the LL");
		
		char ch='Y';
		while(ch=='Y') {
			
			System.out.println("Enter the number from the menu");
			int option=s.nextInt();
			
			switch(option) {
			
			   case 1: System.out.println("Enter the value to be inserted");
			           int val=s.nextInt();
			           head=insert_at_beg(head,val);
			           print(head);
			           break;
			   
			   case 2: System.out.println("Enter the value to be inserted");
			           int value=s.nextInt();
			           head=insert_at_end(head,value);
			           print(head);
			           break;
			   
			   case 3: System.out.println("Enter the value to be inserted");
			           int val1=s.nextInt();
			           System.out.println("Enter the position  where element is to be inserted");
			           int pos=s.nextInt();
			           head=insert_in_between(head,pos,val1);
			           print(head);
			           break;
			           
			   case 4: System.out.println("Enter the value to be inserted");
	                   int val2=s.nextInt();
	                   System.out.println("Enter the position  where element is to be inserted");
	                   int position=s.nextInt();
	                   head=Update(head, val2, position);
	                   print(head);
	                   break;
	           
			   case 5: System.out.println("Enter the position from where element is to be deleted");
                       int pos1=s.nextInt();
                       head=Delete(head, pos1);
                       print(head);
                       break;
               
			   case 6: print(head);
			           break;
			  
			 }
			System.out.println("Do you want to continue?? Y/N ");
			ch=s.next().charAt(0);
		}

	}

}

package DSA_Lab;

import java.util.Scanner;

public class Stack_implementation_LL {
	
	
	public static Node<Integer>input(){
		Scanner s =new Scanner(System.in);
		Node<Integer> top= null;
		System.out.print("Enter the values");
		int data= s.nextInt();
		
		while(data!=-1) {
			Node<Integer>newNode=new Node(data);
			if(top==null) {
				top=newNode;
			}
			else {
				
				newNode.next=top;
				top=newNode;
			}
			
			data=s.nextInt();
		}
		
		return top;
		
		
	}
	
	
	public static Node<Integer> push(Node<Integer> top, int val) {
		Node<Integer>newNode = new Node<>(val);
		
		if(top==null) {
			top=newNode;
		}
		newNode.next=top;
		top=newNode;
		
		return top;
	}
	
	public static Node<Integer> pop(Node<Integer> top){
		
	    if(top==null) {
		     System.out.println("The stack is empty");
		}
		else {
			System.out.println("The deleted element is " + top.data);
			top=top.next;
		}
		
		return top;
		
	}
	
	
	public static void traverse(Node<Integer>top) {
		Node<Integer>temp=top;
		
		while(top!=null) {
			System.out.print(top.data + " ");
			top=top.next;
		}
		System.out.println();
		
	}
	
	
	public static int peek(Node<Integer> top) {
		
		int top_Val=-1;
		if(top==null) {
			System.out.println("Stack is Empty");
		}else {
			top_Val=top.data;
		}
		
		return top_Val;
	}
	
	

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the Elements in the LL");
		Node<Integer>top=input();
		System.out.println("Choose from the below menu which operation is to be performed");
		System.out.println("1. Push elements in the Stack");
		System.out.println("2. Pop elements out of Stack");
		System.out.println("3. Print the Stack");
		System.out.println("4. View top element of the Stack");
		
		char ch= 'Y';
		
		while(ch=='Y'|| ch=='y') {
			
			System.out.println("Enter the operation number");
			int option=s.nextInt();
			
			switch(option) {
			    
			case 1 : System.out.println("Enter the value to be inserted");
			          int num=s.nextInt();
				      top= push(top, num);
				      traverse(top);
				      break;
				      
			case 2 : top=pop(top);
			         traverse(top);
			         break;
			         
			case 3: System.out.println("The stack is :");
			         traverse(top);
			         break;
			         
			case 4: int topmost_element=peek(top);
			        System.out.println("The topmost element is:" + topmost_element);
			        break;
			           
			}
			
			System.out.println("Do you want to continue?? Y/N ");
			ch=s.next().charAt(0);
		}
        
	}

}

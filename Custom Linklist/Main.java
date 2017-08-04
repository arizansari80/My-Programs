import java.io.IOException;
import java.io.DataInputStream;
import java.lang.Math;
import java.math.*;

class MyLinkList{
	private int d;
	private MyLinkList link;
	public MyLinkList(){
		link=null;
	}
	public MyLinkList insertBegin(MyLinkList s,int a,MyLinkList e){
		if(s==null){
			s=new MyLinkList();
			s.d=a;
			e.link=s;
		}
		else{
			MyLinkList temp=new MyLinkList();
			temp.link=s;
			s=temp;
			s.d=a;
		}
		return s;
	}
	public MyLinkList insertEnd(MyLinkList s,int a,MyLinkList e){
		if(s==null){
			s=new MyLinkList();
			s.d=a;
			e.link=s;
			return s;
		}
		MyLinkList temp=new MyLinkList();
		temp.d=a;
		e.link.link=temp;
		e.link=temp;
		return s;
	}
	public MyLinkList deleteBegin(MyLinkList s,MyLinkList e){
		if(s==null)
			System.out.println("Underflow");
		else if(s.link==null){
			s=null;
			e.link=null;
			e=null;
		}
		else
			s=s.link;
		return s;
	}
	public MyLinkList deleteEnd(MyLinkList s,MyLinkList e){
		if(s==null)
			System.out.println("Underflow");
		else if(s.link==null){
			s=null;
			e.link=null;
			e=null;
		}
		else{
			MyLinkList temp;
			temp=s;
			while(temp.link.link!=null)
				temp=temp.link;
			e.link=temp;
			e.link.link=null;
		}
		return s;
	}
	public void traversal(MyLinkList s){
		if(s==null){
			System.out.println("\n\nUnderflow No Link List to show\n\n");
			return;
		}
		MyLinkList temp=s;
		System.out.println("\nCurrent Link List is\n");
		while(temp.link!=null){
			System.out.print(temp.d+"->");
			temp=temp.link;
		}
		System.out.print(temp.d);
		System.out.println("\n");
	}
}

public class Main{
	public static void main(String[] args)throws IOException{
		FastReader fr=new FastReader();
		MyLinkList start=null;
		MyLinkList end=new MyLinkList();
		MyLinkList list=new MyLinkList();
		char ch;
		byte k;
		do{
			System.out.println("Menu");
			System.out.println("1.Insert Begin");
			System.out.println("2.Insert End");
			System.out.println("3.Delete Begin");
			System.out.println("4.Delete End");
			System.out.println("5.Traversal");
			System.out.println("\nEnter your choice");
			k=(byte)fr.getLong();
			switch(k){
				case 1:System.out.println("Enter the number");
					   start=list.insertBegin(start,(int)fr.getLong(),end);
					   break;
				case 2:System.out.println("Enter the number");
					   start=list.insertEnd(start,(int)fr.getLong(),end);
					   break;
				case 3:start=list.deleteBegin(start,end);
					   break;
				case 4:start=list.deleteEnd(start,end);
					   break;
				case 5:list.traversal(start);
					   break;
			}
			System.out.print("Want to Do More(y/n): ");
			ch=(char)System.in.read();
		}while(ch=='y'||ch=='Y');
	}
}
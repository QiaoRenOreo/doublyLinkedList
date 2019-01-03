package ss.week4;

import javax.xml.soap.Node;

public class DoublyLinkedList <Element> 

{
	private int size;
	private Node header;
	private Node first;
	private class Node
	{
		Element element;
		Node next;
		Node previous;
		public Node (Element element)
		{
			this.element=element;
			this.next=null;
			this.previous=null;
		}
	}

	//___________________constructor___________________
	public DoublyLinkedList()
	{
		size=0;
		first=null;
		header=first;
		header.next=header;
		header.previous=header;
	}
	//____________________commands_______________________
	public void add(int index, Element element)
	{
		Node newNode=new Node (element);
		Node last=header.previous;
		newNode.previous=last;
		newNode.next=header;
		header.previous=newNode;
		last.next=newNode;
		size=size+1;
	}
	public void remove(int index)
	{
		//Node n=get(index)
		get(index).previous.next = get(index).next;
		get(index).next.previous = get(index).previous;
		get(index).previous = null;
		get(index).next = null;
	}
	public Node get(int index)
	{
		Node p=first;
		int pos=0;
		while(pos!=index)
		{
			p=p.next;
			pos=pos+1;
		}
		return p;
	}
	
	public int size()
	{
		return this.size;
	}
}

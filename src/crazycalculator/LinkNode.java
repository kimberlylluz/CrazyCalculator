package crazycalculator;

public class LinkNode{
	public LinkNode next;
	public Object data;

	public LinkNode(){
		next = null;
	}

	public LinkNode (Object data){
		next = null;
		this.data = data;
	}
	
	public LinkNode getNext(){
		return next;
	}

	public void setNext (LinkNode node){
		next = node;
	}

	public Object getData(){
		return data;
	}

	public void setdata(Object elem){
		data = elem;
	}
	
}

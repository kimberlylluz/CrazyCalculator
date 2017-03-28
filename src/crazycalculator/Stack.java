package crazycalculator;

public class Stack{
	public Queue queue;
	
	public Stack()  {
		queue = new Queue();
	}
	  
	public void push(Object data) throws Exception{
		queue.enqueue(data);
		queue.display(1);
	}
	
	public Object pop() throws Exception{
		for (int i = 0; i < queue.size() - 1;i++ )
		{
			queue.enqueue(queue.dequeue ());
			queue.display(2);
		}
        
		queue.display(3);
        return queue.dequeue();
	}	   
	  
	public Object peek() throws Exception{
		return queue.first();
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public String toString(){
		return queue.toString();
	}

}

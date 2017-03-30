package crazycalculator;

public class Stack{
	public Queue queue;
	
	public Stack()  {
		queue = new Queue();
	}
	  
	public void push(Object data) throws Exception{
		queue.enqueue1(data);
	}
	
	public Object pop() throws Exception{
		for (int i = 0; i < queue.pseudoArray.size() - 1;i++ )
		{
			queue.enqueue(queue.dequeue ());
		}
		
		Object temp = queue.dequeue();
		queue.display(3);
        return temp;
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

package ch02.stringLogs;

/*
 * Note: a lot of this is copied from
 * 	the textbook named
 * 
 * Object-Oriented Data Structures Using Java
 * 	(Third Edition, Nell Dale, Daniel T. Joyce,
 * 			Chip Weems).
 * 
 * Though some of these methods are my creation,
 * 	the great majority of the code in this
 * 	is copied from the book.
 */

public class LinkedStringLog
{
	protected LLStringNode log;
	
	protected String name;
	
	public LinkedStringLog(String name)
	{
		this.name = name;
	}
	
	public void insert(String element)
	/*
	 * Inserts an LLStringNode initialized with
	 * the operand in place of log,
	 * pushing log and all subsequent nodes
	 * forward one place.
	 */
	{
		LLStringNode newNode = new LLStringNode(element);
		newNode.setLink(log);
		log = newNode;
	}
	
	public void insertAtBeginning(String element)
	{
		this.insert(element);
	}
	
	public void insertAtEnd(String element)
	{
		LLStringNode node = log;
		
		while (node.getLink() != null)
			node = node.getLink();
		
		node.setLink(new LLStringNode(element));
	}
	
	public void insertAll(String[] arr)
	/*
	 * Adds arr.length nodes to the list.
	 */
	{
		for (int index = 0; index < arr.length; index++)
		{
			this.insert(arr[index]);
		}
	}
	
	public boolean isFull()
	{
		return false;
	}
	
	public int size()
	{
		int count = 0;
		LLStringNode node;
		node = this.log;
		
		while(node != null)
		{
			count++;
			node = node.getLink(); // node = node->next;
		}
		
		return count;
	}
	
	public boolean contains(String element)
	{
		LLStringNode node;
		node = log;
		
		while (node != null)
		{
			if ( element.equalsIgnoreCase(node.getInfo()) )
				return true;
			else
				node = node.getLink();
		}
		
		return false;
	}
	
	public void clear()
	{
		log = null;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		String logString = name + "\n";
		LLStringNode node;
		node = log;
		int count = 0;
		
		while (node != null)
		{
			count++;
			logString = logString + count + ". " + node.getInfo() + "\n";
			node = node.getLink();
		}
		
		return logString;
	}
}

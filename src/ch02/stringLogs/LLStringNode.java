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

public class LLStringNode
{
	private String info;
	private LLStringNode link;
	
	public LLStringNode(String info)
	{
		this.info = info;
	}
	
	public void setInfo(String info)
	{
		this.info = info;
	}
	
	public String getInfo()
	{
		return this.info;
	}
	
	public void setLink(LLStringNode link)
	{
		this.link = link;
	}
	
	public LLStringNode getLink()
	{
		return link;
	}
}

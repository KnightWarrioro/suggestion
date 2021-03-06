	import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BUILDDICTIONARY {
	
	/*private boolean isWord;
	private BUILDDICTIONARY children[]=new BUILDDICTIONARY[256];
	
	public void add(String s)
	{
		int val=s.charAt(0)-'0';
		BUILDDICTIONARY child=children[val];
		if(child==null)
		{
			child=new BUILDDICTIONARY();
			children[val]=child;
		}
		if(s.length()==0)
		{
				child.isWord=true;
		}
		else
		{
			child.add(s.substring(1));
		}
	}*/
	
	private Set<String> dictionary=new HashSet<String>();
	private Map <Integer,List<String> >hm=new HashMap<Integer,List<String>>();
	
	
	void printSet()
	{
		for(String s:dictionary)
		{
			System.out.println(s+" ");
		}
	}
	void printHashMap()
	{
		for (Integer key: hm.keySet()) {

		    System.out.println("key : " + key);
		    List l = hm.get(key);
		    for(int k = 0; k < l.size(); k++){
	           
	            System.out.println(l.get(k));
		    }
		    
		}
		
	}
	void getInput(String path) throws IOException
	{
		FileReader fr=new FileReader(path);
		//BufferedReader br=new BufferedReader(fr);
		Scanner sc=new Scanner(fr);
		String input;
		while(sc.hasNext())
		{
			input=sc.next();
			int left_index=0,right_index=input.length()-1;
			for(int i=0;i<input.length();i++)
			{
				if(input.charAt(i)>='a'&&input.charAt(i)<='z')
					break;
				if(input.charAt(i)>='A'&&input.charAt(i)<='Z')
					break;
				left_index++;
			}
			for(int i=input.length()-1;i>=0;i--)
			{
				if(input.charAt(i)>='a'&&input.charAt(i)<='z')
					break;
				if(input.charAt(i)>='A'&&input.charAt(i)<='Z')
					break;
				right_index--;
			}
			//System.out.println(left_index+" "+right_index);
			if(left_index<right_index)
			{
				String s=input.subSequence(left_index, right_index+1).toString();
				//System.out.println("String formulated is "+s );
				dictionary.add(s);
			}
		}
		
	}
	void buildHashMap()
	{
		for(String s:dictionary)
		{
			int len=s.length();
			if(hm.containsKey(len))
			{
				hm.get(len).add(s);
			}
			else
			{
				List<String> list=new ArrayList();
				list.add(s);
				hm.put(len, list);
			}
			
		}
	}
	
	String getRecommendation(String word)
	{
		String suggestion="" ;
		int minyet=Integer.MAX_VALUE;
		int val;
		EDITDISTANCE edobj=new EDITDISTANCE();
		for (Integer key: hm.keySet()) {

		    //System.out.println("key : " + key);
		    List l = hm.get(key);
		    if(key>=(word.length()-2)&&key<=(word.length()+2))
		    {
			    for(int k = 0; k < l.size(); k++){
		           
		            val=edobj.editDist(word, (String)l.get(k));
		            if(val<minyet)
		            {
		            	minyet=val;
		            	suggestion=(String)l.get(k);
		            }
			    }
		    }
		    
		}
		return suggestion;
		
	}
	/*public static void main(String Args[]) throws IOException
	{
		BUILDDICTIONARY d=new BUILDDICTIONARY();
		d.getInput("sample.in");
		d.printSet();
		d.buildHashSet();
		d.printHashMap();
	}
	*/
	
}

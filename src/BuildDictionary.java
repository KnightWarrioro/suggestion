	import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BuildDictionary{
	
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
	

	void printHashMap()
	{
		for(Integer key:hm.keySet())
		{
			System.out.println("The key is" + key);
			for(String inter:hm.get(key).keySet())
			{
				System.out.println(inter+" : "+hm.get(key).get(inter));
			}
		}
	}
	private Map <Integer,Map<String,Integer> >hm=new HashMap<Integer,Map<String,Integer>>();
	
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
			//System.out.println("Here in input");
			//System.out.println(left_index+" "+right_index);
			if(left_index<right_index)
			{
				String s=input.subSequence(left_index, right_index+1).toString();
				s.toLowerCase();
				//System.out.println("Here in input");
				int len=s.length();
				if(hm.containsKey(len))
				{
					//System.out.println("Old values");
					Map<String,Integer> m=hm.get(len);
					if(m.containsKey(s)==true)
					{
						//System.out.println("value of m.get(s) "+m.get(s));
						m.put(s,hm.get(len).get(s)+1);
						hm.put( len,m);
					}
					else
					{
					
						m.put(s,1);
						//System.out.println("value of m.get(s) "+m.get(s));
						hm.put( len,m);
					}
				}
				else
				{
					Map<String,Integer> m=new HashMap<String,Integer>();
					//System.out.println("New Value detected");
					m.put(s,1);
					hm.put( len,m);
				}
				//System.out.println("String formulated is "+s );
			}
		}
		
	}
	
	String getRecommendation(String word)
	{
		String suggestion="" ;
		int minyet=Integer.MAX_VALUE;
		int val;
		EDITDISTANCE edobj=new EDITDISTANCE();
		List<Frequency> arrs=new ArrayList<Frequency>() ;
		for(Integer key:hm.keySet())
		{
			
			if((key>=word.length()-4)&&(key<=word.length()+2))
			for(String internal:hm.get(key).keySet())
			{
				val=edobj.editDist(word, internal);
				if(val<minyet)
				{
					arrs=new ArrayList<Frequency>() ;
					arrs.add(new Frequency(hm.get(key).get(internal),internal));
					minyet=val;
				}
				else if(val==minyet)
				{
					arrs.add(new Frequency(hm.get(key).get(internal),internal));
				}
			}
			
			
		}
		Collections.sort(arrs);
		
		return arrs.get(0).getValue();
		
	}
	/*public static void main(String Args[]) throws IOException
	{
		BuildDictionary d=new BuildDictionary();
		d.getInput("sample.in");
		//d.printSet();
		//d.buildHashSet();
		d.printHashMap();
	}
	*/
	
	
}

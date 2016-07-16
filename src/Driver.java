import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		/*Build Dictionary from input
		 * Building Temporary Word base Change needed as on 
		 * 16/07/2016 10:00PM
		*/
		
		String dict[]={"Hello","World","Tree","Free"};
		
		//Creating object for finding minimal change result
		EDITDISTANCE ob=new EDITDISTANCE();
		
		
		String Suggestion="" ;
		int minyet=Integer.MAX_VALUE;
		int val;
		String word;
		Scanner sc=new Scanner(System.in);
		word=sc.nextLine();
		
		sc.close();
		//Iterate Through the Dictionary and find possible answer
		for(int i=0;i<4;i++)
		{
			String given=dict[i];
			val=ob.editDist(given,word);
			if(val<minyet)
			{
				Suggestion=dict[i];
				minyet=val;
			}
		}
		System.out.println("The suggested word  is "+Suggestion);
	}

}

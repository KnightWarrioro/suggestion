import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws IOException {
		
		/*Build Dictionary from input
		 
		*/
		
		String suggestion;
		//Scanner sc=new Scanner(System.in);
		//String word=sc.next();
		BuildDictionary d=new BuildDictionary();
		d.getInput("big_doc.txt");
		
		
		int count_correct=0,count_total=0;
		double eff;
		FileReader fr=new FileReader("test1.txt");
		//BufferedReader br=new BufferedReader(fr);
		Scanner sc=new Scanner(fr);
		String input;
		while(sc.hasNext())
		{
		
			String word=sc.next();
			String expected=sc.next();
			String predicted=d.getRecommendation(word);
			
			//System.out.println(word+ " "+expected+" "+predicted);
			if(predicted.equals(expected))
			{
				count_correct++;
			}
			count_total++;
		}
		System.out.println(count_correct+" "+count_total);
		eff=(double)count_correct/count_total;
		eff*=100;
		System.out.println("The efficiency of the program is " +eff);
		
		
	}

}


public class Frequency implements Comparable<Frequency>{

	private int count;
	private String value;
	Frequency(int count,String value)
	{
		this.count=count;
		this.value=value;
	}
	int getCount()
	{
		return this.count;
	}
	String getValue()
	{
		return this.value;
	}
	@Override
	public int compareTo(Frequency o) {
		int val= this.getCount()-o.getCount();
		val*=-1;
		return val;
	}
}

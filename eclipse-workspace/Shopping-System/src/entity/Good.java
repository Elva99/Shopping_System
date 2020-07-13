package entity;

public class Good {

	private int gid;
	private String gname;
	private double gprice;
	private int gnum;

	//constructor for a good
	public Good(int gid,String gname,double gprice,int gnum) {
		this.gid=gid;
		this.gname=gname;
		this.gprice=gprice;
		this.gnum=gnum;
		
	}
	//get and set methods
	public int getGid()
	{
		return this.gid;
	}

	public String getGname()
	{
		return this.gname;
	}
	public double getGprice()
	{
		return this.gprice;
	}
	public int getGnum()
	{
		return this.gnum;
	}
	
	public void setGid(int newid)
	{
		this.gid=newid;
	}
	public void setGname(String newname)
	{
		this.gname=newname;
	}
	public void setGprice(double newprice)
	{
		this.gprice=newprice;
	}
	public void setGnum(int newnum)
	{
		this.gnum=newnum;
	}

}

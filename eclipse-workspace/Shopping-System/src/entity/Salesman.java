package entity;

public class Salesman {

	private String sa_username;
	private String sa_password;
	// salesman constructor
	public Salesman(String sa_username,String sa_password) {
		this.sa_username=sa_username;
		this.sa_password=sa_password;
		
	}
	public String getSausername()
	{
		return this.sa_username;
	}
	public String getSapassword()
	{
		return this.sa_password;
	}
	public void setSausername(String new_username)
	{
		this.sa_username=new_username;
	}
	public void setSapassword(String new_password)
	{
		this.sa_password=new_password;
	}


}

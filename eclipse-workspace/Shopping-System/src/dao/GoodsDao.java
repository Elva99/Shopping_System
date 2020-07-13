package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Good;

import database.dbconnection;
import database.dbdisconnection;

public class GoodsDao {

	public Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	
	
	/**
	 * add a new good to the goodslist database
	 * @param good
	 * @return
	 */
	public boolean addGood(Good good)
	{
		
		Boolean ifadded=false;
		conn=dbconnection.getConn();
		String sql="INSERT INTO goods (ID,Name,Price,Number) VALUES (?,?,?,?)";
		try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, good.getGid());
		pstmt.setString(2,good.getGname());
		pstmt.setDouble(3, good.getGprice());
		pstmt.setInt(4, good.getGnum());
		int result=pstmt.executeUpdate();
		if (result>0)
		{
			ifadded=true;
			//System.out.print("The new good is added to the database\n");
		}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbdisconnection.dbClose(pstmt, null, conn);
		}
		return ifadded;
	}
	
	/**
	 * delete a good in the goodslist database
	 * @param good
	 * @return
	 */
	
	public boolean deleteGood(int ID)
	{
		Boolean ifdeleted=false;
		conn=dbconnection.getConn();
		String sql="DELETE FROM goods WHERE ID=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ID);
			int result=pstmt.executeUpdate();
			if (result>0)
			{
				ifdeleted=true;
				//System.out.print("The good is deleted from the database\n");
			}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				dbdisconnection.dbClose(pstmt, null, conn);
			}
		
		return ifdeleted;
	}
	
	
	/**
	 * update the information of a good in the goodslist database
	 * @param good
	 * @param newinfo "type=newvalue"
	 * @param key update choice
	 */
	public boolean updateGood(Good good,int key,String newinfo)
	{
		Boolean ifupdated=false;
		if (!(1<=key&&key<=2))
		{
			System.out.println("The update choice is not supported. Please choose a key from 1 to 2.");
			return ifupdated;
		}
		switch(key) {
		
		
		case 1:
			//System.out.println("ready to update the price.");
			//System.out.println("Enter the new price.");
			try {
				conn=dbconnection.getConn();
				double price=Double.parseDouble(newinfo);
				String sql="UPDATE goods SET Price=? WHERE ID=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setDouble(1, price);
				pstmt.setInt(2, good.getGid());
				int result=pstmt.executeUpdate();
				if (result>0)
				{
					ifupdated=true;
					//System.out.print("The price of the good is updated.\n");
				}
				
				
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				dbdisconnection.dbClose(pstmt, null, conn);
			}
			break;
		case 2:
			//System.out.println("ready to update the number.");
			//System.out.println("Enter the new number.");
			try {
				conn=dbconnection.getConn();
				int num=Integer.parseInt(newinfo);
				String sql="UPDATE goods SET Number=? WHERE ID=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setInt(2, good.getGid());
				int result=pstmt.executeUpdate();
				if (result>0)
				{
					ifupdated=true;
					//System.out.print("The number of the good is updated.\n");
				}
				
				
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				dbdisconnection.dbClose(pstmt, null, conn);
			}
			break;
		default:	
			break;
			
		}
		
		return ifupdated;
	}
	public Boolean purchaseGood(Good good,int number_want)
	{
		Boolean ifsuccess=false;
		
		try {
			conn=dbconnection.getConn();
			int num=good.getGnum()-number_want;
			String sql="UPDATE goods SET Number=? WHERE Name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, good.getGname());
			int result=pstmt.executeUpdate();
			if (result>0)
			{
				ifsuccess=true;
				//System.out.print("The number of the good is updated.\n");
			}
			
			
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbdisconnection.dbClose(pstmt, null, conn);
		}
		
		return ifsuccess;
	}
	/**
	 * display all the goods with name gname
	 * @param gname
	 * @return
	 */
	public Good displayGoodByName(String gname)
	{
		Good good=null;
		conn=dbconnection.getConn();
		if (conn==null)
		{
			System.out.println("fail to connect db");
			return good;
		}
		String sql="SELECT * FROM goods WHERE Name=?";
		try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, gname);
		
		rs=pstmt.executeQuery();
		
		if(rs.next())
		{
			int ID=rs.getInt(1);
			String name=rs.getString(2);
			double price=rs.getDouble(3);
			int number=rs.getInt(4);
			good=new Good(ID,name,price,number);}
		
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbdisconnection.dbClose(pstmt, rs, conn);
		}
		return good;
	}
	/**
	 * display good with ID=ID
	 */
	public Good GooddisplayGoodByID(int ID)
	{
		Good good=null;
		conn=dbconnection.getConn();
		String sql="SELECT * FROM goods WHERE ID=?";
		try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, ID);
		rs=pstmt.executeQuery();
		if(rs.next())
		
		{
			String name=rs.getString(2);
			double price=rs.getDouble(3);
			int number=rs.getInt(4);
			good=new Good(ID,name,price,number);}
		
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbdisconnection.dbClose(pstmt, rs, conn);
		}
		return good;
		
	}
	/**
	 * display all the goods in the goodslist
	 * @return
	 */
	public ArrayList<Good> displayAllGood()
	{
		ArrayList<Good> list=new ArrayList<Good>();
		conn=dbconnection.getConn();
		String sql="SELECT * FROM goods";
		
		try
		{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next())
			{
				int ID=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				int number=rs.getInt(4);
				Good good=new Good(ID,name,price,number);
				list.add(good);
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {dbdisconnection.dbClose(pstmt, rs, conn);}
		return list;
		}
/*
public static void main(String[] args)
{
	GoodsDao GD=new GoodsDao();
	Good good=GD.displayGoodByName("dog");
	System.out.println(good.getGname());
	}*/
}

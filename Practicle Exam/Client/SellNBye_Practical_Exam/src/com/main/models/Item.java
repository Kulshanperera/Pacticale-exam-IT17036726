package com.main.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Item {
	public String getItems(){ 
		
		String itemsGrid = null; 
		Connection con=null; 
		Statement st=null; 
		ResultSet rs=null; 
	
	try {
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery("select* from productlist");
		if(rs.first())
		{
			itemsGrid ="<table border='1' cellspacing='1' cellpadding='1'><tr><th>id</th><th>Name</th><th>Price</th><th>Description<th><th>Editn</th><th>Delete</th></tr>";
			rs.beforeFirst();
			while(rs.next())
			{
				itemsGrid =itemsGrid +"<tr><td>" + rs.getString(1)+"</td>"
						+ "<td>" + rs.getString(2) + "</td>"
						+ "<td>" + rs.getString(3) + "</td>"
						+ "<td>" + rs.getString(4) + "</td>"
						+"<td><input id=\"btnRemove\" type=\"button\" name=\"btnRemove\"param=\"" +rs.getString(1) + "\" value =\"Remove\"</td></tr>";
			}
		}	
		else
			itemsGrid = "There are no Product items in store....";
		itemsGrid = itemsGrid + "</table></br>";
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return itemsGrid;
 }
public String getItems(String itmName) {
		
		String res= null;
		String sql = null;
		Connection con = null;
		Statement st = null;
		
		
		try {
			
			con = DBConnection.createConnection();
			st= con.createStatement();
			sql = "insert into items (nameitems) values('"+ itmName +"')";
					st.executeUpdate(sql);
					res = "Successfully Retrived....";
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		return res;
	}

}

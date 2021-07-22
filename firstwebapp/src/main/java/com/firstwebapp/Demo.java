package com.firstwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Demo implements Servlet
{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException 
	{
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		
		int id=Integer.parseInt(arg0.getParameter("id"));
		
		String name =arg0.getParameter("name");
		
		double salary =Double.parseDouble(arg0.getParameter("sal"));
		
		System.out.println(id+" "+name+" "+" "+salary);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false&user=root&password=abcd");
			st=cn.prepareStatement("insert into jspiders.emp values(?,?,?)");
			
			st.setInt(1, id);
			st.setString(2, name);
			st.setDouble(3, salary);
			
			st.execute();
			
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		PrintWriter out = arg1.getWriter();
		out.println("<html><body><h2 align="+"center"+"+>Data Inserted to Database </h2></body></html>");
		
	}

}

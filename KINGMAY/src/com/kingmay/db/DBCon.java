package com.kingmay.db;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DBCon {
	public static Connection DBconnection(){
		try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=king_may2","sa", "cam510");
		return con;
	}catch(Exception ex){
		ex.printStackTrace();
		return null;
		}
	}
	
	public static List<Map<String,String>> queryallpei(){
		List<Map<String,String>> l = new ArrayList<Map<String,String>>();
		try{
		Connection con = DBconnection();
		Statement st = con.createStatement();
		String sql="select * from Peis where ptype= '0' ";
		ResultSet rt =st.executeQuery(sql);
		while(rt.next())
		{
			Map<String,String> m = new HashMap<String,String>();
			m.put("name", rt.getString(rt.findColumn("pname")));
			m.put("type", String.valueOf(rt.getInt(rt.findColumn("ptype"))));
			l.add(m);
			if(rt.getInt(rt.findColumn("pchild")) == 1){
				List<Map<String,String>> list = queryalpei(rt.getString(rt.findColumn("pname")));
				if(list != null){
					for(Map<String, String> s : list){
						l.add(s);
					}
				}
			}
		}
		}catch(Exception ex)
		{
//			System.out.println("1"+ex.toString());
			return null;
		}
		return l;
	}
	public static  List<Map<String,String>> queryalpei(String pparent){
		List<Map<String,String>> l = new ArrayList<Map<String,String>>();
		try{
		Connection con = DBconnection();
		Statement st = con.createStatement();
		String sql="select * from Peis where ptype= '1' and pparent='"+pparent+"' order by pname desc";
		ResultSet rt =st.executeQuery(sql);
		while(rt.next())
		{
			Map<String,String> m = new HashMap<String,String>();
			m.put("name", rt.getString(rt.findColumn("pname")));
			m.put("type", String.valueOf(rt.getInt(rt.findColumn("ptype"))));
			l.add(m);
			if(rt.getInt(rt.findColumn("pchild")) == 1){
				List<Map<String,String>> list = queryapei(rt.getString(rt.findColumn("pname")));
				if(list != null){
					for(Map<String, String> s : list){
						l.add(s);
					}
				}
			}
		}
		}catch(Exception ex)
		{
//			System.out.println("2"+ex.toString());
			return null;
		}
		return l;
	}
	
	public static List<Map<String,String>> queryapei(String pparent){
		List<Map<String,String>> l = new ArrayList<Map<String,String>>();
		try{
		Connection con = DBconnection();
		Statement st = con.createStatement();
		String sql="select * from Peis where ptype= '2' and pparent='"+pparent+"' order by pname desc";
		ResultSet rt =st.executeQuery(sql);
		while(rt.next())
		{
			Map<String,String> m = new HashMap<String,String>();
			m.put("name", rt.getString(rt.findColumn("pname")));
			m.put("type", String.valueOf(rt.getInt(rt.findColumn("ptype"))));
			l.add(m);
		}
		}catch(Exception ex)
		{
//			System.out.println("3"+ex.toString());
			return null;
		}
		return l;
	}
}


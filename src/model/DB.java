package model;

import java.sql.*;
import java.util.Arrays;

import controller.Messages;

public class DB {
	
	public String dbUsername = "root";
	public String dbPass = "password";
	
	public Connection myConn;
	public static Statement myStmt;
	
	private static String operators[] = {"=",">","<",">=","<=","<>"};
	
	public DB() throws SQLException
	{	
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",dbUsername,dbPass);
			myStmt = myConn.createStatement();
	}
	
	
	
	
	public static ResultSet get (String what, String table, String[][] wheres) {
		String where="";
		
		if(wheres==null) {
			try {
				return(myStmt.executeQuery("SELECT"+what+" FROM "+table+";"));
			} catch (SQLException e) {
				Messages.showError(2);
				e.printStackTrace();
			}
		}
		else if(wheres.length>0) 
		{	
			for(int i=0;i<wheres.length;i++) {
				if(wheres[i].length==3 && Arrays.asList(operators).contains(wheres[i][1]))
				{
					if (!wheres[i][2].matches("[0-9]+")) wheres[i][2]="'"+wheres[i][2]+"'";
					if(i==0) {where+=wheres[0][0]+wheres[0][1]+wheres[0][2];}
					else{where+=" AND "+wheres[i][0]+wheres[i][1]+wheres[i][2];}
				}
			}
			try {
				return (myStmt.executeQuery("SELECT "+what+" FROM "+table+" WHERE "+where+";"));
			} catch (SQLException e) {
				Messages.showError(2);
				e.printStackTrace();
			}
		}
				
		return null;
		
	}
	
	public static ResultSet delete (String what, String table, String[][] wheres){
		String where="";
		
		if(wheres==null) {
			try {
				return(myStmt.executeQuery("DELETE "+what+" FROM "+table+";"));
			} catch (SQLException e) {
				Messages.showError(2);
				e.printStackTrace();
			}
		}
		
		else if(wheres.length>0) 
		{	
			for(int i=0;i<wheres.length;i++) {
				if(wheres[i].length==3 && Arrays.asList(operators).contains(wheres[i][1]))
				{
					if (!wheres[i][2].matches("[0-9]+")) wheres[i][2]="'"+wheres[i][2]+"'";
					if(i==0) {where=wheres[0][0]+wheres[0][1]+wheres[0][2];}
					else{where.concat(" AND "+wheres[i][0]+wheres[i][1]+wheres[i][2]);}
				}
			}
			try {
				return(myStmt.executeQuery(new String ("DELETE "+what+" FROM "+table+" WHERE "+where+";")));
			} catch (SQLException e) {
				Messages.showError(2);
				e.printStackTrace();
			}
		}
				
		 
		return null;
	}
	
	
	
	public static int insert (String table, String[][]fields) 
	{	
		String cols ="(" ;
		String vals= "(";
		for(int i=0;i<fields.length;i++)
		{	
			 if(fields[i].length!=2 ){break;}
			 
			 cols += (i == fields.length - 1) ? fields[i][0] + ")" : fields[i][0]+" , ";
			 if(fields[i][1].matches("[0-9]+"))
			 {
				 vals+= ((i == fields.length - 1) ? fields[i][1] + " )" : fields[i][1] + " , " );
			 }
			 else
			 {
				 vals+= "'"+ ((i == fields.length - 1) ? fields[i][1] + "')" : fields[i][1] + "' , " ); 
			 }
			 
		}
		
		try {
			return(myStmt.executeUpdate(new String("INSERT INTO "+table+" "+cols+" VALUES "+vals)));
		} catch (SQLException e) {
			Messages.showError(2);
			e.printStackTrace();
			return 0;
		}
		
	}
	
	
	public static int update(String table, String[][] fields,String[]where)
	{	String changes="";
		for(int i=0;i<fields.length;i++) {
			if(fields[i].length!=2 ){break;}
			
			if(fields[i][1].matches("[0-9]+"))
			 {
				 changes+= fields[i][0]+" = "+fields[i][1];
				 if(i != fields.length - 1)  changes+= " , " ;
			 }
			 else
			 {
				 changes+= fields[i][0]+" = '"+fields[i][1]+((i == fields.length - 1) ? fields[i][1] + "'" : fields[i][1] + "' , " ); 
			 }
		}
		
		try {
			return myStmt.executeUpdate("UPDATE "+table+" SET "+changes+" WHERE "+where[0]+"= '"+where[1]+"' ;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*ADD DIALOGUE WINDOW HERE with the dialogue class*/
		}
		return 0;
	}
	
	
	
	
	
	
	
}

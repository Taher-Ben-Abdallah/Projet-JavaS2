package model;

import java.sql.*;
import java.util.Arrays;

public class DB {
	
	public String dbUsername = "root";
	public String dbPass = "password";
	
	public Connection myConn;
	public Statement myStmt;
	
	private String operators[] = {"=",">","<",">=","<=","<>"};
	
	public DB() throws SQLException
	{	
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",dbUsername,dbPass);
			myStmt = myConn.createStatement();
	}
	
	
	
	
	public ResultSet get (String what, String table, String[][] wheres) {
		String where="";
		
		if(wheres==null) {
			System.out.println("hey");
			try {
				return(myStmt.executeQuery("SELECT"+what+" FROM "+table+";"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
					else{where+=" AND "+wheres[i][0]+wheres[i][1]+wheres[i][2];}
				}
			}
			try {
				
				return (myStmt.executeQuery("SELECT "+what+" FROM "+table+" WHERE "+where+";"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return null;
		
	}
	
	public ResultSet delete (String what, String table, String[][] wheres){
		String where="";
		
		if(wheres==null) {
			try {
				return(myStmt.executeQuery("SELECT"+what+" FROM "+table+";"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		 
		return null;
	}
	
	
	
	public void insert (String table, String[][]fields) 
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
			myStmt.executeQuery(new String("INSERT INTO "+table+" "+cols+" VALUES "+vals));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*ADD DIALOGUE WINDOW HERE with the dialogue class*/
		}
	}
	
	
	public void update(String table, String[][] fields,String login)
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
			myStmt.executeQuery("UPDATE "+table+" SET "+changes+" WHERE login= '"+login+"' ;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*ADD DIALOGUE WINDOW HERE with the dialogue class*/
		}
	}
	
	
	
	
	
	
	
}

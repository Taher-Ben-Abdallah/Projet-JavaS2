package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

	public String categ;
	public String name;
	public int classe_id; 
	
	private String login;
	private String pwd;
	
	
	public User(ResultSet rs,String userCat) throws SQLException {
		categ= userCat;
		name= rs.getString("prenom")+" "+rs.getString("nom");
		
		login= rs.getString("login");
		pwd= rs.getString("pwd");
		
		if(categ=="etudiant")
			 classe_id= rs.getInt("id_classe");
			
	}
	
	public String getClasse(DB db) {
		ResultSet rs =db.get("*", "classe", new String[][] {{"id_classe","=",String.valueOf(classe_id)}});
		try {
			if(rs.next())
			{
				return rs.getString(4)+String.valueOf(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

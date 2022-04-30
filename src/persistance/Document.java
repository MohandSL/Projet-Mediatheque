package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mediatek2022.Utilisateur;

public class Document implements mediatek2022.Document{
	
	String BDD = "projetee";
	String url ="jdbc:mysql://localhost:3306/" + BDD;
	String user = "root";
	String passwd = "root";
    
	int id;
	int type;
	String nom;
	int idClient;
	String duree;
	String realisateur;
	String compositeur;
	String auteur;
	

	public Document(ArrayList<String> Tab) {
		id = Integer.parseInt(Tab.get(0));
		type = Integer.parseInt(Tab.get(1));
		nom = Tab.get(2);
		idClient = Integer.parseInt(Tab.get(3));
		
		if(type==1) {
			compositeur = Tab.get(4);
			duree = Tab.get(5);
			
		}		
		if(type==2) {
			realisateur = Tab.get(4);
			duree = Tab.get(5);
		}
		
		if(type==3) {
			auteur = Tab.get(4);
		}
		
	}
	

	@Override
	public boolean disponible() {
		if(idClient==0) {
			return true;
		}
		return false;
	}

	@Override
	public void emprunt(Utilisateur u) throws Exception {
        
		String req1 = "UPDATE document set idClient="+ u.data()[0]+" WHERE idDocument="+id+"";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			stmt = conn.createStatement();
			stmt.executeUpdate(req1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void retour() {
		String req1 = "UPDATE document set idClient=0 WHERE idDocument="+id+"";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			stmt = conn.createStatement();
			stmt.executeUpdate(req1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public String toString() {
		
		
		
		if(type==1) {
			String heure[] = duree.split("\\.");
			System.out.println(heure[0]+":" + heure[1]);
			return "Le nom:  " + nom + "  compositeur: "  + compositeur + "  dure:  " + heure[0]+":" + heure[1];
		}
		
		if(type==2) {
			String heure[] = duree.split("\\.");
			System.out.println(heure[0]+":" + heure[1]);
			return "Le nom:  " + nom + "  realisateur: "  + realisateur + "  dure:  " + heure[0]+":" + heure[1];
		}
		
		if(type==3) {
			return "Le nom:  " + nom + "  auteur: "  + auteur;
		}
		
		return null;
	}
}

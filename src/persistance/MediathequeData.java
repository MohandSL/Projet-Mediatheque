package persistance;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import mediatek2022.*;

// classe mono-instance  dont l'unique instance est connue de la médiatheque
// via une auto-déclaration dans son bloc static

public class MediathequeData implements PersistentMediatheque {
// Jean-François Brette 01/01/2018
	String BDD;
	String url;
	String user ;
	String passwd;
	Connection conn;
	
	static {
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
		//Mediatheque.getInstance().setData(new MediathequeData());
		 try {
			Mediatheque.getInstance().setData(new MediathequeData());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private MediathequeData() throws ClassNotFoundException {
		BDD = "projetee";
        url = "jdbc:mysql://localhost:3306/" + BDD;
        user = "root";
        passwd = "root";
        Class.forName("com.mysql.jdbc.Driver");
        try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// renvoie la liste de tous les documents disponibles de la médiathèque
	@Override
	public List<mediatek2022.Document> tousLesDocumentsDisponibles() {
		ArrayList<String> Tab = new ArrayList<>();
		List<mediatek2022.Document> ListDoc = new ArrayList<>();
		
		String req1 = "SELECT * FROM document";

		Statement stmt = null;
		ResultSet res = null;
		
		try {
			
			stmt = conn.createStatement();
			res = stmt.executeQuery(req1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (res.next()){
				
				int id = res.getInt("idDocument"); 
				int type = res.getInt("typeDocument");
				String nom = res.getString("nomDocument"); 
				int idClient = res.getInt("idClient");
				
				Float duree = res.getFloat("Durée");
		        String realisateur = res.getString("Realisateur");
		        String compositeur = res.getString("Compositeur");
		        String auteur = res.getString("Auteur");
		        
				Tab.add(Integer.toString(id)); 
				Tab.add(Integer.toString(type)); 
				Tab.add(nom);
				Tab.add(Integer.toString(idClient)); 
				
				if(type==1) {
					Tab.add(compositeur);
					Tab.add(Float.toString(duree));
				}
				
				if(type==2) {
					Tab.add(realisateur);
					Tab.add(Float.toString(duree));
				}
				if(type==3) {
					Tab.add(auteur);
				}
				
				Document Doc = new Document(Tab);
				Tab.clear();
				ListDoc.add(Doc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ListDoc;
	}

	// va récupérer le User dans la BD et le renvoie
	// si pas trouvé, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		String req1 = "SELECT * FROM client WHERE nomClient='" + login +"' AND mdpClient='"+ password +"'";
		
		Statement stmt = null;
		ResultSet res = null;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			stmt = conn.createStatement();
			res = stmt.executeQuery(req1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//int cpt=0;
		
	    if(res!= null) {   	
	    	ArrayList<String> Compte = new ArrayList<>();
	    	try {
				while (res.next()){
					int id = res.getInt("idClient"); 
					String nom = res.getString("nomClient"); 
					String mdp = res.getString("mdpClient");
					int type = res.getInt("typeClient");
					Compte.add(Integer.toString(id)); 
					Compte.add(nom); 
					Compte.add(mdp); 
					Compte.add(Integer.toString(type)); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	
	    	Utilisateur u = new Utilisateur(Compte);
	    	return u;
	    }else
	    	return null;
	}

	// va récupérer le document de numéro numDocument dans la BD
	// et le renvoie
	// si pas trouvé, renvoie null
	@Override
	public mediatek2022.Document getDocument(int numDocument) {
		List<mediatek2022.Document> ListDoc = tousLesDocumentsDisponibles();
		return ListDoc.get(numDocument);
	}

	@Override
	public void ajoutDocument(int type, Object... args) {
		
		// args[0] -> le titre
		// args [1] --> l'auteur
		// etc... variable suivant le type de document
		
		String req = null;
		
		if(type==1) {
			
			req = "INSERT INTO document(idDocument, typeDocument, nomDocument, idClient, Durée, auteur, compositeur, realisateur)"
					+ " VALUES (NULL , " + type +" ,'"+ args[0] +"' , 0 ,"+args[1]+",NULL,'"+args[2]+"',NULL)";
		}
		
		if(type==2) {
			req = "INSERT INTO document(idDocument, typeDocument, nomDocument, idClient, Durée, auteur, compositeur, realisateur)"
					+ " VALUES (NULL , " + type +" ,'"+ args[0] +"'  , 0 ,"+args[1]+",NULL,NULL,'"+args[2]+"')";
		}

		if(type==3) {
			req = "INSERT INTO document(idDocument, typeDocument, nomDocument, idClient, Durée, auteur, compositeur, realisateur)"
					+ " VALUES (NULL , " + type +" ,'"+ args[0] +"' , 0 ,NULL,'"+args[1]+"',NULL,NULL)";
		}
		
			Statement stmt = null;
			
			try {
				conn = DriverManager.getConnection(url, user, passwd);
				stmt = conn.createStatement();
				stmt.executeUpdate(req);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

}

package persistance;

import java.util.ArrayList;

public class Utilisateur implements mediatek2022.Utilisateur {
	String id;
	String name;
	Boolean isBibliothecaire;
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(ArrayList<String> user) {
		id = user.get(0);
		name = user.get(1);
		if(user.get(3).equals("1")) {
			isBibliothecaire = true;
		}
		else
			isBibliothecaire=false;
	}
	
	public int idClient() {
		return Integer.parseInt(id);
	}
	
	@Override
	public String name() {
		return name;
	}

	@Override
	public boolean isBibliothecaire() {
		return isBibliothecaire;
	}

	@Override
	public Object[] data() {
		Object[] Tab = new Object[] { 
				Integer.parseInt(id)};
		
		return Tab;
	}

}

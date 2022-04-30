package servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mediatek2022.Mediatheque;

@WebServlet("/BibliothecaireServlet")
public class BibliothecaireServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    
    
    @SuppressWarnings("static-access")
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	String typeDoc = req.getParameter("TypeDoc");
        String nom = req.getParameter("Nom");
        String duree = req.getParameter("Duree");
        String realisateur = req.getParameter("Realisateur");
        String compositeur = req.getParameter("Compositeur");
        String auteur = req.getParameter("Auteur");
        
        int type=Integer.parseInt(typeDoc); 
        
        
        /*
        MediathequeData m = null;
        try {
			m = new MediathequeData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Utilisateur u  = m.getUser(identifiant, password);
        */
        
        mediatek2022.Mediatheque m = Mediatheque.getInstance();
     
        if(type==1) {
        	float temp= Float.parseFloat(duree);
        	m.ajoutDocument(type,nom,temp,compositeur);
        }
        if(type==2) {
        	float temp= Float.parseFloat(duree);
        	m.ajoutDocument(type,nom,temp,realisateur);
        }
        if(type==3)
        	m.ajoutDocument(type,nom,auteur);
        
        RequestDispatcher dispatcher;
        
        dispatcher = req.getRequestDispatcher("bibliothecaire.jsp");
        dispatcher.forward(req,resp);
        
        //this.getServletContext().getRequestDispatcher("form.jsp");

        /*
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Student Resistration Form Data</h1>");
        printWriter.print("<p> firstName :: " + identifiant + "</p>");
        printWriter.print("<p> lastName :: " + password + "</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();

        System.out.println("identifiant :: " + identifiant);
        System.out.println("password :: " + password);
        */

        
    }
}

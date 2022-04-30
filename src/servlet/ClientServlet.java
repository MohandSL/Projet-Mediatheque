package servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2022.*;


@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	HttpSession session = req.getSession(false);
    	
        String doc = req.getParameter("doc");
        String fonct = req.getParameter("fonct");
        int nb=Integer.parseInt(doc); 
        
        Object obj = session.getAttribute("utilisateur");
        
        mediatek2022.Utilisateur u  =  null;
        
        if( obj!=null){
        	u = (Utilisateur) obj;
        }

        mediatek2022.Mediatheque m = Mediatheque.getInstance();
        
        try {
        	if(fonct.equals("emprunt")) {
        		m.getDocument(nb).emprunt(u);
        	}
        	if(fonct.equals("retour")) {
        		m.getDocument(nb).retour();
        	}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        RequestDispatcher dispatcher;

        dispatcher = req.getRequestDispatcher("client.jsp"); dispatcher.forward(req,resp);

        
    }
}

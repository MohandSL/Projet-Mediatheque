package servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2022.Mediatheque;


@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String identifiant = req.getParameter("identifiant");
        String password = req.getParameter("password");

        
        mediatek2022.Mediatheque m = Mediatheque.getInstance();
        
        mediatek2022.Utilisateur u  =  m.getInstance().getUser(identifiant, password);
        
        HttpSession session = req.getSession();

        session.setAttribute("utilisateur", u);
        
        RequestDispatcher dispatcher;
        
        if(u!=null) {
        	if(u.isBibliothecaire()== true) {
        		
                dispatcher = req.getRequestDispatcher("bibliothecaire.jsp"); dispatcher.forward(req,resp);
        	} else {

                 dispatcher = req.getRequestDispatcher("client.jsp"); dispatcher.forward(req,resp);
        	}
        	
        }else if(u==null){
               dispatcher = req.getRequestDispatcher("form.jsp"); dispatcher.forward(req,resp);
        }
        

    }
}

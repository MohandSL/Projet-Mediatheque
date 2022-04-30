package servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(urlPatterns="/jghjh", loadOnStartup=1)

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException	{	
		//try {
			super.init();
			System.out.println("*.............................................................................................*");
			try {
				Class.forName("persistance.MediathequeData");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	
	}
	
}

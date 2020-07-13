package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class handleCharacter
 */

public class handleCharacter extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleCharacter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void destroy()
    {
    	super.destroy();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		String choicestr=request.getParameter("ucharacter").trim();
		int choice=Integer.parseInt(choicestr);
		PrintWriter out=response.getWriter();
		switch(choice) {
		case 1:
			RequestDispatcher disc=request.getRequestDispatcher("customerPage.html");
			disc.forward(request, response);
			break;
		case 2:
			RequestDispatcher diss=request.getRequestDispatcher("salesmanPage.html");
			diss.forward(request, response);
			break;
		case 3:
			RequestDispatcher dise=request.getRequestDispatcher("ExitPage.html");
			dise.forward(request, response);
		default:
			out.println("Please choose a number from 1 to 3.");
			RequestDispatcher diserror=request.getRequestDispatcher("index.html");
			diserror.include(request, response);
		}
		
		
	}

}

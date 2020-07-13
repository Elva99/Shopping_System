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
 * Servlet implementation class HandlecustomerPage
 */
@WebServlet("/HandlecustomerPage")
public class HandlecustomerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandlecustomerPage() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String choicestr=request.getParameter("customerchoice");
		int choice=Integer.parseInt(choicestr);
		switch(choice) {
		case 1:
			RequestDispatcher dis1=request.getRequestDispatcher("searchGoodPage.html");
			dis1.forward(request, response);
			break;
			
		case 2:
			RequestDispatcher dis2=request.getRequestDispatcher("DisplayAllGoodsPage");
			dis2.forward(request, response);
			break;
		case 3:
			RequestDispatcher dis3=request.getRequestDispatcher("purchaseGoodpage.html");
			dis3.forward(request, response);
			break;
		case 4:
			RequestDispatcher dis4=request.getRequestDispatcher("ExitPage.html");
			dis4.forward(request, response);
			break;
		default:
			break;
		}
		
	}

}

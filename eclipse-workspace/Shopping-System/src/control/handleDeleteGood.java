package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
import entity.Good;

/**
 * Servlet implementation class handleDeleteGood
 */
@WebServlet("/handleDeleteGood")
public class handleDeleteGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleDeleteGood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String name=request.getParameter("goodname");
		GoodsDao GD=new GoodsDao();
		Good good=GD.displayGoodByName(name);
		PrintWriter out=response.getWriter();
		if (good==null)
		{
			out.println("The good does not exist, please enter another good name.");
			RequestDispatcher disc=request.getRequestDispatcher("deleteGood.html");
			disc.include(request, response);
		}
		else
		{
			Boolean ifsuccess=GD.deleteGood(good.getGid());
			if (ifsuccess)
			{
				out.println("<html><body><p>");
				out.println("delete successfully.");
				out.println("</p></body></html>");
			}
			else
			{
				out.println("<html><body><p>");
				out.println("fail.");
				out.println("</p></body></html>");
			}
		}
		out.close();
	}

}

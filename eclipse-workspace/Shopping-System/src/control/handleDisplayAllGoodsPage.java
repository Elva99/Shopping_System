package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
import entity.Good;

/**
 * Servlet implementation class handleDisplayAllGoodsPage
 */
@WebServlet("/handleDisplayAllGoodsPage")
public class handleDisplayAllGoodsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleDisplayAllGoodsPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		GoodsDao GD=new GoodsDao();
		
		ArrayList<Good> goods=GD.displayAllGood();
		for (Good good:goods)
		{
			out.println("<p>ID:  "+good.getGid()+"  name:  "+good.getGname()+"  price:  "+good.getGprice()+"  number:  "+good.getGnum()+"</p>");
		}
		out.close();
	}

}

package com.wantdo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wantdo.dao.ISaleDAO;
import com.wantdo.dao.impl.SaleDAO;
import com.wantdo.pojo.Sale;

public class JDdaifaServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public JDdaifaServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String xiaoliang = request.getParameter("xiaoliang");
		String liuliang = request.getParameter("liuliang");
		String shangjia = request.getParameter("shangjia");
		String laiyuan = request.getParameter("laiyuan");
		String flowInfo = request.getParameter("flowInfo");
		if(xiaoliang != ""){
			xiaoliang = "[{" + xiaoliang +"}]";

			System.out.println(xiaoliang);
			
			ISaleDAO dao = new SaleDAO();
			
			List<Sale> sales = dao.getSale(xiaoliang);
			for(Sale s : sales) {
				System.out.println(s.getId() + " ============================ ");
			}

		}

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

/**
 * Copyright(C) 2019 Luvina JSC
 * ListUserServlet.java, Sep 30, 2019, HangHT
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import model.UserLogic;

/**
 * @author HangHT
 *
 */
public class ListUserServlet extends HttpServlet{
	private UserLogic ul;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ul = new UserLogic();
			ArrayList<UserBean>lsUser = ul.getListUser();
			req.setAttribute("listUser", lsUser);
			RequestDispatcher rd = req.getRequestDispatcher("listUser.jsp");
			rd.forward(req, resp);
			System.out.println(lsUser);
		} catch (Exception e) {
			System.out.println("==============");
			System.out.println("Loi " + e.getMessage());
			System.out.println(e.getLocalizedMessage());
			resp.setCharacterEncoding("UTF-8");
			StringBuilder mess = new StringBuilder(e.getMessage());
			resp.sendRedirect("error?errdetail="+mess);
		} 
		System.out.println("doget");
	}
}

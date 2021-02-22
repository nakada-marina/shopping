package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/account_management")
public class ManageAccountServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		// ボタン押下時の値を取得する
		String buttonType = req.getParameter("buttonType");
		
		// アカウント変更ボタン押下時、アカウント変更画面へ遷移する
		if("account_change".equals(buttonType)) {

			req.setAttribute("url","account_change");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}	
		
		// パスワード変更ボタン押下時、アカウント変更画面へ遷移する
		if("password_change".equals(buttonType)) {
			req.setAttribute("url","password_change");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		// パスワード変更ボタン押下時、アカウント変更画面へ遷移する
		if("account_delete".equals(buttonType)) {
			req.setAttribute("url","account_delete");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}	
	}
	
	
}

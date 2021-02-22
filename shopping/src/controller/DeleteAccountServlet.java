package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccountBean;
import service.AccountService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/account_delete")
public class DeleteAccountServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	
		// Serviceの呼び出し
		AccountService accountService = new AccountService();
		
		// 現在のアカウント情報をセッションから取得する
		HttpSession session = req.getSession(true);
		AccountBean account = new AccountBean();
		account = (AccountBean)session.getAttribute("account");
		
		// アカウント情報をDBから削除する
		accountService.deleteAccount(account);
		
		// 前回のセッション情報を削除する
		session.removeAttribute("account");
		
		// ログイン画面へ遷移する
		req.setAttribute("url","logout");
		resp.sendRedirect("./index.jsp");
	}
	
	
}

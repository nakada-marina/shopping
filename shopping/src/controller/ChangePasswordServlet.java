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
@WebServlet("/password_change")
public class ChangePasswordServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		// 変更前のアカウント情報をセッションから取得する
		HttpSession session = req.getSession(true);
		AccountBean sessionAccount = new AccountBean();
		sessionAccount = (AccountBean)session.getAttribute("account");
		
		// 変更前のアカウントをパラメタから取得する
		String rePassword = req.getParameter("rePassword");
		
		// 変更後のアカウントをパラメラから取得する
		String newPassword = req.getParameter("newPassword");
		
		// Serviceの呼び出し
		AccountService accountService = new AccountService();
		AccountBean accountBean = new AccountBean();
		accountBean = accountService.changePassword(sessionAccount, newPassword, rePassword);
		
		// 変更成功できた場合
		if(!(accountBean == null)) {
			
			// Emailをセッション情報から取得し、Email,パスワード以外の情報も取得する
			accountBean.setE_mail(sessionAccount.getE_mail());
			// 変更後のパスワードをセッションにセットする
			session.setAttribute("account", accountService.showAccountInfo(accountBean));
			
			// アカウント管理画面へ遷移する
			req.setAttribute("url","account_management");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else {
			// 画面遷移しない
			req.setAttribute("url","password_change");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);

		}
		
		}
}

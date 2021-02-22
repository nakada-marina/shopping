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
@WebServlet("/account_change")
public class ChangeAccountServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		// 変更前のアカウント情報をセッションから取得する
		HttpSession session = req.getSession(true);
		AccountBean preAccountBean = new AccountBean();
		preAccountBean = (AccountBean)session.getAttribute("account");
		
		// Serviceの呼び出し
		AccountService accountService = new AccountService();
		
		// 入力内容が正しければ、DBを変更する
		AccountBean accountBean = new AccountBean();
		accountBean = accountService.checkChangeInfo(req, preAccountBean);
		
		// 成功の場合
		if(!(accountBean == null)){
			
			// 有効の場合、セッション情報にアカウント情報をセットする（更新)
			session = req.getSession(false);
			session.setAttribute("account", accountBean);
			
			// アカウント管理画面へ遷移する
			req.setAttribute("url","account_management");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else {
			// TODO アカウントが無効である場合、とにかくエラーを画面に表示する。
			req.setAttribute("url","account_change");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
}

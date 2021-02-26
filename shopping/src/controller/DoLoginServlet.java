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
@WebServlet("/dologin")
public class DoLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		// Serviceの呼び出し
		AccountService accountService = new AccountService();

		// ログイン情報から　アカウント情報を取得する
		AccountBean accountBean = new AccountBean();
		accountBean = accountService.checkLoginInfo(req);

		// アカウントが有効である場合
		if(!(accountBean == null)) {

			//有効の場合 セッション情報に、アカウント情報をセットする（新規）
			HttpSession session = req.getSession(true);
			session.setAttribute("account", accountBean);

			// アカウント管理画面へ遷移する
			req.getRequestDispatcher("./WEB-INF/account/account_management.jsp").forward(req, resp);
			return;

		}else {

			// アカウントが無効の場合
			req.setAttribute("errorFlg","1");

			// 画面を遷移しない
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}


		}
}

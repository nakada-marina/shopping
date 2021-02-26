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

	/**アカウントの新規登録を行うサーブレットクラス。
	 * @author education
	 *
	 */
	@WebServlet("/doRegist")
	public class RegistAccountServlet extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			// Serviceの呼び出し
			AccountService accountService = new AccountService();

			// 入力内容が正しければ、DBに登録する
			AccountBean accountBean = new AccountBean();
			accountBean = accountService.checkRegistInfo(req);

			// 成功の場合
			if(!(accountBean == null)){

				//有効の場合 セッション情報に、アカウント情報をセットする
				HttpSession session = req.getSession(true);
				session.setAttribute("account", accountBean);

				// アカウント管理画面へ遷移する
				req.setAttribute("url","account_management");
				req.getRequestDispatcher("./WEB-INF/account/account_management.jsp").forward(req, resp);

			}else {
				// TODO アカウントが無効である場合、とにかくエラーを画面に表示する。
				req.setAttribute("errorFlg","1");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
		}
	}

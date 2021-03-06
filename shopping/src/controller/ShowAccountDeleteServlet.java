package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show_account_delete")
public class ShowAccountDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		// 戻るボタンが押されたかどうかの判定を行う
		String click = req.getParameter("click");

		// 戻るボタン押下時
		if ("1".equals(click)) {
			// アカウント管理画面へ遷移する
			req.getRequestDispatcher("./WEB-INF/account/account_management.jsp").forward(req, resp);
		} else {
			// 戻るボタン以外押下時
			// パスワード削除画面へ遷移する
			req.getRequestDispatcher("./WEB-INF/account/account_delete.jsp").forward(req, resp);
		}

	}

}

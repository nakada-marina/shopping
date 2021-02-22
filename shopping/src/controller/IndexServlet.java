package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccountBean;
import dao.ProductDao;
import service.ProductService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	/**
	 *POSTリクエストの処理を行います。
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		// ボタン押下時の値を取得する
		String buttonType = req.getParameter("buttonType");
		ProductService proService = new ProductService();
		
		// アカウント新規登録ボタン押下時、アカウント新規登録画面へ遷移する
		if("account_regist".equals(buttonType)) {
			req.setAttribute("url","account_regist");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		// 戻るボタン押下時、アカウント管理画面へ遷移する
		if("account_management".equals(buttonType)) {
			req.setAttribute("url","account_management");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		// 商品検索ボタン押下時
		if("product_search".equals(buttonType)) {
			req.setAttribute("url","product_search");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		// 商品登録ボタン押下時
		if("product_regist".equals(buttonType)) {
			// イメージ選択用のリストボックス。
			req.setAttribute("productList",proService.showImage());
			req.setAttribute("url","product_regist");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		// 【上記以外】 前回のセッション情報を削除する
		HttpSession session = req.getSession(true);
		session.removeAttribute("account");
		
		// ログイン画面へ遷移する
		req.setAttribute("url","logout");
		resp.sendRedirect("./index.jsp");
		
		}
}
